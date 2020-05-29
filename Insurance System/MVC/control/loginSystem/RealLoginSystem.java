package control.loginSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.developerAspect.DeveloperTaskSelectSystem;
import control.developSystem.insuranceRatePermitMan.InsuranceRatePermitTaskSelectSystem;
import control.developSystem.productPermitMan.ProductPermitTaskSelectSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.systemUserData.SystemUserData;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class RealLoginSystem extends LoginSystem{

	// Static
	private enum EActionCommands {Login}
		
	// Component
	private InputTextArea idTTA, pwTTA;
	private InsuranceSystemPanel view;
	
	@Override
	public BasicPanel getPanel() {
		this.view = new InsuranceSystemPanel();
		this.view.addComponent(new BasicLabel("로그인"));
		this.view.addComponent(new SeparateLine(Color.black, 1));
		
		this.idTTA = new InputTextArea("ID", "ID를 입력해 주세요", 1, 50);
		this.pwTTA = new InputTextArea("PW", "PW를 입력해 주세요", 1, 50);
		StaticGroup textAreaGroup = new StaticGroup(new int[] {1,1});
		textAreaGroup.addGroupComponent(this.idTTA, this.pwTTA);
		this.view.addComponent(textAreaGroup);
		
		SelectButton loginBTN = new SelectButton("로그인", EActionCommands.Login.name(), this.actionListener);
		this.view.addComponent(loginBTN);
		
		this.view.addComponent((JComponent) Box.createVerticalStrut(225));
		this.view.addComponent(new SeparateLine(new Color(174,184, 193), 1));
		OutputTextArea idpwTextArea = new OutputTextArea("ID/PW", 
				"Developer : d / 123" +"\r\n"+
				"Insurance Rate Permit Man : i / 123"+"\r\n"+
				"Product Permit Man : p / 123"+"\r\n"+
				"Salesman : s / 123"+"\r\n"+
				"Sales Manager : ss / 123"+"\r\n"+
				"Accident Investigator : ai / 123"+"\r\n"+
				"Pay Judger : pj / 123"+"\r\n"+
				"Loss Checker : lc / 123"+"\r\n"+
				"lawer : ld / 123"
				);
		idpwTextArea.setComponentForeGround(new Color(162,163,162));
		this.view.addComponent(idpwTextArea);
		
		// Link Part
		this.view.setLinkPanelWidth(600);
		BufferedImage myPicture = null;
		try {myPicture = ImageIO.read(new File("loginImage.png"));} catch (IOException e) {e.printStackTrace();}
		
		this.view.addLinkBtn(
				new JLabel(new ImageIcon(myPicture))
//				new LinkButton("A", EActionCommands.Login.name(), this.actionListener),
//				new LinkButton("B", EActionCommands.Login.name(), this.actionListener)
				);
		
		return this.view;
	}
	
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
		
//		// Sales Aspect
//		user = this.login(this.salesManList.getList());
//		if(user != null) {return new SalesManTaskSelectSystem();}
//		user = this.login(this.salesManagerList.getList());
//		if(user != null) {return new SalesManagerTaskSelectSystem();}
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
		String id = this.idTTA.getContent(), pw = this.pwTTA.getContent();
		for(SystemUserData<?> data : list) {if(data.getLoginID().equals(id) && data.getLoginPW().equals(pw)) {return data;}}
		return null;
	}
}
