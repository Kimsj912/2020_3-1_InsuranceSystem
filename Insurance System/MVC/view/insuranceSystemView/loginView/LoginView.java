package view.insuranceSystemView.loginView;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class LoginView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {Login}
		
	// Component
	private InputTextArea idTTA, pwTTA;
	
	// Constructor
	public LoginView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("로그인"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.idTTA = new InputTextArea("ID", "ID를 입력해 주세요", 1, 50);
		this.pwTTA = new InputTextArea("PW", "PW를 입력해 주세요", 1, 50);
		StaticGroup textAreaGroup = new StaticGroup(new int[] {1,1});
		textAreaGroup.addGroupComponent(this.idTTA, this.pwTTA);
		this.addComponent(textAreaGroup);
		
		ActionButton loginBTN = new ActionButton("로그인", EActionCommands.Login.name(), actionListener);
		this.addComponent(loginBTN);
		
		this.addComponent((JComponent) Box.createVerticalStrut(225));
		
		this.addComponent(new SeparateLine(new Color(174,184, 193)));
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
		this.addComponent(idpwTextArea);
		
		// Link Part
		this.setLinkPanelWidth(600);
		BufferedImage myPicture = null;
		try {myPicture = ImageIO.read(new File("loginImage.png"));} catch (IOException e) {e.printStackTrace();}
		this.addToLinkPanel(new JLabel(new ImageIcon(myPicture)));
	}
	
	// Getter & Setter
	public String getID() {return this.idTTA.getContent();}
	public String getPW() {return this.pwTTA.getContent();}
}
