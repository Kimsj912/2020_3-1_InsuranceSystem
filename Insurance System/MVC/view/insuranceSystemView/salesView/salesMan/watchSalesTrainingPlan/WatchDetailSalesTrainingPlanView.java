package view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import control.salesSystem.salesManAspect.SalesManTaskSelectSystem;
import model.aConstant.ETrainingTargetEmployee;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.dataList.IntISDataList;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class WatchDetailSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;


	public WatchDetailSalesTrainingPlanView(ActionListener actionListener , int salesTrainingPlanID, IntISDataList<SalesTrainingPlanData> salesTrainigPlanList) {
		SalesTrainingPlanData watchingSalesTrainingPlanData = salesTrainigPlanList.search(salesTrainingPlanID);

		this.addComponent(new BasicLabel("���� Ȱ�� ��ȹ ����"));
		this.addComponent(new SeparateLine(Color.black));

		String targetNames = "";
		for(ETrainingTargetEmployee target : watchingSalesTrainingPlanData.getTarget()) {targetNames +=(target.name()+", ");}
		this.addComponent(new JLabel("��ȸ�Ͻ� ���� ���� ��ȹ�� ���� �����Դϴ�."));
		this.addComponent(new OutputTextArea("����", watchingSalesTrainingPlanData.getTitle()));
		this.addComponent(new OutputTextArea("��¥", watchingSalesTrainingPlanData.getDate().toString()));
		this.addComponent(new OutputTextArea("���", watchingSalesTrainingPlanData.getPlace()));
		this.addComponent(new OutputTextArea("�������", targetNames));
		this.addComponent(new OutputTextArea("������ǥ ",  watchingSalesTrainingPlanData.getGoal()));
		this.addComponent(new OutputTextArea("��������",  watchingSalesTrainingPlanData.getContent()));
		this.addToLinkPanel(
				new LinkButton("�� ����", SalesManTaskSelectSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", SalesManTaskSelectSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", SalesManTaskSelectSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", SalesManTaskSelectSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
		
	}
}
