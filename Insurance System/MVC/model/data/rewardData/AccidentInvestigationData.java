package model.data.rewardData;

public class AccidentInvestigationData{

	// Attributes
	private String scenario, damage, treatment;
	private int treatmentCost;
	
	// Getter & Setter
	public String getScenario() {return scenario;}
	public void setScenario(String scenario) {this.scenario = scenario;}
	public String getDamage() {return damage;}
	public void setDamage(String damage) {this.damage = damage;}
	public String getTreatment() {return treatment;}
	public void setTreatment(String treatment) {this.treatment = treatment;}
	public int getTreatmentCost() {return treatmentCost;}
	public void setTreatmentCost(int treatmentCost) {this.treatmentCost = treatmentCost;}
}
