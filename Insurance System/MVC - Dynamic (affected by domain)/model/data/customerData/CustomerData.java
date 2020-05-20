package model.data.customerData;

import model.data.ISData;

public class CustomerData extends ISData {
	// Attribute
	private String name;
	private String residence;
	private String phoneNum;
	private String email;
	private int[] signInInsurance;
	private String socialSecurityNum;
	private String job;
	private String property;
	private String age;
	private String accountNum;
	
	
	// add & delete & search
	public void addSignInInsurance(int insuranceNum) {
		int length = this.signInInsurance.length;
		this.signInInsurance[length]=insuranceNum;
		//sorting«ÿ¡Ÿ ∞Õ.
	}
	
	// getter & setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getResidence() {return residence;}
	public void setResidence(String residence) {this.residence = residence;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getSocialSecurityNum() {return socialSecurityNum;}
	public void setSocialSecurityNum(String socialSecurityNum) {this.socialSecurityNum = socialSecurityNum;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	public String getProperty() {return property;}
	public void setProperty(String property) {this.property = property;}
	public String getAge() {return age;}
	public void setAge(String age) {this.age = age;}
	public String getAccountNum() {return accountNum;}
	public void setAccountNum(String accountNum) {this.accountNum = accountNum;}
	
	
}
