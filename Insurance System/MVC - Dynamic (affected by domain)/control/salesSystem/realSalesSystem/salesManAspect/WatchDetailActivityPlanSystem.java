package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.activityPlanData.ActivityPlanData;
import view.component.TitledTextArea;

public class WatchDetailActivityPlanSystem extends SalesSystem {

	private int activityPlanID;
	private ActivityPlanData watchingActivityPlanData;
	private SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public WatchDetailActivityPlanSystem(int ID) {
		activityPlanID = ID;
	}

	@Override
	public Vector<JComponent> getViewInfo() {
		this.watchingActivityPlanData = this.activityPlanList.search(this.activityPlanID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��ȸ�Ͻ� Ȱ����ȹ�� ���� �����Դϴ�."));
		viewInfo.add(new TitledTextArea("����", 1, watchingActivityPlanData.getTitle(), false));
		viewInfo.add(new TitledTextArea("��¥(YYYY-MM-DD)", 1, watchingActivityPlanData.getSalesDuration().toString(), false));
		viewInfo.add(new TitledTextArea("��ü ���� ��ǥ", 1, Integer.toString(watchingActivityPlanData.getSalesGoal()), false));
		viewInfo.add(new TitledTextArea("��ü Ȱ����ǥ", 10, watchingActivityPlanData.getActivityGoal(), false));
		viewInfo.add(new TitledTextArea("�߰� ���� �ʿ䷮ ", 1, Integer.toString(watchingActivityPlanData.getAdditionalJobOffer()), false));
		viewInfo.add(new TitledTextArea("�ַ� �� ���� ", 3, watchingActivityPlanData.getSalesTargetCustomer(), false));
		
		return viewInfo;
	}

	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return null;
	}

}
