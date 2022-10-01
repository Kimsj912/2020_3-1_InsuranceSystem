package control.developSystem.developerAspect.showInsurance;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectSystem;
import view.insuranceSystemView.developView.developer.showInsurance.SelectInsuranceToWatchView;
import panel.BasicPanel;

public class SelecInsuranceToWatchSystem extends DevelopSystem {

	@Override
	public BasicPanel getPanel() {return new SelectInsuranceToWatchView(this.actionListener, this.insuranceList);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		try {SelectInsuranceToWatchView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new ShowInsuranceInfoSystem(Integer.parseInt(e.getActionCommand()));}
		
		switch (SelectInsuranceToWatchView.EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
