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
			viewInfo.add(new JLabel(this.searchedNameTTA.getTitle() + "님은 시스템에 존재하지 않습니다. 다시한번 확인해주십시오"));
		} else {
			viewInfo.add(new JLabel("요청하신 "+ this.searchedNameTTA.getTitle() + "님 명단입니다."));
			//테이블을 만들장 나중에 (고객명, 고객아이디, 전화번호, 성별, 나이, 주민번호)보여줘야함
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
				return new ShowAvailableProductSystem(customerData);// 클다는 ID를 주지만, 나는 CustomerData를 쓸것이다.
			}
		}
		return null;
		
	}

}
