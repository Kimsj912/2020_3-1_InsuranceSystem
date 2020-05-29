package control.developSystem.developerAspect;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchSystem;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class DeveloperTaskSelectSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {InsuranceDesign, WatchInsuranceData}
	
	@Override
	public BasicPanel getPanel() {
		InsuranceSystemPanel view = new InsuranceSystemPanel();
		view.addComponent(new BasicLabel("업무 선택"));
		view.addComponent(new SeparateLine(Color.black, 1));
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1,1});
		selectBtnGroup.addGroupComponent(new SelectButton("보험 설계", EActionCommands.InsuranceDesign.name(), this.actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), this.actionListener));
		view.addComponent(selectBtnGroup);
		
		view.addLinkBtn(
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), this.actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), this.actionListener)
		);
		return view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
