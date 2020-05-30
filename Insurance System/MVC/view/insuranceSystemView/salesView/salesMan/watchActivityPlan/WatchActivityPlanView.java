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
		this.addComponent(new BasicLabel("Ȱ����ȹ ����"));
		this.addComponent(new SeparateLine(Color.black));

		DynamicGroup selectBtnGroup = new DynamicGroup();
		for (ActivityPlanData data : activityPlanList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(data.getTitle(), Integer.toString(data.getID()), actionListener));
		}
		this.addComponent(selectBtnGroup);
		this.addToLinkPanel(
				new LinkButton("�� ����", WatchActivityPlanSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", WatchActivityPlanSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", WatchActivityPlanSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", WatchActivityPlanSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
