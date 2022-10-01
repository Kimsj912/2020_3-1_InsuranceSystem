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

		this.addComponent(new BasicLabel("���� Ȱ�� ��ȹ ����"));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("����",  watchingActivityPlanData.getTitle()));
		this.addComponent(new OutputTextArea("��¥(YYYY-MM-DD)",  watchingActivityPlanData.getSalesDuration().toString()));
		this.addComponent(new OutputTextArea("��ü ���� ��ǥ",  Integer.toString(watchingActivityPlanData.getSalesGoal())));
		this.addComponent(new OutputTextArea("��ü Ȱ����ǥ",  watchingActivityPlanData.getActivityGoal()));
		this.addComponent(new OutputTextArea("�߰� ���� �ʿ䷮ ", Integer.toString(watchingActivityPlanData.getAdditionalJobOffer())));
		this.addComponent(new OutputTextArea("�ַ� �� ���� ", watchingActivityPlanData.getSalesTargetCustomer().toString()));

		this.addToLinkPanel(
				new LinkButton("�� ����", WatchDetailActivityPlanSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", WatchDetailActivityPlanSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", WatchDetailActivityPlanSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", WatchDetailActivityPlanSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
