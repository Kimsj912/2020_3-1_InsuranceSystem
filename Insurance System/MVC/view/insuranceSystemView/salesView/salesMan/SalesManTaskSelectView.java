package view.insuranceSystemView.salesView.salesMan;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.SalesManTaskSelectSystem;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.BasicButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class SalesManTaskSelectView extends InsuranceSystemView {
		
	// Constructor
	public SalesManTaskSelectView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("���Ͻô� ������ �����ϼ���."));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1,1,1,1});
		g.addGroupComponent(new BasicButton("�� ����", SalesManTaskSelectSystem.EActionCommands.SigninCustomer.name(), actionListener));
		g.addGroupComponent(new BasicButton("���� ���� ��ȸ", SalesManTaskSelectSystem.EActionCommands.LookupAvailableProduct.name(), actionListener));
		g.addGroupComponent(new BasicButton("�Ǹ� Ȱ�� ��ȸ", SalesManTaskSelectSystem.EActionCommands.WatchActivityPlan.name(), actionListener));
		g.addGroupComponent(new BasicButton("���� Ȱ�� ��ȸ", SalesManTaskSelectSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener));
		this.addComponent(g);
		
		this.addToLinkPanel(
				new LinkButton("�� ����", SalesManTaskSelectSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", SalesManTaskSelectSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", SalesManTaskSelectSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", SalesManTaskSelectSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
