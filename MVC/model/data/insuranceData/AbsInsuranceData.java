package model.data.insuranceData;

import java.util.Vector;

import data.ISData;
import model.data.customerData.CustomerData;

public abstract class AbsInsuranceData extends ISData {
	
	// Attribute
	private String name, content, insuranceRateInfo;
	private double lossPercent;
	private boolean insuranceratePermit, productPermit;
	
	// Component
	private Vector<Integer> customerIDs;

	// Constructor
	public AbsInsuranceData() {
		// Set Attribute
		this.insuranceratePermit = false;
		this.productPermit = false;
				
		// Create Component
		this.customerIDs = new Vector<Integer>(); 
	}

	// Any Time Use
	public abstract double insuranceRateCheck(CustomerData data);
	public void addCustomerID(int id) {this.customerIDs.add(id);}
	public void deleteCustomerID(int id) {this.customerIDs.remove(Integer.valueOf(id));}
	public boolean isCustomerSignIn(int id) {return this.customerIDs.contains(Integer.valueOf(id));}
	
	// Getter & Setter
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	public String getContent() {return this.content;}
	public void setContent(String content) {this.content = content;}
	public String getInsuranceRateInfo() {return this.insuranceRateInfo;}
	public void setInsuranceRateInfo(String insuranceRateInfo) {this.insuranceRateInfo = insuranceRateInfo;}
	public double getLossPercent() {return this.lossPercent;}
	public void setLossPercent(double lossPercent) {this.lossPercent = lossPercent;}
	public boolean isInsuranceratePermit() {return this.insuranceratePermit;}
	public void permitInsuranceRate() {this.insuranceratePermit = true;}
	public boolean isProductPermit() {return this.productPermit;}
	public void permitProduct() {this.productPermit = true;}
}
