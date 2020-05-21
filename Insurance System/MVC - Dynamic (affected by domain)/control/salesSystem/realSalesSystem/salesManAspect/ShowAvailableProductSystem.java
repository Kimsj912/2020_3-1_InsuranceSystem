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
		
		for (AbsInsuranceData insuranceData : this.insuranceDataList.getList()) {
			if (this.customerData.getJoinedInsuranceData().isEmpty()) {
				availableInsuranceList.add(insuranceData);
			} else {
				for (AbsInsuranceData absInsuranceData : this.customerData.getJoinedInsuranceData()) {
					if (insuranceData.getID() == absInsuranceData.getID()) {
						break;
					}else {
						availableInsuranceList.add(insuranceData);
					}
				}
			}
		}
		return availableInsuranceList;
	}
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("보험을 선택하세요."));
		//여기도 테이블로 보여줘야함. ㅎㅎ.... (보험 아이디, 보험명, 내용)
		for (AbsInsuranceData insuranceData : searching().getList()) {
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), this.actionListener));
		}
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new ShowInsuranceInfoToCustomerSystem(Integer.parseInt(e.getActionCommand()), this.customerData);

	}

}
