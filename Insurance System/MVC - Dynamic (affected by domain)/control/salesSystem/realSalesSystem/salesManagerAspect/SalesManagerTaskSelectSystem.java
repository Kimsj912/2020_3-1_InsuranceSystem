package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import view.component.BasicButton;

public class SalesManagerTaskSelectSystem extends SalesSystem {

	// Static
	private enum EActionCommands {SaveActivityPlan, SaveSalesTrainingPlan}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("원하시는 업무를 선택하세요."));
		viewInfo.add(new BasicButton("판매 활동 계획 작성하기", EActionCommands.SaveActivityPlan.name(), this.actionListener));
		viewInfo.add(new BasicButton("영업 활동 관리하기", EActionCommands.SaveSalesTrainingPlan.name(), this.actionListener));
		return viewInfo;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveActivityPlan : return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan : return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}
}
