package view.insuranceSystemView.salesView.salesMan.SigninCustomer;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import model.aConstant.EAccidentHistory;
import model.aConstant.EFamilyIllHistory;
import model.aConstant.EGender;
import component.BasicLabel;
import component.SeparateLine;
import component.TitledRadioButtonGroup;
import component.button.ActionButton;
import component.button.LinkButton;
import component.group.StaticGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class SinginCustomerView extends InsuranceSystemView{
	private static final long serialVersionUID = 1L;

	// Component
	private InputTextArea nameTTA, residenceTTA,phoneNumTTA,emailTTA,socialSecurityNumTTA,jobTTA,propertyTTA,ageTTA,accountNumTTA,loginIDTTA,loginPWTTA;
	private TitledRadioButtonGroup familyillhistoryRBN,genderRBN,accidentHistoryRBN;
	
	public SinginCustomerView(ActionListener actionListener) {
		//create component
		this.nameTTA = new InputTextArea("�̸�", "", 1, 100);
		this.residenceTTA = new InputTextArea("������", "���θ� �ּҸ� �Է����ּ���", 1, 100);
		this.phoneNumTTA = new InputTextArea("��ȭ��ȣ", "ex) 010-1234-5678", 1, 100);
		this.emailTTA = new InputTextArea("�̸���", "ex) abcd123@gmail.com", 1, 100);
		this.familyillhistoryRBN = new TitledRadioButtonGroup("������", EFamilyIllHistory.class, true,100);
		this.socialSecurityNumTTA = new InputTextArea("�ֹι�ȣ", "ex) 123456-1234567", 1, 100);
		this.genderRBN = new TitledRadioButtonGroup("����", EGender.class, false,100);
		this.jobTTA = new InputTextArea("����", "ex) �л�, �繫��, ������ ", 1, 100);
		this.propertyTTA = new InputTextArea("���", "ex) 10000000", 1, 100);
		this.accidentHistoryRBN = new TitledRadioButtonGroup("��� �̷�", EAccidentHistory.class, true,100);
		this.ageTTA = new InputTextArea("����", "ex) 30", 1, 100);
		this.accountNumTTA = new InputTextArea("���¹�ȣ", "ex) 123-456-789012", 1, 100);
		this.loginIDTTA = new InputTextArea("���̵�", "", 1, 100);
		this.loginPWTTA = new InputTextArea("��й�ȣ", "", 1, 100);

		//add component
		this.addComponent(new BasicLabel("�� ���� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g =  new StaticGroup(new int[] {2,2,1,1,2,2,2,2});
		g.addGroupComponent(
				this.nameTTA,this.socialSecurityNumTTA,
				this.ageTTA,this.genderRBN,
				this.residenceTTA,this.jobTTA,
				this.phoneNumTTA,this.emailTTA, 
				this.familyillhistoryRBN,this.accidentHistoryRBN,
				this.propertyTTA,this.accountNumTTA,
				this.loginIDTTA,this.loginPWTTA
				);
		this.addComponent(g);
		
		this.addComponent(new ActionButton("����", SinginCustomerSystem.EActionCommands.Save.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton("�� ����", SinginCustomerSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", SinginCustomerSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", SinginCustomerSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", SinginCustomerSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
		
	}

	
	//get & set
	public InputTextArea getNameTTA() {return nameTTA;}
	public void setNameTTA(InputTextArea nameTTA) {	this.nameTTA = nameTTA;}
	public InputTextArea getResidenceTTA() {return residenceTTA;}
	public void setResidenceTTA(InputTextArea residenceTTA) {this.residenceTTA = residenceTTA;}
	public InputTextArea getPhoneNumTTA() {return phoneNumTTA;}
	public void setPhoneNumTTA(InputTextArea phoneNumTTA) {this.phoneNumTTA = phoneNumTTA;}
	public InputTextArea getEmailTTA() {return emailTTA;}
	public void setEmailTTA(InputTextArea emailTTA) {this.emailTTA = emailTTA;}
	public InputTextArea getSocialSecurityNumTTA() {return socialSecurityNumTTA;}
	public void setSocialSecurityNumTTA(InputTextArea socialSecurityNumTTA) {this.socialSecurityNumTTA = socialSecurityNumTTA;}
	public InputTextArea getJobTTA() {return jobTTA;}
	public void setJobTTA(InputTextArea jobTTA) {this.jobTTA = jobTTA;}
	public InputTextArea getPropertyTTA() {return propertyTTA;}
	public void setPropertyTTA(InputTextArea propertyTTA) {this.propertyTTA = propertyTTA;}
	public InputTextArea getAgeTTA() {return ageTTA;}
	public void setAgeTTA(InputTextArea ageTTA) {this.ageTTA = ageTTA;}
	public InputTextArea getAccountNumTTA() {return accountNumTTA;}
	public void setAccountNumTTA(InputTextArea accountNumTTA) {this.accountNumTTA = accountNumTTA;}
	public InputTextArea getLoginIDTTA() {return loginIDTTA;}
	public void setLoginIDTTA(InputTextArea loginIDTTA) {this.loginIDTTA = loginIDTTA;}
	public InputTextArea getLoginPWTTA() {return loginPWTTA;}
	public void setLoginPWTTA(InputTextArea loginPWTTA) {this.loginPWTTA = loginPWTTA;}
	public TitledRadioButtonGroup getFamilyillhistoryRBN() {return familyillhistoryRBN;}
	public void setFamilyillhistoryRBN(TitledRadioButtonGroup familyillhistoryRBN) {this.familyillhistoryRBN = familyillhistoryRBN;}
	public TitledRadioButtonGroup getGenderRBN() {return genderRBN;}
	public void setGenderRBN(TitledRadioButtonGroup genderRBN) {this.genderRBN = genderRBN;	}
	public TitledRadioButtonGroup getAccidentHistoryRBN() {return accidentHistoryRBN;}
	public void setAccidentHistoryRBN(TitledRadioButtonGroup accidentHistoryRBN) {this.accidentHistoryRBN = accidentHistoryRBN;}

	
}
