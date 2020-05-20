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
		viewInfo.add(new JLabel("���Ͻô� ������ �����ϼ���."));
		viewInfo.add(new BasicButton("�Ǹ� Ȱ�� ��ȹ �ۼ��ϱ�", EActionCommands.SaveActivityPlan.name(), this.actionListener));
		viewInfo.add(new BasicButton("���� Ȱ�� �����ϱ�", EActionCommands.SaveSalesTrainingPlan.name(), this.actionListener));
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
