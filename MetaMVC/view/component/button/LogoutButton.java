package component.button;

import java.awt.event.ActionListener;

import aConstant.ButtonConstant;

@SuppressWarnings("serial")
public class LogoutButton extends BasicButton {
	
	// Constructor
	public LogoutButton(ActionListener actionListener) {
		super(ButtonConstant.LogoutButtonText, ButtonConstant.LogoutButtonIdentifier, actionListener);
		this.setPreferredSize(ButtonConstant.LogoutButtonSize);
		this.setBackground(ButtonConstant.LogoutButtonBackground);
		this.setClickColor(ButtonConstant.LogoutButtonBackground);
		this.setMouseOnColor(ButtonConstant.LogoutButtonBackground);
		this.setForeground(ButtonConstant.LogoutButtonForeground);
	}
}
