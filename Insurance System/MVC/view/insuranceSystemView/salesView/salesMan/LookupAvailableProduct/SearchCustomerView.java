package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class SearchCustomerView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	private InputTextArea customerNameTTA;

	public SearchCustomerView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("고객명 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1});
		this.customerNameTTA = new InputTextArea("고객명", "고객명을 입력해주세요", 1, 100);
		g.addGroupComponent(customerNameTTA);
		this.addComponent(g);
		
		this.addComponent(new ActionButton("조회",SearchCustomerSystem.EActionCommands.search.name(),actionListener));
		
		this.addToLinkPanel(
				new LinkButton("고객 가입", SearchCustomerSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", SearchCustomerSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", SearchCustomerSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", SearchCustomerSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	//get  & set
	public InputTextArea getCustomerNameTTA() {return customerNameTTA;}
	public void setCustomerNameTTA(InputTextArea customerNameTTA) {this.customerNameTTA = customerNameTTA;}

}
