package component.button;

import java.awt.event.ActionListener;

import aConstant.ButtonConstant;

@SuppressWarnings("serial")
public class BackButton extends BasicButton {
	
	// Constructor
	public BackButton(ActionListener actionListener) {
		super(ButtonConstant.BackButtonText, ButtonConstant.BackButtonIdentifier, actionListener);
		this.setPreferredSize(ButtonConstant.BackButtonSize);
		this.setBackground(ButtonConstant.BackButtonBackground);
		this.setClickColor(ButtonConstant.BackButtonBackground);
		this.setMouseOnColor(ButtonConstant.BackButtonBackground);
		this.setForeground(ButtonConstant.BackButtonForeground);
	}
}
