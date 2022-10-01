package model.data.employeeData.rewardEmployeeData;

import model.data.employeeData.AbsEmployeeData;
import model.data.taskData.rewardTask.AccidentInvestigationTask;

public class AccidentInvestigatorData extends AbsEmployeeData<AccidentInvestigationTask> {
	
	// Attributes
	public String chargeArea;

	public String getChargeArea() {return chargeArea;}
	public void setChargeArea(String chargeArea) {this.chargeArea = chargeArea;}
}
