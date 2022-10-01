package model.data.insuranceData.realInsuranceData;

import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;

public class FireInsuranceData extends AbsInsuranceData {

	// Any Time Use
	@Override 
	public double insuranceRateCheck(CustomerData data) {
		double result = 1;
		if(data.getProperty() > 100000000) {result*=1.5;}
		else if(data.getProperty() > 10000000) {result*=1.4;}
		else if(data.getProperty() > 1000000) {result*=1.3;}
		else if(data.getProperty() > 100000) {result*=1.2;}
		return result;
	}
}
