package control.salesSystem.salesManAspect.WatchActivityPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchActivityPlan.WatchDetailActivityPlanView;
import view.panel.BasicPanel;

public class WatchDetailActivityPlanSystem extends SalesSystem {

	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
	private int activityPlanID;

	public WatchDetailActivityPlanSystem(int ID) {activityPlanID = ID;}
	@Override
	public BasicPanel getPanel() {return new WatchDetailActivityPlanView(actionListener, this.activityPlanID,this.activityPlanList);}
	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;}
}
