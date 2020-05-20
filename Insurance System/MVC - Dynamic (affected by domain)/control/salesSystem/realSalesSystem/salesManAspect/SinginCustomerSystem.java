package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.customerData.CustomerData;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class SinginCustomerSystem extends SalesSystem {
	// Static
	private enum EActionCommands {SaveCustomerData}
	
	// Component
	private TitledTextArea nameTTA = new TitledTextArea("이름", 1, "", true);
	private TitledTextArea residenceTTA = new TitledTextArea("거주지", 2, "", true);
	private TitledTextArea phoneNumTTA = new TitledTextArea("전화번호", 1, "", true);
	
	private TitledTextArea emailTTA = new TitledTextArea("이메일", 1, "", true);
//	private TitledTextArea familyillhistoryTTA = new TitledTextArea("가족력", 1, "", true);
	private TitledTextArea socialSecurityNumTTA = new TitledTextArea("주민번호", 1, "", true);
//	private TitledTextArea genderTTA = new TitledTextArea("성별", 1, "", true);
	private TitledTextArea jobTTA = new TitledTextArea("직업", 1, "", true);
	private TitledTextArea propertyTTA = new TitledTextArea("재산", 1, "", true);
//	private TitledTextArea accidentHistoryTTA = new TitledTextArea("사고 이력", 1, "", true);
	private TitledTextArea ageTTA = new TitledTextArea("나이", 1, "", true);
	private TitledTextArea accountNumTTA = new TitledTextArea("계좌번호", 1, "", true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("고객 정보를 입력해 주세요"));
		viewInfo.add(this.nameTTA);
		viewInfo.add(this.socialSecurityNumTTA);
		viewInfo.add(this.phoneNumTTA);
		viewInfo.add(this.emailTTA);
		viewInfo.add(this.residenceTTA);

		viewInfo.add(this.jobTTA);
		viewInfo.add(this.propertyTTA);
		viewInfo.add(this.ageTTA);
		
		viewInfo.add(this.accountNumTTA);
		
		viewInfo.add(new BasicButton("저장", EActionCommands.SaveCustomerData.name(), this.actionListener));
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveCustomerData : this.save(); this.gotoBack(); break;
		}
		return null;
	}
	private void save() {
		CustomerData data = new CustomerData();
		data.setName(this.nameTTA.getContent());
		data.setResidence(this.residenceTTA.getContent());
		data.setPhoneNum(this.phoneNumTTA.getContent());
		data.setEmail(this.emailTTA.getContent());
		data.setSocialSecurityNum(this.socialSecurityNumTTA.getContent());
		data.setJob(this.jobTTA.getContent());
		data.setProperty(Integer.parseInt(this.propertyTTA.getContent()));
		data.setAge(Integer.parseInt(this.ageTTA.getContent()));
		data.setAccountNum(this.accountNumTTA.getContent());
		
		this.customerDataList.add(data);
		
//		for(InsuranceRatePermitManData employee : this.insuranceRatePermitManList.getList()) {
//			if(employee.isWorkable()) {employee.addTask(new InsuranceRatePermit(data.getID()));}
//		}
		// customer는 딱히... 뭐 전달하거나 할건 없으니까 바로 다른 사람한테 일로 주는 게 아님
	}

}
