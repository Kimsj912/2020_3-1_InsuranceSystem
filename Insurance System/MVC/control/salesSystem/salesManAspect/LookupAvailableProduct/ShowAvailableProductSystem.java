package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.ShowAvailableProductView;
import view.panel.BasicPanel;

public class ShowAvailableProductSystem extends SalesSystem {
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	private CustomerData customerData;
	public ShowAvailableProductSystem(CustomerData customerData) {
		this.customerData = customerData;
		
	}
	@Override
	public BasicPanel getPanel() {
		return new ShowAvailableProductView(this.actionListener, this.insuranceDataList, customerData);
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
			return new ShowInsuranceInfoToCustomerSystem(Integer.parseInt(e.getActionCommand()), this.customerData);
		}
		return null;
	}
	
}
