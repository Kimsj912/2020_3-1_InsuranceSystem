package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import view.component.TitledTextArea;

public class WatchDetailSalesTrainingPlanSystem extends SalesSystem {

	private int salesTrainingPlanID;
	private SalesTrainingPlanData watchingActivityPlanData;

	public WatchDetailSalesTrainingPlanSystem(int ID) {
		salesTrainingPlanID = ID;
	}
	@Override
	public Vector<JComponent> getViewInfo() {
		this.watchingActivityPlanData = this.salesTrainigPlanList.search(this.salesTrainingPlanID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��ȸ�Ͻ� ���� ���� ��ȹ�� ���� �����Դϴ�."));
		viewInfo.add(new TitledTextArea("����", 3, watchingActivityPlanData.getTitle(), false));
		viewInfo.add(new TitledTextArea("��¥", 1, watchingActivityPlanData.getDate().toString(), false));
		viewInfo.add(new TitledTextArea("���", 1, watchingActivityPlanData.getPlace(), false));
//		viewInfo.add(new TitledRadioButtonGroup("�������", watchingActivityPlanData.getTarget(), true));
		viewInfo.add(new TitledTextArea("������ǥ ", 5, watchingActivityPlanData.getGoal(), false));
		viewInfo.add(new TitledTextArea("��������", 15, watchingActivityPlanData.getContent(), false));
		
		return viewInfo;
	}

	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return null;
	}

}
