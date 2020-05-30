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
		this.addComponent(new BasicLabel("업무 선택"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1,1});
		g.addGroupComponent(new SelectButton("판매 활동 계획 작성하기", EActionCommands.SaveActivityPlan.name(), actionListener));
		g.addGroupComponent(new SelectButton("영업 활동 관리하기", EActionCommands.SaveSalesTrainingPlan.name(), actionListener));
		this.addComponent(g);
		
		this.addToLinkPanel(
				new LinkButton("판매 계획", EActionCommands.SaveActivityPlan.name(), actionListener),
				new LinkButton("영업 관리", EActionCommands.SaveSalesTrainingPlan.name(), actionListener)
		);
	}
}
