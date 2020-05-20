package control.loginSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.ISData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.employeeData.salesEmployeeData.SalesManData;
import model.data.employeeData.salesEmployeeData.SalesManagerData;
import model.dataList.IntISDataList;

public abstract class LoginSystem extends DynamicSystem {

	// Associate
	protected IntISDataList<DeveloperData> developerList;
	protected IntISDataList<InsuranceRatePermitManData> insuranceRatePermitManList;
	protected IntISDataList<ProductPermitManData> productPermitManList;
	protected IntISDataList<SalesManData> salesManList;
	protected IntISDataList<SalesManagerData> salesManagerList;
	
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntISDataList<? extends ISData>> datas) {
		for(IntISDataList<? extends ISData> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case DeveloperDataListID : this.developerList=(IntISDataList<DeveloperData>) model; break;
			case InsuranceRatePermitManDataListID : this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) model; break;
			case ProductPermitManDataListID : this.productPermitManList=(IntISDataList<ProductPermitManData>) model; break;
			case SalesManDataListID : this.salesManList=(IntISDataList<SalesManData>) model; break;
			case SalesManagerDataListID : this.salesManagerList=(IntISDataList<SalesManagerData>) model; break;
			default : break;
			}
		}
	}
}
