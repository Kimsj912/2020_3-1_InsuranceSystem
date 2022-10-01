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
		this.nameTTA = new InputTextArea("이름", "", 1, 100);
		this.residenceTTA = new InputTextArea("거주지", "도로명 주소를 입력해주세요", 1, 100);
		this.phoneNumTTA = new InputTextArea("전화번호", "ex) 010-1234-5678", 1, 100);
		this.emailTTA = new InputTextArea("이메일", "ex) abcd123@gmail.com", 1, 100);
		this.familyillhistoryRBN = new TitledRadioButtonGroup("가족력", EFamilyIllHistory.class, true,100);
		this.socialSecurityNumTTA = new InputTextArea("주민번호", "ex) 123456-1234567", 1, 100);
		this.genderRBN = new TitledRadioButtonGroup("성별", EGender.class, false,100);
		this.jobTTA = new InputTextArea("직업", "ex) 학생, 사무직, 현장직 ", 1, 100);
		this.propertyTTA = new InputTextArea("재산", "ex) 10000000", 1, 100);
		this.accidentHistoryRBN = new TitledRadioButtonGroup("사고 이력", EAccidentHistory.class, true,100);
		this.ageTTA = new InputTextArea("나이", "ex) 30", 1, 100);
		this.accountNumTTA = new InputTextArea("계좌번호", "ex) 123-456-789012", 1, 100);
		this.loginIDTTA = new InputTextArea("아이디", "", 1, 100);
		this.loginPWTTA = new InputTextArea("비밀번호", "", 1, 100);

		//add component
		this.addComponent(new BasicLabel("고객 정보 입력"));
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
		
		this.addComponent(new ActionButton("저장", SinginCustomerSystem.EActionCommands.Save.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton("고객 가입", SinginCustomerSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", SinginCustomerSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", SinginCustomerSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", SinginCustomerSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
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
