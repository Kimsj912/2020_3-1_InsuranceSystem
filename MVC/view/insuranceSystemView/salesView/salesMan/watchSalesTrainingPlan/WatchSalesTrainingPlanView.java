package view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import dataList.IntISDataList;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.DynamicGroup;
import view.insuranceSystemView.InsuranceSystemView;

public class WatchSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	public WatchSalesTrainingPlanView(ActionListener actionListener, IntISDataList<SalesTrainingPlanData> salesTrainingPlanList) {
		this.addComponent(new BasicLabel("영업 교육 계획 조회"));
		this.addComponent(new SeparateLine(Color.black));

		DynamicGroup selectBtnGroup = new DynamicGroup();
		for (SalesTrainingPlanData data : salesTrainingPlanList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(data.getTitle(), Integer.toString(data.getID()), actionListener));
		}
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton("고객 가입", WatchSalesTrainingPlanSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", WatchSalesTrainingPlanSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", WatchSalesTrainingPlanSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", WatchSalesTrainingPlanSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
