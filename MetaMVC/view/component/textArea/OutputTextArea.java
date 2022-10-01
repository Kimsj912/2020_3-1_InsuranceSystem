package component.textArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;

import aConstant.ViewConstant;

@SuppressWarnings("serial")
public class OutputTextArea extends BasicTitledTextArea {
	
	// Constructor
	public OutputTextArea(String title, String content) {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(ViewConstant.OutputTextAreaPanelBackground);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE,  ViewConstant.OutputTextAreaPanelLabelFont.getSize()+ViewConstant.OutputTextAreaPanelTextAreaHeightUnit*(this.countLines(content)+1)));
		
		// Create Component
		this.titleLabel = new JLabel("¡¤ "+title);
		this.titleLabel.setFont(ViewConstant.OutputTextAreaPanelLabelFont);
		this.add(this.titleLabel, BorderLayout.NORTH);
		
		this.textArea = new PlaceholderTextArea();
		this.textArea.setBorder(ViewConstant.OutputTextAreaEmptyBorder);
		this.textArea.setText(content);
		this.textArea.setEditable(false);
		this.textArea.addMouseWheelListener(new MouseWheelHandler());
		this.add(this.textArea, BorderLayout.CENTER);
	}

	// Create Time Use
	private int countLines(String str){return  str.split("\r\n|\r|\n").length;}
}
