package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import dataList.IntISDataList;
import dataList.realDataList.ISDataList;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.SearchCustomerView;
import panel.BasicPanel;

public class SearchCustomerSystem extends SalesSystem {
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan,search}
	private SearchCustomerView view;

	@Override
	public BasicPanel getPanel() {
		this.view =  new SearchCustomerView(this.actionListener);
		return this.view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		case search : return new ShowCustomerInfoSystem(search(),this.view.getCustomerNameTTA());
		}
		return null;
	}
	
	public IntISDataList<CustomerData> search() {
		IntISDataList<CustomerData> searchedCustomerList=new ISDataList<CustomerData>();
		for(CustomerData customerData : this.customerDataList.getList()) {
			if(customerData.getName().equals(this.view.getCustomerNameTTA().getContent())) {
				searchedCustomerList.add(customerData);
			}
		}
		return searchedCustomerList;
		
	}
}
