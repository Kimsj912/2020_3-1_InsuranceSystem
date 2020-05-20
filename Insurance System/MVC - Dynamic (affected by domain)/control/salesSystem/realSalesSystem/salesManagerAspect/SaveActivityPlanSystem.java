package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.activityPlanData.ActivityPlanData;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class SaveActivityPlanSystem extends SalesSystem {

	// Static
	private enum EActionCommands {Save}
		
	/*date type인 salesDuration때문에 3개를 받음.*/
	private TitledTextArea titleTTA = new TitledTextArea("제목",2,"",true); //int
	private TitledTextArea salesDuration_yearTTA = new TitledTextArea("활동연도(YYYY)",1,"",true); //int
	private TitledTextArea salesDuration_monthTTA = new TitledTextArea("활동월(MM)",1,"",true); //int
	private TitledTextArea salesDuration_dayTTA = new TitledTextArea("활동일(dd)",1,"",true); //int
	private TitledTextArea salesGoalTTA = new TitledTextArea("전체 매출 목표",1,"",true); //int
	private TitledTextArea activityGoalTTA = new TitledTextArea("전체 활동 목표",10,"",true);
	private TitledTextArea additionalJobOfferTTA = new TitledTextArea("추가 구인 필요량",1,"",true); //int
	private TitledTextArea salesTargetCustomerTTA = new TitledTextArea("주력 고객 선정",3,"",true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("활동계획란을 작성하여 주세요."));
		viewInfo.add(this.titleTTA);
		viewInfo.add(this.salesDuration_yearTTA);
		viewInfo.add(this.salesDuration_monthTTA);
		viewInfo.add(this.salesDuration_dayTTA);
		viewInfo.add(this.salesGoalTTA);
		viewInfo.add(this.activityGoalTTA);
		viewInfo.add(this.additionalJobOfferTTA);
		viewInfo.add(this.salesTargetCustomerTTA);
		
		viewInfo.add(new BasicButton("저장", EActionCommands.Save.name(), this.actionListener));

		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			this.save(); 
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
			this.gotoBack(); 
			break;
		}
		return null;
	}
	@SuppressWarnings("deprecation")
	private void save() {
		ActivityPlanData data = new ActivityPlanData();
		data.setTitle(this.titleTTA.getContent());
		Date durationdate = new Date();
		durationdate.setYear(Integer.parseInt(salesDuration_yearTTA.getContent()));
		durationdate.setMonth(Integer.parseInt(salesDuration_monthTTA.getContent()));
		durationdate.setDate(Integer.parseInt(salesDuration_dayTTA.getContent()));
		data.setSalesDuration(durationdate);
		data.setSalesGoal(Integer.parseInt(this.salesGoalTTA.getContent()));
		data.setActivityGoal(this.activityGoalTTA.getContent());
		data.setAdditionalJobOffer(Integer.parseInt(this.additionalJobOfferTTA.getContent()));
		data.setSalesTargetCustomer(this.salesTargetCustomerTTA.getContent());
		
		this.activityPlanList.add(data);
		
	}
}
