package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import view.component.BasicButton;

public class WatchSalesTrainingPlanSystem extends SalesSystem {

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("조회할 영업 교육 계획을 선택하세요."));
		for (SalesTrainingPlanData data : this.salesTrainigPlanList.getList()) {
			viewInfo.add(new BasicButton(data.getTitle(), Integer.toString(data.getID()), this.actionListener));
		}
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new WatchDetailSalesTrainingPlanSystem(Integer.parseInt(e.getActionCommand()));
		
	}

}
