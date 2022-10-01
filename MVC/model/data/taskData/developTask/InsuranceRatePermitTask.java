package model.data.taskData.developTask;

import model.data.taskData.AbsTask;

public class InsuranceRatePermitTask extends AbsTask {

	// Attribute
	private int targetInsuranceID;
	
	// Constructor
	public InsuranceRatePermitTask(int targetInsuranceID) {this.targetInsuranceID=targetInsuranceID;}
	
	// Getter & Setter
	public int getTargetInsuranceID() {return this.targetInsuranceID;}
}
