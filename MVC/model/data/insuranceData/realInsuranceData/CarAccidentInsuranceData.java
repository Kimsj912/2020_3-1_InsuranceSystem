package model.data.insuranceData.realInsuranceData;

import model.aConstant.EAccidentHistory;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;

public class CarAccidentInsuranceData extends AbsInsuranceData {

	// Any Time Use
	@Override 
	public double insuranceRateCheck(CustomerData data) {
		double result = 1;
		for(EAccidentHistory history : data.getAccidentHistory()) {
			switch(history) {
			case TotalLoss : result*=1.3; break;
			case DamageForOhterCar : result*=1.2; break;
			case DamageToMyCar : result*=1.1; break;
			case Immersion  : result*=1.1; break;
			case Theft  : result*=1.1; break;
			}
		}
		if(data.getAge()<30) {result*=1.1;}
		if(!data.isMale()) {result*=1.1;}
		return result;
	}
}
