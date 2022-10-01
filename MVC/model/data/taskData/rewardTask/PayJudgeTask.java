package model.data.taskData.rewardTask;

import model.data.taskData.AbsTask;

public class PayJudgeTask extends AbsTask{
	
	// Attribute
	private int rewardDataID;	
	
	// Constructor
	public PayJudgeTask(int customerDataID) {this.rewardDataID=customerDataID;}
	
	// Getter & Setter
	public int getRewardDataID() {return rewardDataID;}
}
