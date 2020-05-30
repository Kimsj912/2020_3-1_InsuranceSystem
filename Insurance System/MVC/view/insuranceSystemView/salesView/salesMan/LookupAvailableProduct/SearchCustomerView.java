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
		this.addComponent(new BasicLabel("���� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1});
		this.customerNameTTA = new InputTextArea("����", "������ �Է����ּ���", 1, 100);
		g.addGroupComponent(customerNameTTA);
		this.addComponent(g);
		
		this.addComponent(new ActionButton("��ȸ",SearchCustomerSystem.EActionCommands.search.name(),actionListener));
		
		this.addToLinkPanel(
				new LinkButton("�� ����", SearchCustomerSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", SearchCustomerSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", SearchCustomerSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", SearchCustomerSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	//get  & set
	public InputTextArea getCustomerNameTTA() {return customerNameTTA;}
	public void setCustomerNameTTA(InputTextArea customerNameTTA) {this.customerNameTTA = customerNameTTA;}

}
