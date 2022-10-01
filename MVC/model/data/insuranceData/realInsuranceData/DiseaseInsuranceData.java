package model.data.insuranceData.realInsuranceData;

import model.aConstant.EFamilyIllHistory;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;

public class DiseaseInsuranceData extends AbsInsuranceData {

	// Attribute
	public enum EDisease {CANCER, HEARTH_ATTACK};
	private EDisease disease; 
			
	// Any Time Use
	@Override 
	public double insuranceRateCheck(CustomerData data) {
		double result = 1;
		for(EFamilyIllHistory history : data.getIllHistory()) {
			switch(history) {
			case Cancer : result*=2; break;
			case Diabetes : result*=1.1; break;
			case HeartDisease : result*=1.3; break;
			case HighBloodPressure : result*=1.1; break;
			case Stroke : result*=1.3; break;
			}
		}
		if(data.getAge()>80) {result*=1.5;}
		else if(data.getAge()>60) {result*=1.4;}
		else if(data.getAge()>40) {result*=1.3;}
		if(data.isMale()) {result*=1.1;}
		return result;
	}
	
	// Getter & Setter
	public EDisease getDisease() {return this.disease;}
	public void setDisease(EDisease disease) {this.disease = disease;}
}
