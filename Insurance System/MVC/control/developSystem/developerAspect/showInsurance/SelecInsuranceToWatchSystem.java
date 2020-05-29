package control.developSystem.developerAspect.showInsurance;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectSystem;
import model.data.insuranceData.AbsInsuranceData;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class SelecInsuranceToWatchSystem extends DevelopSystem {

	private enum EActionCommands {InsuranceDesign, WatchInsuranceData}
	
	@Override
	public BasicPanel getPanel() {
		InsuranceSystemPanel view = new InsuranceSystemPanel();
		view.addComponent(new BasicLabel("보험 선택"));
		view.addComponent(new SeparateLine(Color.black, 1));
		
		DynamicGroup selectBtnGroup = new DynamicGroup();
		for(AbsInsuranceData insuranceData : this.insuranceList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.actionListener));
		}
		view.addComponent(selectBtnGroup);
		
		view.addLinkBtn(
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), this.actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), this.actionListener)
		);
		return view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		try {EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new ShowInsuranceInfoSystem(Integer.parseInt(e.getActionCommand()));}
		
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
