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
		this.addComponent(new BasicLabel("���� ���� ��ȹ ��ȸ"));
		this.addComponent(new SeparateLine(Color.black));

		DynamicGroup selectBtnGroup = new DynamicGroup();
		for (SalesTrainingPlanData data : salesTrainingPlanList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(data.getTitle(), Integer.toString(data.getID()), actionListener));
		}
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton("�� ����", WatchSalesTrainingPlanSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", WatchSalesTrainingPlanSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", WatchSalesTrainingPlanSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", WatchSalesTrainingPlanSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
