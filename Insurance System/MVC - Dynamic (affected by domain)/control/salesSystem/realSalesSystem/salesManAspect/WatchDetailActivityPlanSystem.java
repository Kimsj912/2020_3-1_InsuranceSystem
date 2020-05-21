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
		viewInfo.add(new JLabel("조회하신 활동계획의 세부 정보입니다."));
		viewInfo.add(new TitledTextArea("제목", 1, watchingActivityPlanData.getTitle(), false));
		viewInfo.add(new TitledTextArea("날짜(YYYY-MM-DD)", 1, watchingActivityPlanData.getSalesDuration().toString(), false));
		viewInfo.add(new TitledTextArea("전체 매출 목표", 1, Integer.toString(watchingActivityPlanData.getSalesGoal()), false));
		viewInfo.add(new TitledTextArea("전체 활동목표", 10, watchingActivityPlanData.getActivityGoal(), false));
		viewInfo.add(new TitledTextArea("추가 구인 필요량 ", 1, Integer.toString(watchingActivityPlanData.getAdditionalJobOffer()), false));
		viewInfo.add(new TitledTextArea("주력 고객 선정 ", 3, watchingActivityPlanData.getSalesTargetCustomer(), false));
		
		return viewInfo;
	}

	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return null;
	}

}
