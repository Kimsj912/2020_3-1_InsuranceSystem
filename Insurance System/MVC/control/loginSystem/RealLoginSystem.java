package control.loginSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.developerAspect.DeveloperTaskSelectSystem;
import control.developSystem.insuranceRatePermitMan.InsuranceRatePermitTaskSelectSystem;
import control.developSystem.productPermitMan.ProductPermitTaskSelectSystem;
import control.salesSystem.salesManAspect.SalesManTaskSelectSystem;
import control.salesSystem.salesManagerAspect.SalesManagerTaskSelectSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.systemUserData.SystemUserData;
import view.insuranceSystemView.loginView.LoginView;
import view.panel.BasicPanel;

public class RealLoginSystem extends LoginSystem{

	// Component
	private LoginView view;
	
	@Override
	public BasicPanel getPanel() {this.view = new LoginView(this.actionListener); return this.view;}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		// Develop Aspect
		SystemUserData<?> user;
		user = this.login(this.developerList.getList());
		if(user != null) {return new DeveloperTaskSelectSystem();}
		user = this.login(this.insuranceRatePermitManList.getList());
		if(user != null) {return new InsuranceRatePermitTaskSelectSystem((InsuranceRatePermitManData) user);}
		user = this.login(this.productPermitManList.getList());
		if(user != null) {return new ProductPermitTaskSelectSystem((ProductPermitManData) user);}
		
		// Sales Aspect
		user = this.login(this.salesManList.getList());
		if(user != null) {return new SalesManTaskSelectSystem();}
		user = this.login(this.salesManagerList.getList());
		if(user != null) {return new SalesManagerTaskSelectSystem();}
//		
//		// Reward Aspect
//		user = this.login(this.customerList.getList());
//		if(user != null) {return new CustomerTaskSelectSystem((CustomerData) user);}
//		user = this.login(this.accidentInvestigatorList.getList());
//		if(user != null) {return new InvestigatorTaskSelectSystem((AccidentInvestigatorData) user);}
//		user = this.login(this.payJudgerList.getList());
//		if(user != null) {return new PayJudgerTaskSelectSystem((PayJudgerData) user);}
//		user = this.login(this.lossCheckManList.getList());
//		if(user != null) {return new LossCheckTaskSelectSystem((LossCheckManData) user);}
//		user = this.login(this.lawyerList.getList());
//		if(user != null) {return new LawsuitTaskSelectSystem((LawyerData) user);}
		
		// No User
		JOptionPane.showMessageDialog(this.view, "계정이 없습니다."); return null;
	}
	private SystemUserData<?> login(Vector<? extends SystemUserData<?>> list) {
		String id = this.view.getID(), pw = this.view.getPW();
		for(SystemUserData<?> data : list) {if(data.getLoginID().equals(id) && data.getLoginPW().equals(pw)) {return data;}}
		return null;
	}
}
