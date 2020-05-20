package view.component;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import view.aConstant.ViewConstant;

public class BasicTextField extends JTextField {
	private static final long serialVersionUID = 1L;
	public BasicTextField(String text, String actionCommand, ActionListener actionListener) { 
		// Set Attribute
		this.setText(text);
		this.setActionCommand(actionCommand);
		this.addActionListener(actionListener);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getMinimumSize().height));
		this.setBackground(ViewConstant.BasicButtonBackground);
		this.setFocusable(false);
	}
	
	

}
