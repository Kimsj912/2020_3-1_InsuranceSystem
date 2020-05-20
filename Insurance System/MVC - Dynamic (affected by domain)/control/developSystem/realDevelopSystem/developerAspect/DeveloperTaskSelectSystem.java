package control.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent; 
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import view.component.BasicButton;

public class DeveloperTaskSelectSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {InsuranceDesign, WatchInsuranceData}
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("원하시는 업무를 선택하세요."));
		viewInfo.add(new BasicButton("보험 설계", EActionCommands.InsuranceDesign.name(), this.actionListener));
		viewInfo.add(new BasicButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), this.actionListener));
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopInsuranceSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
