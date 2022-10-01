package control.developSystem.developerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchSystem;
import view.insuranceSystemView.developView.developer.DeveloperTaskSelectView;
import panel.BasicPanel;

public class DeveloperTaskSelectSystem extends DevelopSystem {

	@Override
	public BasicPanel getPanel() {return new DeveloperTaskSelectView (this.actionListener);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (DeveloperTaskSelectView.EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
