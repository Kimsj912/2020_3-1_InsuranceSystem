package view.component.button;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import view.aConstant.ButtonConstant;

@SuppressWarnings("serial")
public class ActionButton extends BasicButton {
	
	// Constructor
	public ActionButton(String text, String actionCommand, ActionListener actionListener) {
		super(text, actionCommand, actionListener);
		this.setBackground(ButtonConstant.SelectButtonBackground_Normal);
		this.setClickColor(ButtonConstant.SelectButtonBackground_Clicked);
		this.setMouseOnColor(ButtonConstant.SelectButtonBackground_MouseOn);
		this.setBorderPainted(true);
		this.setBorder(BorderFactory.createLineBorder(ButtonConstant.SelectButtonBorderColor));
		this.setForeground(ButtonConstant.SelectButtonForeground);
	}
}
