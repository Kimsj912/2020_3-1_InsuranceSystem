package model.data.taskData.realTaskData;

import model.data.taskData.AbsTask;

public class InsuranceRatePermit extends AbsTask {

	// Attribute
	
	private int targetInsuranceID;
	
	// Constructor
	public InsuranceRatePermit(int targetInsuranceID) {this.targetInsuranceID=targetInsuranceID;}
	
	// Getter & Setter
	public int getTargetInsuranceID() {return this.targetInsuranceID;}
}
