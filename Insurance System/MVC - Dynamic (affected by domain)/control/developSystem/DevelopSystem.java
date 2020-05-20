package control.developSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.ISData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntISDataList;

public abstract class DevelopSystem extends DynamicSystem {

	// Associate
	protected IntISDataList<DeveloperData> developerList;
	protected IntISDataList<InsuranceRatePermitManData> insuranceRatePermitManList;
	protected IntISDataList<ProductPermitManData> productPermitManList;
	
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntISDataList<? extends ISData>> datas) {
		for(IntISDataList<? extends ISData> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case DeveloperDataListID : this.developerList=(IntISDataList<DeveloperData>) model; break;
			case InsuranceRatePermitManDataListID : this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) model; break;
			case ProductPermitManDataListID : this.productPermitManList=(IntISDataList<ProductPermitManData>) model; break;
			case InsuranceDataListID : this.insuranceDataList=(IntISDataList<AbsInsuranceData>) model; break;
			default:
				break;
			
			}
		}
	}
}
