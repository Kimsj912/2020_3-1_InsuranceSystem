package control.salesSystem.realSalesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.customerData.CustomerData;
import model.dataList.IntISDataList;
import view.component.BasicButton;
import view.component.BasicTable;
import view.component.TitledTextArea;

public class ShowCustomerInfoSystem extends SalesSystem {

	private IntISDataList<CustomerData> searchedCustomerList;
	private TitledTextArea searchedNameTTA;

	public ShowCustomerInfoSystem(IntISDataList<CustomerData> customerList, TitledTextArea customerNameTTA) {
		this.searchedCustomerList = customerList;
		this.searchedNameTTA = customerNameTTA;
	}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		if (this.searchedCustomerList.getList().isEmpty()) {
			viewInfo.add(new JLabel(this.searchedNameTTA.getTitle() + "���� �ý��ۿ� �������� �ʽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�"));
		} else {
			viewInfo.add(new JLabel("��û�Ͻ� "+ this.searchedNameTTA.getTitle() + "�� ����Դϴ�."));
			//���̺��� ������ ���߿� (����, �����̵�, ��ȭ��ȣ, ����, ����, �ֹι�ȣ)���������
			for (CustomerData customerData : this.searchedCustomerList.getList()) {
				viewInfo.add(new BasicButton(customerData.getName(), Integer.toString(customerData.getID()), this.actionListener));
			}
		}
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		for (CustomerData customerData : this.customerDataList.getList()) {
			if (Integer.toString(customerData.getID()).equals(e.getActionCommand())) {
				return new ShowAvailableProductSystem(customerData);// Ŭ�ٴ� ID�� ������, ���� CustomerData�� �����̴�.
			}
		}
		return null;
		
	}

}
