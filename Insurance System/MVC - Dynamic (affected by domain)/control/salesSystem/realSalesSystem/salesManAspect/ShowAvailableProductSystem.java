package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntISDataList;
import model.dataList.realDataList.ISDataList;
import view.component.BasicButton;

public class ShowAvailableProductSystem extends SalesSystem {

	private CustomerData customerData;
	
	public ShowAvailableProductSystem(CustomerData customerData) {
		this.customerData = customerData;
		
	}
	public IntISDataList<AbsInsuranceData> searching() {
		IntISDataList<AbsInsuranceData> availableInsuranceList= new ISDataList<AbsInsuranceData>();
		
		// �� �� �����ؼ� ������ �� ã�Ƽ� availableInsuranceList�� �ֱ�
		// �ϴ��� ��ü ���� ��ǰ�� �����ַ��� ��.
		for (AbsInsuranceData insuranceData:this.insuranceDataList.getList()) {
			availableInsuranceList.add(insuranceData);
		}
		return availableInsuranceList;
	}
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("������ �����ϼ���."));
		//���⵵ ���̺�� ���������. ����.... (���� ���̵�, �����, ����)
		for (AbsInsuranceData insuranceData : searching().getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.actionListener));
		}
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		// showInsuranceInfoSystem�� true false�̷��� �־ �����Ҽ��� ���� �� ������, �ִ°� �Ȱǵ��̴°� �����ϱ� �ϴ� ������.
		return new ShowInsuranceInfoToCustomerSystem(Integer.parseInt(e.getActionCommand()), this.customerData);

	}

}
