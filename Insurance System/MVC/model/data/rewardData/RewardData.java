package model.data.rewardData;

import model.data.ISData;

public class RewardData extends ISData {

	// Attribute
	private int customerID;
	
	// Association
	private AccidentData accidentData;
	private AccidentInvestigationData accidentInvestigationData;
	private PayJudgeData payJudgeData;
	private LossCheckData lossData;
	private LawsuitData lawsuitData;

	// Getter & Setter
	public int getCustomerID() {return customerID;}
	public void setCustomerID(int customerID) {this.customerID = customerID;}
	public AccidentData getAccidentData() {return accidentData;}
	public void setAccidentData(AccidentData accidentData) {this.accidentData = accidentData;}
	public AccidentInvestigationData getAccidentInvestigationData() {return accidentInvestigationData;}
	public void setAccidentInvestigationData(AccidentInvestigationData accidentInvestigationData) {this.accidentInvestigationData = accidentInvestigationData;}
	public PayJudgeData getPayJudgeData() {return payJudgeData;}
	public void setPayJudgeData(PayJudgeData payJudgeData) {this.payJudgeData = payJudgeData;}
	public LossCheckData getLossData() {return lossData;}
	public void setLossData(LossCheckData lossData) {this.lossData = lossData;}
	public LawsuitData getLawsuitData() {return lawsuitData;}
	public void setLawsuitData(LawsuitData lawsuitData) {this.lawsuitData = lawsuitData;}
}
