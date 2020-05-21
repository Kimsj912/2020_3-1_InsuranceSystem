package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.activityPlanData.ActivityPlanData;
import view.component.BasicButton;

public class WatchActivityPlanSystem extends SalesSystem {

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��ȸ�� Ȱ����ȹ�� �����ϼ���."));
		for (ActivityPlanData data : this.activityPlanList.getList()) {
			viewInfo.add(new BasicButton(data.getTitle(), Integer.toString(data.getID()), this.actionListener));
		}
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new WatchDetailActivityPlanSystem(Integer.parseInt(e.getActionCommand()));
		
	}

}
