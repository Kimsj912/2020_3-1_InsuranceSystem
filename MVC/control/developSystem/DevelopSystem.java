package control.developSystem;


import control.DynamicSystem;
import model.aConstant.EDataListID;
import data.ISData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import java.util.Vector;

public abstract class DevelopSystem extends DynamicSystem {

	// Associate
	protected IntISDataList<DeveloperData> developerList;
	protected IntISDataList<InsuranceRatePermitManData> insuranceRatePermitManList;
	protected IntISDataList<ProductPermitManData> productPermitManList;
	protected IntISDataList<AbsInsuranceData> insuranceList;
	
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntISDataList<? extends ISData>> datas) {
		for(IntISDataList<? extends ISData> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case DeveloperDataListID : this.developerList=(IntISDataList<DeveloperData>) model; break;
			case InsuranceRatePermitManDataListID : this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) model; break;
			case ProductPermitManDataListID : this.productPermitManList=(IntISDataList<ProductPermitManData>) model; break;
			case InsuranceDataListID : this.insuranceList=(IntISDataList<AbsInsuranceData>) model; break;
			default : break;
			}
		}
	}
}
