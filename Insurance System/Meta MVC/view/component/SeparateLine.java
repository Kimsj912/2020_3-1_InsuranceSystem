package view.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SeparateLine extends JSeparator {
	
	// Constructor
	public SeparateLine(Color c) {
		// Set Attribute
		this.setOrientation(SwingConstants.HORIZONTAL);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		this.setForeground(c);
	}
}
