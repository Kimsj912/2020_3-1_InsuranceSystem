package model.data.customerData;

import java.util.Vector;

import model.aConstant.EAccidentHistory;
import model.aConstant.EFamilyIllHistory;
import model.aConstant.EGender;
import model.data.employeeData.AbsEmployeeData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.AbsTask;

public class CustomerData extends AbsEmployeeData<AbsTask> {
	
	// Attributes
	private EAccidentHistory accidentHistory;
	private EFamilyIllHistory illHistory;
	private String accountNum, email, job, name, phoneNum, residence, socialSecurityNum;
	private int age, property;
	private int[] signInInsurance;
	private EGender gender;
	private boolean paymentPermit;
	private Vector<AbsInsuranceData> joinedInsuranceData;
	
	
	
	// Constructor
	public CustomerData() {
		// Set Attribute
		this.paymentPermit = false;
	}

	// Getter & Setter
	public String getAccountNum() {return accountNum;}
	public EAccidentHistory getAccidentHistory() {return accidentHistory;}
	public void setAccidentHistory(EAccidentHistory eAccidentHistory) {this.accidentHistory = eAccidentHistory;}
	public EFamilyIllHistory getIllHistory() {return illHistory;}
	public void setIllHistory(EFamilyIllHistory eFamilyIllHistory) {this.illHistory = eFamilyIllHistory;}
	public void setAccountNum(String accountNum) {this.accountNum = accountNum;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public EGender isGender() {return gender;}
	public void setGender(EGender vector) {this.gender = vector;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public int getProperty() {return property;}
	public void setProperty(int property) {this.property = property;}
	public String getResidence() {return residence;}
	public void setResidence(String residence) {this.residence = residence;}
	public int[] getSignInInsurance() {return signInInsurance;}
	public void setSignInInsurance(int[] signInInsurance) {this.signInInsurance = signInInsurance;}
	public String getSocialSecurityNum() {return socialSecurityNum;}
	public void setSocialSecurityNum(String socialSecurityNum) {this.socialSecurityNum = socialSecurityNum;}
	public boolean isPaymentPermit() {return this.paymentPermit;}
	public void PaymentPermit() {this.paymentPermit = true;}
	public Vector<AbsInsuranceData> getJoinedInsuranceData() {return joinedInsuranceData;}

	public void setJoinedInsuranceData(Vector<AbsInsuranceData> joinedInsuranceData) {
		this.joinedInsuranceData = joinedInsuranceData;
	}

}
