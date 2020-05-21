package control.loginSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.realDevelopSystem.developerAspect.DeveloperTaskSelectSystem;
import control.developSystem.realDevelopSystem.insuranceRatePermitMan.InsuranceRatePermitTaskSelectSystem;
import control.developSystem.realDevelopSystem.productPermitMan.ProductPermitTaskSelectSystem;
import control.salesSystem.realSalesSystem.salesManAspect.SalesManTaskSelectSystem;
import control.salesSystem.realSalesSystem.salesManagerAspect.SalesManagerTaskSelectSystem;
import model.data.systemUserData.SystemUserData;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class RealLoginSystem extends LoginSystem {

	// Static
	private enum EActionCommands {Login}
		
	// Component
	private TitledTextArea idTTA, pwTTA;
	
	@Override
	public Vector<JComponent> getViewInfo() {
		this.idTTA = new TitledTextArea("ID", 1, "", true);
		this.pwTTA = new TitledTextArea("PW", 1, "", true);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("로그인"));
		viewInfo.add(this.idTTA);
		viewInfo.add(this.pwTTA);
		viewInfo.add(new BasicButton("로그인", EActionCommands.Login.name(), this.actionListener));
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(this.login(this.developerList.getList())) {return new DeveloperTaskSelectSystem();}
		if(this.login(this.insuranceRatePermitManList.getList())) {return new InsuranceRatePermitTaskSelectSystem();}
		if(this.login(this.productPermitManList.getList())) {return new ProductPermitTaskSelectSystem();}
		if(this.login(this.salesManList.getList())) {return new SalesManTaskSelectSystem();}
		if(this.login(this.salesManagerList.getList())) {return new SalesManagerTaskSelectSystem();}
		if(this.login(this.customerDataList.getList())) {return new SalesManagerTaskSelectSystem();}
		JOptionPane.showMessageDialog(this.panel, "계정이 없는데연"); return null;
	}
	private boolean login(Vector<? extends SystemUserData> list) {
		String id = this.idTTA.getContent(), pw = this.pwTTA.getContent();
		for(SystemUserData data : list) {if(data.getLoginID().equals(id) && data.getLoginPW().equals(pw)) {return true;}}
		return false;
	}
}
