package model.data.taskData.rewardTask;

import model.data.taskData.AbsTask;

public class AccidentInvestigationTask extends AbsTask{
	
	// Attribute
	private int rewardDataID;

	// Constructor
	public AccidentInvestigationTask(int rewardDataID) {this.rewardDataID=rewardDataID;}
	
	// Getter & Setter
	public int getRewardDataID() {return this.rewardDataID;}
}
