package control.rewardSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.ISData;
import model.data.customerData.CustomerData;
import model.dataList.IntISDataList;

public abstract class RewardSystem extends DynamicSystem {
	
	// Associate 
	protected IntISDataList<CustomerData> customerList;
	
	// Initialize Time Use
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntISDataList<? extends ISData>> datas) {
		for(IntISDataList<? extends ISData> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case CustomerDataListID : this.customerList=(IntISDataList<CustomerData>) model; break;
			default : break;
			}
		}
	}
}
 