package control.developSystem.developerAspect.developInsurance;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchSystem;
import view.insuranceSystemView.developView.developer.developInsurance.DevelopInsuranceSelectView;
import view.panel.BasicPanel;

public class DevelopeInsuranceSelectSystem extends DevelopSystem {

	@Override
	public BasicPanel getPanel() {return new DevelopInsuranceSelectView(this.actionListener);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (DevelopInsuranceSelectView.EActionCommands.valueOf(e.getActionCommand())) {
		case CarInsurance : return new DevelopCarInsuranceSystem();
		case DiseaseInsurance : return new DevelopDiseaseInsuranceSystem();
		case FireInsurance : return new DevelopFireInsuranceSystem();
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
