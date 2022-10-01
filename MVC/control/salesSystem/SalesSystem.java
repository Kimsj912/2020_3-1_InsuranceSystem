package control.salesSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import data.ISData;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.data.activityPlanData.ActivityPlanData;
import model.data.customerData.CustomerData;
import model.data.employeeData.salesEmployeeData.SalesManData;
import model.data.employeeData.salesEmployeeData.SalesManagerData;
import model.data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;

public abstract class SalesSystem extends DynamicSystem {

	// Associate - person
	protected IntISDataList<SalesManData> salesManList;
	protected IntISDataList<SalesManagerData> salesManagerList;
	protected IntISDataList<ActivityPlanData> activityPlanList;
	protected IntISDataList<SalesTrainingPlanData> salesTrainigPlanList;
	protected IntISDataList<CustomerData> customerDataList;
	protected IntISDataList<AbsInsuranceData> insuranceDataList;

	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntISDataList<? extends ISData>> datas) {
		for(IntISDataList<? extends ISData> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case SalesManDataListID : this.salesManList=(IntISDataList<SalesManData>) model; break;
			case SalesManagerDataListID : this.salesManagerList=(IntISDataList<SalesManagerData>) model; break;
			case ActivityPlanDataListID : this.activityPlanList = (IntISDataList<ActivityPlanData>) model; break;
			case SalesTrainigPlanDataListID : this.salesTrainigPlanList = (IntISDataList<SalesTrainingPlanData>) model; break;
			case CustomerDataListID : this.customerDataList = (IntISDataList<CustomerData>) model; break;
			case InsuranceDataListID : this.insuranceDataList = (IntISDataList<AbsInsuranceData>) model; break;
			default : break;
			}
		}
	}
}
