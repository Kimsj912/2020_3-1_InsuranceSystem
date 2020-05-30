package control.salesSystem.salesManAspect.WatchActivityPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchActivityPlan.WatchActivityPlanView;
import view.panel.BasicPanel;

public class WatchActivityPlanSystem extends SalesSystem {

	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	@Override
	public BasicPanel getPanel() {
		return new WatchActivityPlanView(this.actionListener, this.activityPlanList);
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return new WatchDetailActivityPlanSystem(Integer.parseInt(e.getActionCommand()));
	}

}
