package control.developSystem.developerAspect.developInsurance;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchSystem;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class DevelopeInsuranceSelectSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {CarInsurance, DiseaseInsurance, FireInsurance, InsuranceDesign, WatchInsuranceData}
	
	@Override
	public BasicPanel getPanel() {
		InsuranceSystemPanel view = new InsuranceSystemPanel();
		view.addComponent(new BasicLabel("개발 보험 선택"));
		view.addComponent(new SeparateLine(Color.black, 1));
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1,1,1});
		selectBtnGroup.addGroupComponent(new SelectButton("자동차 보험", EActionCommands.CarInsurance.name(), this.actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("질병 보험", EActionCommands.DiseaseInsurance.name(), this.actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("화재 보험", EActionCommands.FireInsurance.name(), this.actionListener));
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
		case CarInsurance : return new DevelopCarInsuranceSystem();
		case DiseaseInsurance : return new DevelopDiseaseInsuranceSystem();
		case FireInsurance : return new DevelopFireInsuranceSystem();
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
