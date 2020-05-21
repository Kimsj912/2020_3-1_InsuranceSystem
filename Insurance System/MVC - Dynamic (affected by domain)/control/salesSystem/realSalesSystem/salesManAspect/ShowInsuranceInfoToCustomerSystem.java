package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class ShowInsuranceInfoToCustomerSystem extends SalesSystem {

	// Static
	private enum EActionCommands {SigninProduct}

	// Attribute
	private int insuranceID;
	private AbsInsuranceData searchedInsuranceData;
	private CustomerData customerData;
	// Constructor
	public ShowInsuranceInfoToCustomerSystem(int insuranceID, CustomerData customerData) {this.insuranceID=insuranceID;this.customerData = customerData;}

	@Override
	public Vector<JComponent> getViewInfo() {
		this.searchedInsuranceData = this.insuranceDataList.search(this.insuranceID);
		
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("고객님이 가입하실 수 있는 보험 정보 입니다."));
		viewInfo.add(new TitledTextArea("아이디", 1, Integer.toString(searchedInsuranceData.getID()), false));
		viewInfo.add(new TitledTextArea("보험명", 1, searchedInsuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("내용", 10, searchedInsuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("보험요율", 10, searchedInsuranceData.getInsuranceRateInfo(), false));
		// 클다엔 이익, 계약조건(보험금, 보험료, 보험금 지불 만기일, 보험료 지불일)이 더있는데 여긴 없다.

		viewInfo.add(new BasicButton("보험 가입", EActionCommands.SigninProduct.name(), this.actionListener));
		return viewInfo;
	}

	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch(EActionCommands.valueOf(e.getActionCommand())) {
		case SigninProduct : 
            int result = JOptionPane.showConfirmDialog(null, "보험가입을 진행하시겠습니까?", "SignInProduct", JOptionPane.YES_NO_OPTION);
            if(result==0) { //yes
            	JOptionPane.showMessageDialog(null, "보험가입이 완료되었습니다.", "SignInProduct", JOptionPane.INFORMATION_MESSAGE);
            	this.customerData.setJoinedInsuranceData(joinInsuranceData());
            	return new ShowAvailableProductSystem(this.customerData);
            }
			break;
		default:
			break;
		}
		return null;
	}
	
	public Vector<AbsInsuranceData> joinInsuranceData() {
		Vector<AbsInsuranceData> customerInsurance = this.customerData.getJoinedInsuranceData();
		Vector<AbsInsuranceData> returnValue = customerInsurance;
		
		for (AbsInsuranceData i : customerInsurance) {
			returnValue.add(i);
		}
		for(AbsInsuranceData i :insuranceDataList.getList()) {
			if (i.getID() == this.insuranceID) {
				returnValue.add(i);
			}
		}
		return returnValue;
	}
}
