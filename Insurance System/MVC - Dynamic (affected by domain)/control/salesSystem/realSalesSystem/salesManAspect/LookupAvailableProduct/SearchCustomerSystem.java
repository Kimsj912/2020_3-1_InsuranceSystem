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
import model.dataList.realDataList.ISDataList;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class SearchCustomerSystem extends SalesSystem {

	private enum EActionCommands {search}

	private TitledTextArea customerNameTTA;
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("������ �Է����ּ���."));
		this.customerNameTTA = new TitledTextArea("����", 1, "", true);
		viewInfo.add(customerNameTTA);
		viewInfo.add(new BasicButton("��ȸ",EActionCommands.search.name(),this.actionListener));
		
		return viewInfo;
	}
	public IntISDataList<CustomerData> search() {
		IntISDataList<CustomerData> searchedCustomerList=new ISDataList<CustomerData>();
		for(CustomerData customerData : this.customerDataList.getList()) {
			if(customerData.getName().equals(this.customerNameTTA.getContent())) {
				searchedCustomerList.add(customerData);
			}
		}
		return searchedCustomerList;
		
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case search : return new ShowCustomerInfoSystem(search(),this.customerNameTTA);
		}
		return null;
	}

}
