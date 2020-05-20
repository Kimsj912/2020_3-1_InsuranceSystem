package view.component;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.aConstant.ViewConstant;

@SuppressWarnings("serial")
public class BasicButton extends JButton  {

	// Constructor
	public BasicButton(String text, String actionCommand, ActionListener actionListener) { 
		// Set Attribute
		this.setText(text);
		this.setActionCommand(actionCommand);
		this.addActionListener(actionListener);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getMinimumSize().height));
		this.setBackground(ViewConstant.BasicButtonBackground);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setFocusable(false);
	}
}
