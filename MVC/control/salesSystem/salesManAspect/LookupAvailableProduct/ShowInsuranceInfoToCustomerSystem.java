package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.ShowInsuranceInfoToCustomerView;
import panel.BasicPanel;

public class ShowInsuranceInfoToCustomerSystem extends SalesSystem {

	// Static
	public enum EActionCommands {SigninProduct,SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	private int insuranceID;
	private CustomerData customerData;
	private ShowInsuranceInfoToCustomerView view;
	// Constructor
	public ShowInsuranceInfoToCustomerSystem(int insuranceID, CustomerData customerData) {this.insuranceID=insuranceID;this.customerData = customerData;}

	@Override
	public BasicPanel getPanel() {
		this.view = new ShowInsuranceInfoToCustomerView(this.actionListener,this.insuranceDataList,insuranceID,customerData);
		return this.view;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		case SigninProduct:
			int result = JOptionPane.showConfirmDialog(this.view, "보험가입을 진행하시겠습니까?", "SignInProduct",
					JOptionPane.YES_NO_OPTION);
			if (result == 0) { // yes
				JOptionPane.showMessageDialog(this.view, "보험가입이 완료되었습니다.", "SignInProduct", JOptionPane.INFORMATION_MESSAGE);
				for(AbsInsuranceData ins:this.insuranceDataList.getList()) {
					ins.addCustomerID(this.customerData.getID());
				}
				return new ShowAvailableProductSystem(this.customerData);
			}
			break;
		default:
			break;
		}
		return null;
	}

}
