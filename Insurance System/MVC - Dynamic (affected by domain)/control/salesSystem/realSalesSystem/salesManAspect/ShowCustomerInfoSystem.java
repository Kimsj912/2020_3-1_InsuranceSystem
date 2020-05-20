package control.salesSystem.realSalesSystem.salesManAspect;

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

public class ShowCustomerInfoSystem extends SalesSystem {

	private IntISDataList<CustomerData> searchedCustomerList;
	private JTextField searchedNameTTA;

	public ShowCustomerInfoSystem(IntISDataList<CustomerData> customerList, JTextField searchedNameTTA) {
		this.searchedCustomerList = customerList;
		this.searchedNameTTA = searchedNameTTA;
	}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		if (this.searchedCustomerList.getList().isEmpty()) {
			viewInfo.add(new JLabel(this.searchedNameTTA.getText() + "님은 시스템에 존재하지 않습니다. 다시한번 확인해주십시오"));
		} else {
			//테이블을 만들장 나중에 (고객명, 고객아이디, 전화번호, 성별, 나이, 주민번호)보여줘야함
			for (CustomerData customerData : this.searchedCustomerList.getList()) {
				viewInfo.add(new BasicButton(customerData.getName(), Integer.toString(customerData.getID()), this.actionListener));
			}
		}
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		// 고객 선택되면, 고객이 가입할 수 있는 보험 검색 창을 띄우면 됨
		// 일단 동명이인은 나중에 다시 터치함.
		for (CustomerData customerData : this.customerDataList.getList()) {
			if (Integer.toString(customerData.getID()).equals(e.getActionCommand())) {
				return new ShowAvailableProductSystem(customerData);// 클다는 ID를 주지만, 나는 CustomerData를 쓸것이다.
			}
		}
		return null;
		
	}

}
