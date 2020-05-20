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
		viewInfo.add(new JLabel("�α���"));
		viewInfo.add(this.idTTA);
		viewInfo.add(this.pwTTA);
		viewInfo.add(new BasicButton("�α���", EActionCommands.Login.name(), this.actionListener));
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(this.login(this.developerList.getList())) {return new DeveloperTaskSelectSystem();}
		if(this.login(this.insuranceRatePermitManList.getList())) {return new InsuranceRatePermitTaskSelectSystem();}
		if(this.login(this.productPermitManList.getList())) {return new ProductPermitTaskSelectSystem();}
		JOptionPane.showMessageDialog(this.panel, "������ ���µ���"); return null;
	}
	private boolean login(Vector<? extends SystemUserData> list) {
		String id = this.idTTA.getContent(), pw = this.pwTTA.getContent();
		for(SystemUserData data : list) {if(data.getLoginID().equals(id) && data.getLoginPW().equals(pw)) {return true;}}
		return false;
	}
}
