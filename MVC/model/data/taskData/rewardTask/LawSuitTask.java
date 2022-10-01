package model.data.taskData.rewardTask;

import model.data.taskData.AbsTask;

public class LawSuitTask extends AbsTask{
	
	// Attribute
	private int rewardDataID;	

	// Constructor
	public LawSuitTask(int customerDataID) {this.rewardDataID=customerDataID;}

	// Getter & Setter
	public int getRewardDataID() {return rewardDataID;}
}
