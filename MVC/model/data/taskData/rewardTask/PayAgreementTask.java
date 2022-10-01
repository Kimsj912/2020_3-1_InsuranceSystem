package model.data.taskData.rewardTask;

import model.data.taskData.AbsTask;

public class PayAgreementTask extends AbsTask{
	
	// Attribute
	private int rewardDataID;
	
	// Constructor
	public PayAgreementTask(int rewardDataID) {this.rewardDataID=rewardDataID;}
	
	// Getter & Setter
	public int getRewardDataID() {return this.rewardDataID;}
}
