package model.data.taskData.rewardTask;

import model.data.taskData.AbsTask;

public class LossCheckTask extends AbsTask{
	
	// Attribute
	private int rewardDataID;	
	
	// Constructor
	public LossCheckTask(int customerDataID) {this.rewardDataID=customerDataID;}
	
	// Getter & Setter
	public int getRewardDataID() {return rewardDataID;}
}
