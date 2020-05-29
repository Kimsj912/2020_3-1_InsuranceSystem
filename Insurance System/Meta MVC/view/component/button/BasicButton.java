package view.component.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.aConstant.ButtonConstant;

@SuppressWarnings("serial")
public class BasicButton extends JButton  {

	// Attribute
	private Color normalColor, mouseOnColor, clickColor;
	
	// Constructor
	public BasicButton(String text, String actionCommand, ActionListener actionListener) { 
		// Set Attribute
		this.normalColor = ButtonConstant.BasicButtonBackground_Normal;
		this.mouseOnColor = ButtonConstant.BasicButtonBackground_MouseOn;
		this.clickColor = ButtonConstant.BasicButtonBackground_Clicked;
		
		this.setForeground(ButtonConstant.BasicButtonForeground);
		this.setText(text);
		this.setActionCommand(actionCommand);
		this.addActionListener(actionListener);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getMinimumSize().height));
		this.setBackground(this.normalColor);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setFocusable(false);
		this.setContentAreaFilled(false);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {g.setColor(this.clickColor);}
        else if (getModel().isRollover()) {g.setColor(this.mouseOnColor);}
        else {g.setColor(getBackground());}
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
	
	// Getter & Setter
	public void setClickColor(Color c) {this.clickColor=c;}
	public void setMouseOnColor(Color c) {this.mouseOnColor=c;}
	public void setNormalColor(Color c) {this.normalColor=c; this.setBackground(this.normalColor);}
}
