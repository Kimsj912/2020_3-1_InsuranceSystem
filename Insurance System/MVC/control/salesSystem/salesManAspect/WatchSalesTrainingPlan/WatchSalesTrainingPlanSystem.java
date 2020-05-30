package control.salesSystem.salesManAspect.WatchSalesTrainingPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan.WatchSalesTrainingPlanView;
import view.panel.BasicPanel;

public class WatchSalesTrainingPlanSystem extends SalesSystem {
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	@Override
	public BasicPanel getPanel() {return new WatchSalesTrainingPlanView(this.actionListener, this.salesTrainigPlanList);}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {

	switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		default :
			return new WatchDetailSalesTrainingPlanSystem(Integer.parseInt(e.getActionCommand()));
		}
	}
}
