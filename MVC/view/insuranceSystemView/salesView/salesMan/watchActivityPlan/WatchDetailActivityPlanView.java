package view.insuranceSystemView.salesView.salesMan.watchActivityPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.WatchActivityPlan.WatchDetailActivityPlanSystem;
import model.data.activityPlanData.ActivityPlanData;
import dataList.IntISDataList;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class WatchDetailActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	public WatchDetailActivityPlanView(ActionListener actionListener, int activityPlanID, IntISDataList<ActivityPlanData> activityPlanList) {
		ActivityPlanData watchingActivityPlanData = activityPlanList.search(activityPlanID);

		this.addComponent(new BasicLabel("세부 활동 계획 정보"));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("제목",  watchingActivityPlanData.getTitle()));
		this.addComponent(new OutputTextArea("날짜(YYYY-MM-DD)",  watchingActivityPlanData.getSalesDuration().toString()));
		this.addComponent(new OutputTextArea("전체 매출 목표",  Integer.toString(watchingActivityPlanData.getSalesGoal())));
		this.addComponent(new OutputTextArea("전체 활동목표",  watchingActivityPlanData.getActivityGoal()));
		this.addComponent(new OutputTextArea("추가 구인 필요량 ", Integer.toString(watchingActivityPlanData.getAdditionalJobOffer())));
		this.addComponent(new OutputTextArea("주력 고객 선정 ", watchingActivityPlanData.getSalesTargetCustomer().toString()));

		this.addToLinkPanel(
				new LinkButton("고객 가입", WatchDetailActivityPlanSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", WatchDetailActivityPlanSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", WatchDetailActivityPlanSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", WatchDetailActivityPlanSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
