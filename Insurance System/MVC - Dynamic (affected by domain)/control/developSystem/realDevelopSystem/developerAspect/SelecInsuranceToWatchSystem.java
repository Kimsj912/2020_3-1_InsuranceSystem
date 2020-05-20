package control.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.insuranceData.AbsInsuranceData;
import view.component.BasicButton;

public class SelecInsuranceToWatchSystem extends DevelopSystem {

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("보험을 선택하세요."));
		for(AbsInsuranceData insuranceData : this.insuranceList.getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.actionListener));
		}
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new ShowInsuranceInfoSystem(Integer.parseInt(e.getActionCommand()));
	}
}
