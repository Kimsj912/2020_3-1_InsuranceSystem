package control.salesSystem.realSalesSystem.salesManAspect.SigninCustomer;

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
	// Component
	private TitledTextArea nameTTA = new TitledTextArea("�̸�", 1, "", true);
	private TitledTextArea residenceTTA = new TitledTextArea("������", 2, "", true);
	private TitledTextArea phoneNumTTA = new TitledTextArea("��ȭ��ȣ", 1, "", true);
	private TitledTextArea emailTTA = new TitledTextArea("�̸���", 1, "", true);
	private TitledRadioButtonGroup familyillhistoryRBN = new TitledRadioButtonGroup("������",EFamilyIllHistory.class , true);
	private TitledTextArea socialSecurityNumTTA = new TitledTextArea("�ֹι�ȣ", 1, "", true);
	private TitledRadioButtonGroup genderRBN = new TitledRadioButtonGroup("����", EGender.class, false);
	private TitledTextArea jobTTA = new TitledTextArea("����", 1, "", true);
	private TitledTextArea propertyTTA = new TitledTextArea("���", 1, "", true);
	private TitledRadioButtonGroup accidentHistoryRBN = new TitledRadioButtonGroup("��� �̷�",EAccidentHistory.class, true);
	private TitledTextArea ageTTA = new TitledTextArea("����", 1, "", true);
	private TitledTextArea accountNumTTA = new TitledTextArea("���¹�ȣ", 1, "", true);
	private TitledTextArea loginIDTTA = new TitledTextArea("���̵�", 1, "", true);
	private TitledTextArea loginPWTTA = new TitledTextArea("��й�ȣ", 1, "", true);
	
	@Override
	public Vector<JComponent> getViewInfo() {

		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("�� ������ �Է��� �ּ���"));
		viewInfo.add(this.nameTTA);
		viewInfo.add(this.socialSecurityNumTTA);
		viewInfo.add(this.genderRBN); 
		
		viewInfo.add(this.loginIDTTA);
		viewInfo.add(this.loginPWTTA);
		
		viewInfo.add(this.phoneNumTTA);
		viewInfo.add(this.emailTTA);
		viewInfo.add(this.residenceTTA);
		viewInfo.add(this.familyillhistoryRBN);
		viewInfo.add(this.accidentHistoryRBN);
		viewInfo.add(this.jobTTA);
		viewInfo.add(this.propertyTTA);
		viewInfo.add(this.ageTTA);
		viewInfo.add(this.accountNumTTA);
		
		viewInfo.add(new BasicButton("����", EActionCommands.Save.name(), this.actionListener));

		
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
			data.setName(this.nameTTA.getContent());
			data.setResidence(this.residenceTTA.getContent());
			data.setLoginID(this.loginIDTTA.getContent());
			data.setLoginPW(this.loginPWTTA.getContent());
			data.setPhoneNum(this.phoneNumTTA.getContent());
			data.setEmail(this.emailTTA.getContent());
			data.setSocialSecurityNum(this.socialSecurityNumTTA.getContent());
			data.setJob(this.jobTTA.getContent());
			data.setProperty(Integer.parseInt(this.propertyTTA.getContent()));
			data.setAge(Integer.parseInt(this.ageTTA.getContent()));
			data.setAccountNum(this.accountNumTTA.getContent());
			data.setJoinedInsuranceData(new Vector<AbsInsuranceData>());
			data.setIllHistory(EFamilyIllHistory.valueOf(this.familyillhistoryRBN.getSelectedOptionNames().get(0)));
			data.setAccidentHistory(EAccidentHistory.valueOf(this.accidentHistoryRBN.getSelectedOptionNames().get(0)));
			data.setGender(EGender.valueOf(this.genderRBN.getSelectedOptionNames().get(0)));
			this.customerDataList.add(data);
		
		} catch (DateTimeParseException|NumberFormatException e) {
			JOptionPane.showMessageDialog(this.panel, "�Է� ������ �ٽ��ѹ� Ȯ�����ֽʽÿ�.");
			return false;
		}
		return true;
	}
	
	public void mutipleChoice() {
		
	}

}
