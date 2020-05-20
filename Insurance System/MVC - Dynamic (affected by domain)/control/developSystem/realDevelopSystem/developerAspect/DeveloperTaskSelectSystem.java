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
		viewInfo.add(new JLabel("���Ͻô� ������ �����ϼ���."));
		viewInfo.add(new BasicButton("���� ����", EActionCommands.InsuranceDesign.name(), this.actionListener));
		viewInfo.add(new BasicButton("���� ���� Ȯ��", EActionCommands.WatchInsuranceData.name(), this.actionListener));
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
