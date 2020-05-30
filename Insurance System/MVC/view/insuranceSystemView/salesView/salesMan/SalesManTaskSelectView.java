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
		this.addComponent(new BasicLabel("원하시는 업무를 선택하세요."));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1,1,1,1});
		g.addGroupComponent(new BasicButton("고객 가입", SalesManTaskSelectSystem.EActionCommands.SigninCustomer.name(), actionListener));
		g.addGroupComponent(new BasicButton("가능 보험 조회", SalesManTaskSelectSystem.EActionCommands.LookupAvailableProduct.name(), actionListener));
		g.addGroupComponent(new BasicButton("판매 활동 조회", SalesManTaskSelectSystem.EActionCommands.WatchActivityPlan.name(), actionListener));
		g.addGroupComponent(new BasicButton("영업 활동 조회", SalesManTaskSelectSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener));
		this.addComponent(g);
		
		this.addToLinkPanel(
				new LinkButton("고객 가입", SalesManTaskSelectSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", SalesManTaskSelectSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", SalesManTaskSelectSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", SalesManTaskSelectSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
