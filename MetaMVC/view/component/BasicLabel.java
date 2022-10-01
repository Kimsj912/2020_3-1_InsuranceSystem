package component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import aConstant.ViewConstant;

@SuppressWarnings("serial")
public class BasicLabel extends JPanel {

	// Component
	private JLabel label;
	
	// Constructor
	public BasicLabel(String text) {
		// Set Attribute
		this.setLayout(new BorderLayout()); // for Alignment
		
		// Create Component
		this.label = new JLabel(text);
		this.label.setFont(new Font(ViewConstant.BasicLabelFont, Font.PLAIN, 20));
		this.add(this.label, BorderLayout.CENTER);
		
		this.setMaxHeight(this.label.getFont().getSize());
		this.setBackground(ViewConstant.BasicLabelBackground);
	}

	// Getter & Setter
	private void setMaxHeight(int size) {this.setMaximumSize(new Dimension(Integer.MAX_VALUE, size));}		
	public void setLabelFont (int style, int size) {this.label.setFont(new Font(ViewConstant.BasicLabelFont, style, size)); this.setMaxHeight(size);}
}
