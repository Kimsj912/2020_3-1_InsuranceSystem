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
		
		viewInfo.add(new JLabel("������ �����Ͻ� �� �ִ� ���� ���� �Դϴ�."));
		viewInfo.add(new TitledTextArea("���̵�", 1, Integer.toString(searchedInsuranceData.getID()), false));
		viewInfo.add(new TitledTextArea("�����", 1, searchedInsuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("����", 10, searchedInsuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("�������", 10, searchedInsuranceData.getInsuranceRateInfo(), false));
		// Ŭ�ٿ� ����, �������(�����, �����, ����� ���� ������, ����� ������)�� ���ִµ� ���� ����.

		viewInfo.add(new BasicButton("���� ����", EActionCommands.SigninProduct.name(), this.actionListener));
		return viewInfo;
	}

	//no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch(EActionCommands.valueOf(e.getActionCommand())) {
		case SigninProduct : 
            int result = JOptionPane.showConfirmDialog(null, "���谡���� �����Ͻðڽ��ϱ�?", "SignInProduct", JOptionPane.YES_NO_OPTION);
            if(result==0) { //yes
            	JOptionPane.showMessageDialog(null, "���谡���� �Ϸ�Ǿ����ϴ�.", "SignInProduct", JOptionPane.INFORMATION_MESSAGE);
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
