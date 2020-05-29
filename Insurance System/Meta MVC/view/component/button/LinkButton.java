package view.component.button;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import view.aConstant.ButtonConstant;

@SuppressWarnings("serial")
public class LinkButton extends BasicButton {
	
	// Constructor
	public LinkButton(String text, String actionCommand, ActionListener actionListener) {
		super(text, actionCommand, actionListener);
		this.setPreferredSize(new Dimension(Integer.MAX_VALUE, ButtonConstant.LinkButtonPreferredHeight));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, ButtonConstant.LinkButtonPreferredHeight));
		this.setFont(ButtonConstant.LinkButtonFont);
		this.setBackground(ButtonConstant.LinkButtonBackgroundColor);
		this.setClickColor(ButtonConstant.LinkButtonClickColor);
		this.setMouseOnColor(ButtonConstant.LinkButtonMouseOnColor);
		this.setForeground(ButtonConstant.LinkButtonForegroundColor);
	}
}
