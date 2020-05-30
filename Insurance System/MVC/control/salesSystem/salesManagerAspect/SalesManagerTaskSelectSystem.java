package control.salesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import view.insuranceSystemView.salesView.salesManager.SalesMangerTaskSelectView;
import view.panel.BasicPanel;

public class SalesManagerTaskSelectSystem extends SalesSystem {

	@Override
	public BasicPanel getPanel() {return new SalesMangerTaskSelectView(this.actionListener);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (SalesMangerTaskSelectView.EActionCommands.valueOf(e.getActionCommand())) {
		case SaveActivityPlan : return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan : return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}
}
