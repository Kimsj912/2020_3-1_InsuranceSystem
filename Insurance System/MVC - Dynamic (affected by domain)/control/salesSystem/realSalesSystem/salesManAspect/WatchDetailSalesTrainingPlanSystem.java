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
	private SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public WatchDetailSalesTrainingPlanSystem(int ID) {
		salesTrainingPlanID = ID;
	}
	@Override
	public Vector<JComponent> getViewInfo() {
		this.watchingActivityPlanData = this.salesTrainigPlanList.search(this.salesTrainingPlanID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("조회하신 영업 교육 계획의 세부 정보입니다."));
		viewInfo.add(new TitledTextArea("제목", 3, watchingActivityPlanData.getTitle(), false));
		viewInfo.add(new TitledTextArea("날짜", 1, fm.format(watchingActivityPlanData.getDate()), false));
		viewInfo.add(new TitledTextArea("장소", 1, watchingActivityPlanData.getPlace(), false));
		viewInfo.add(new TitledTextArea("교육대상", 3, watchingActivityPlanData.getTarget(), false));
		viewInfo.add(new TitledTextArea("교육목표 ", 5, watchingActivityPlanData.getGoal(), false));
		viewInfo.add(new TitledTextArea("교육내용", 15, watchingActivityPlanData.getContent(), false));
		
		return viewInfo;
	}

	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return null;
	}

}
