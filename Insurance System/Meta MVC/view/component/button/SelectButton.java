package view.component.button;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import view.aConstant.ButtonConstant;

@SuppressWarnings("serial")
public class SelectButton extends BasicButton {
	
	// Constructor
	public SelectButton(String text, String actionCommand, ActionListener actionListener) {
		super("    "+text, actionCommand, actionListener);
		this.setBackground(ButtonConstant.SelectButtonBackground_Normal);
		this.setClickColor(ButtonConstant.SelectButtonBackground_Clicked);
		this.setMouseOnColor(ButtonConstant.SelectButtonBackground_MouseOn);
		this.setBorderPainted(true);
		this.setBorder(BorderFactory.createLineBorder(ButtonConstant.SelectButtonBorderColor));
		this.setForeground(ButtonConstant.SelectButtonForeground);
		this.setMargin(new Insets(0, 100, 0, 0));
		this.setHorizontalAlignment(SwingConstants.LEFT);
	}
}
