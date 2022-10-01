package control.loginSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import data.ISData;
import model.data.customerData.CustomerData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.employeeData.salesEmployeeData.SalesManData;
import model.data.employeeData.salesEmployeeData.SalesManagerData;
import dataList.IntISDataList;

public abstract class LoginSystem extends DynamicSystem {

	// Associate
	protected IntISDataList<DeveloperData> developerList;
	protected IntISDataList<InsuranceRatePermitManData> insuranceRatePermitManList;
	protected IntISDataList<ProductPermitManData> productPermitManList;
	protected IntISDataList<CustomerData> customerList;
	protected IntISDataList<SalesManData> salesManList;
	protected IntISDataList<SalesManagerData> salesManagerList;
	protected IntISDataList<AccidentInvestigatorData> accidentInvestigatorList;
	protected IntISDataList<PayJudgerData> payJudgerList;
	protected IntISDataList<LossCheckManData> lossCheckManList;
	protected IntISDataList<LawyerData> lawyerList;
	
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntISDataList<? extends ISData>> datas) {
		for(IntISDataList<? extends ISData> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			// Develop Aspect
			case DeveloperDataListID : this.developerList=(IntISDataList<DeveloperData>) model; break;
			case InsuranceRatePermitManDataListID : this.insuranceRatePermitManList=(IntISDataList<InsuranceRatePermitManData>) model; break;
			case ProductPermitManDataListID : this.productPermitManList=(IntISDataList<ProductPermitManData>) model; break;
			case CustomerDataListID : this.customerList=(IntISDataList<CustomerData>) model; break;					
			// Sales Aspect
			case SalesManDataListID : this.salesManList=(IntISDataList<SalesManData>) model; break;
			case SalesManagerDataListID : this.salesManagerList=(IntISDataList<SalesManagerData>) model; break;
			// Reward Aspect
			case AccidentInvestigatorDataListID : this.accidentInvestigatorList=(IntISDataList<AccidentInvestigatorData>) model; break;
			case PayJudgerDataListID : this.payJudgerList=(IntISDataList<PayJudgerData>) model; break;
			case LossCheckManDataListID : this.lossCheckManList=(IntISDataList<LossCheckManData>) model; break;
			case LawyerDataListID : this.lawyerList=(IntISDataList<LawyerData>) model; break;		
			default : break;
			}
		}
	}
}
