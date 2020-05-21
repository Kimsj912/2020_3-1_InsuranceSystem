package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.EAccidentHistory;
import model.aConstant.EFamilyIllHistory;
import model.aConstant.EGender;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import view.component.BasicButton;
import view.component.TitledRadioButtonGroup;
import view.component.TitledTextArea;

public class SinginCustomerSystem extends SalesSystem {
	// Static
	private enum EActionCommands {Save}
	private enum EInitializingCommands {phoneNum,email,residence,job,property,	socialSecurityNum, mainTitle, name, age,accountNum, familyillhistory, gender, accidentHistory}
	// Component
	private LinkedHashMap<String, JComponent> pocket;
	
	@Override
	public Vector<JComponent> getViewInfo() {
		
		this.pocket = new LinkedHashMap<String, JComponent>();
	
		TitledTextArea nameTTA = new TitledTextArea("이름", 1, "", true);
		TitledTextArea residenceTTA = new TitledTextArea("거주지", 2, "", true);
		TitledTextArea phoneNumTTA = new TitledTextArea("전화번호", 1, "", true);
		
		TitledTextArea emailTTA = new TitledTextArea("이메일", 1, "", true);
		TitledRadioButtonGroup familyillhistoryRBN = new TitledRadioButtonGroup("가족력",EFamilyIllHistory.class , true);
		TitledTextArea socialSecurityNumTTA = new TitledTextArea("주민번호", 1, "", true);
		TitledRadioButtonGroup genderRBN = new TitledRadioButtonGroup("성별", EGender.class, false);
		TitledTextArea jobTTA = new TitledTextArea("직업", 1, "", true);
		TitledTextArea propertyTTA = new TitledTextArea("재산", 1, "", true);
		TitledRadioButtonGroup accidentHistoryRBN = new TitledRadioButtonGroup("사고 이력",EAccidentHistory.class, true);
		TitledTextArea ageTTA = new TitledTextArea("나이", 1, "", true);
		TitledTextArea accountNumTTA = new TitledTextArea("계좌번호", 1, "", true);
		BasicButton saveBTN = new BasicButton("저장", EActionCommands.Save.name(), this.actionListener);
		
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		this.pocket.put(EInitializingCommands.mainTitle.name(),new JLabel("고객 정보를 입력해 주세요"));
		this.pocket.put(EInitializingCommands.name.name(), nameTTA);
		this.pocket.put(EInitializingCommands.socialSecurityNum.name(),socialSecurityNumTTA);
		this.pocket.put(EInitializingCommands.phoneNum.name(),phoneNumTTA);
		this.pocket.put(EInitializingCommands.email.name(),emailTTA);
		this.pocket.put(EInitializingCommands.familyillhistory.name(),familyillhistoryRBN);
		
		this.pocket.put(EInitializingCommands.residence.name(),residenceTTA);
		this.pocket.put(EInitializingCommands.gender.name(),genderRBN);

		this.pocket.put(EInitializingCommands.job.name(),jobTTA);
		this.pocket.put(EInitializingCommands.property.name(),propertyTTA);
		this.pocket.put(EInitializingCommands.accidentHistory.name(),accidentHistoryRBN);
		this.pocket.put(EInitializingCommands.age.name(),ageTTA);
		this.pocket.put(EInitializingCommands.accountNum.name(),accountNumTTA);
		
		
		for(JComponent jc :this.pocket.values()) {
			viewInfo.add(jc);
		}
		viewInfo.add(saveBTN);
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save : if(this.save()) { this.gotoBack(); break;}
		}
		return null;
	}
	private boolean save() {
		try {
			CustomerData data = new CustomerData();
			data.setName(((TitledTextArea) this.pocket.get(EInitializingCommands.name.name())).getContent());
			data.setResidence(((TitledTextArea) this.pocket.get(EInitializingCommands.residence.name())).getContent());
			data.setPhoneNum(((TitledTextArea) this.pocket.get(EInitializingCommands.phoneNum.name())).getContent());
			data.setEmail(((TitledTextArea) this.pocket.get(EInitializingCommands.email.name())).getContent());
			data.setSocialSecurityNum(
					((TitledTextArea) this.pocket.get(EInitializingCommands.socialSecurityNum.name())).getContent());
			
			data.setJob(((TitledTextArea) this.pocket.get(EInitializingCommands.job.name())).getContent());
			data.setProperty(Integer
					.parseInt(((TitledTextArea) this.pocket.get(EInitializingCommands.property.name())).getContent()));
			data.setAge(Integer
					.parseInt(((TitledTextArea) this.pocket.get(EInitializingCommands.age.name())).getContent()));
			data.setAccountNum(((TitledTextArea) this.pocket.get(EInitializingCommands.accountNum.name())).getContent());
			data.setJoinedInsuranceData(new Vector<AbsInsuranceData>());
			
			// 골치덩어리
			data.setIllHistory(cleaningFamilyRadioBtn(((TitledRadioButtonGroup) this.pocket.get(EInitializingCommands.familyillhistory.name())).getSelectedOptionNames()));
			data.setAccidentHistory(cleaningAccidentRadioBtn(((TitledRadioButtonGroup) this.pocket.get(EInitializingCommands.accidentHistory.name())).getSelectedOptionNames()));
			data.setGender(cleaningGenderRadioBtn(((TitledRadioButtonGroup) this.pocket.get(EInitializingCommands.gender.name())).getSelectedOptionNames()));
			this.customerDataList.add(data);
		
		} catch (DateTimeParseException|NumberFormatException e) {
			JOptionPane.showMessageDialog(this.panel, "입력 내용을 다시한번 확인해주십시오.");
			return false;
		}
		return true;
	}
	
	public Vector<EFamilyIllHistory> cleaningFamilyRadioBtn(Vector<String> names) {
		Vector<EFamilyIllHistory> enumtmp = new Vector<EFamilyIllHistory>();
		for (String s : names) {
			for (EFamilyIllHistory aEnum : EFamilyIllHistory.values()) {
				if (aEnum.toString().equals(s)) enumtmp.add(aEnum);
			}
		}
		return enumtmp;
	}
	public Vector<EGender> cleaningGenderRadioBtn(Vector<String> names) {
		Vector<EGender> enumtmp = new Vector<EGender>();
		for (String s : names) {
			for (EGender aEnum : EGender.values()) {
				if (aEnum.toString().equals(s)) enumtmp.add(aEnum);
			}
		}
		return enumtmp;
	}
	public Vector<EAccidentHistory> cleaningAccidentRadioBtn(Vector<String> names) {
		Vector<EAccidentHistory> enumtmp = new Vector<EAccidentHistory>();
		for (String s : names) {
			for (EAccidentHistory aEnum : EAccidentHistory.values()) {
				if (aEnum.toString().equals(s)) enumtmp.add(aEnum);
			}
		}
		return enumtmp;
	}
	

}
