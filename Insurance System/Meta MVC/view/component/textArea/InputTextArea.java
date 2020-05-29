package view.component.textArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import view.aConstant.ViewConstant;

@SuppressWarnings("serial")
public class InputTextArea extends BasicTitledTextArea {
	
	// Constructor
	public InputTextArea(String title, String placeHolder, int textAreaHeight, int nameWidth) {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(ViewConstant.InputTextAreaPanelBackground);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 
				ViewConstant.InputTextAreaBasicBound + ViewConstant.InputTextAreaPanelTextAreaHeightUnit*textAreaHeight));
		
		// Create Component
		JPanel innerPanel = new JPanel();
		innerPanel.setBackground(ViewConstant.InputTextAreaPanelBackground);
		innerPanel.setLayout(new BorderLayout());
		this.add(innerPanel, BorderLayout.WEST);
		
		this.titleLabel = new JLabel("  "+title);
		this.titleLabel.setFont(ViewConstant.InputTextAreaPanelLabelFont);
		this.titleLabel.setPreferredSize(new Dimension(nameWidth, ViewConstant.InputTextAreaPanelLabelFont.getSize()));
		innerPanel.add(this.titleLabel, BorderLayout.CENTER);
		
		this.textArea = new PlaceholderTextArea();
		this.textArea.setPlaceholder(placeHolder);
		this.textArea.addMouseWheelListener(new MouseWheelHandler());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBorder(null);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		jsp.getVerticalScrollBar().setPreferredSize (new Dimension(0, 0)); // hide scroll bar
		jsp.getHorizontalScrollBar().setPreferredSize (new Dimension(0, 0)); // hide scroll bar
		
		this.textArea.setBorder(null);
		Border temp1 = BorderFactory.createCompoundBorder(ViewConstant.InputTextAreaEmptyBorder, ViewConstant.InputTextAreaBorder);
		Border result = BorderFactory.createCompoundBorder(temp1, ViewConstant.InputTextAreaEmptyBorder);
		this.textArea.setBorder(result);
	    
		this.add(jsp, BorderLayout.CENTER);
	}
}
