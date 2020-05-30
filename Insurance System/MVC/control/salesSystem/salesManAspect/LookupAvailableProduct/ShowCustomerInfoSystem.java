package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import model.dataList.IntISDataList;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.ShowCustomerInfoView;
import view.panel.BasicPanel;

public class ShowCustomerInfoSystem extends SalesSystem {

	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	private IntISDataList<CustomerData> searchedCustomerList;
	private InputTextArea searchedNameTTA;

	public ShowCustomerInfoSystem(IntISDataList<CustomerData> customerList, InputTextArea customerNameTTA) {
		this.searchedCustomerList = customerList;
		this.searchedNameTTA = customerNameTTA;
	}

	@Override
	public BasicPanel getPanel() {
		return new ShowCustomerInfoView(actionListener, searchedCustomerList, searchedNameTTA);
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		try {
			switch (EActionCommands.valueOf(e.getActionCommand())) {
			case SigninCustomer : return new SinginCustomerSystem();
			case LookupAvailableProduct : return new SearchCustomerSystem();
			case WatchActivityPlan: return new WatchActivityPlanSystem();
			case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
			}
		} catch(IllegalArgumentException except) {
			for (CustomerData customerData : this.customerDataList.getList()) {
				if (Integer.toString(customerData.getID()).equals(e.getActionCommand())) {
					return new ShowAvailableProductSystem(customerData);
				}
			}
		}
		return null;
		
	}

}
