package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import control.salesSystem.salesManAspect.LookupAvailableProduct.ShowCustomerInfoSystem;
import model.data.customerData.CustomerData;
import dataList.IntISDataList;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.DynamicGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class ShowCustomerInfoView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	
	public ShowCustomerInfoView(ActionListener actionListener, IntISDataList<CustomerData> searchedCustomerList, InputTextArea searchedNameTTA) {
		this.addComponent(new BasicLabel("�� ��ȸ ���"));
		this.addComponent(new SeparateLine(Color.black));

		if (searchedCustomerList.getList().isEmpty()) {
			this.addComponent(new JLabel("��û�Ͻ� "+searchedNameTTA.getContent() + " ���� �ý��ۿ� �������� �ʽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�"));
		} else {
			this.addComponent(new JLabel("��û�Ͻ� "+ searchedNameTTA.getContent() + "�� ����Դϴ�."));
			// ȫ�浿 �� (��, 22��, 990618-1)�� ����ϵ��� ����
			DynamicGroup g = new DynamicGroup();
			for (CustomerData customerData : searchedCustomerList.getList()) {
				g.addGroupComponent(new SelectButton(printline(customerData),Integer.toString(customerData.getID()), actionListener));
			}
			this.addComponent(g);
		}
		this.addToLinkPanel(
				new LinkButton("�� ����", ShowCustomerInfoSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", ShowCustomerInfoSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", ShowCustomerInfoSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", ShowCustomerInfoSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	private String printline(CustomerData customerData) {
		String returnVal ="";
		String name =customerData.getName();
		String gender = customerData.isMale() ? "��": "��";
		String age = Integer.toString(customerData.getAge());
		String socialSecNum = customerData.getSocialSecurityNum().substring(0, 8);
		returnVal = name+" �� ("+gender+", "+age+"��, "+socialSecNum+")";
		return returnVal;
		
	}


}
