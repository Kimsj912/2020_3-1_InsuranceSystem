package view.insuranceSystemView.salesView.salesMan.watchActivityPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import model.data.activityPlanData.ActivityPlanData;
import model.dataList.IntISDataList;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.insuranceSystemView.InsuranceSystemView;

public class WatchActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	public WatchActivityPlanView(ActionListener actionListener, IntISDataList<ActivityPlanData> activityPlanList) {
		this.addComponent(new BasicLabel("활동계획 선택"));
		this.addComponent(new SeparateLine(Color.black));

		DynamicGroup selectBtnGroup = new DynamicGroup();
		for (ActivityPlanData data : activityPlanList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(data.getTitle(), Integer.toString(data.getID()), actionListener));
		}
		this.addComponent(selectBtnGroup);
		this.addToLinkPanel(
				new LinkButton("고객 가입", WatchActivityPlanSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", WatchActivityPlanSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", WatchActivityPlanSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", WatchActivityPlanSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
