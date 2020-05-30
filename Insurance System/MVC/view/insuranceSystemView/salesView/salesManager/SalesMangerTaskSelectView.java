package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class SalesMangerTaskSelectView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {SaveActivityPlan, SaveSalesTrainingPlan}
		
	// Constructor
	public SalesMangerTaskSelectView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("���� ����"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1,1});
		g.addGroupComponent(new SelectButton("�Ǹ� Ȱ�� ��ȹ �ۼ��ϱ�", EActionCommands.SaveActivityPlan.name(), actionListener));
		g.addGroupComponent(new SelectButton("���� Ȱ�� �����ϱ�", EActionCommands.SaveSalesTrainingPlan.name(), actionListener));
		this.addComponent(g);
		
		this.addToLinkPanel(
				new LinkButton("�Ǹ� ��ȹ", EActionCommands.SaveActivityPlan.name(), actionListener),
				new LinkButton("���� ����", EActionCommands.SaveSalesTrainingPlan.name(), actionListener)
		);
	}
}
