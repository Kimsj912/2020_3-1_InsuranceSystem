package view.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.aConstant.ViewConstant;

@SuppressWarnings("serial")
public class TitledTextArea extends JPanel {
	
	// Component
	private JLabel titleLabel; 
	private TextArea textArea;
	
	// Constructor
	public TitledTextArea(String title, int textAreaHeight, String content, boolean editable) {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(ViewConstant.TitledTextAreaPanelBackground);
		this.setPreferredSize(new Dimension(0, ViewConstant.TitledTextAreaPanelLabelHeight+ViewConstant.TitledTextAreaPanelTextAreaHeightUnit*textAreaHeight));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, ViewConstant.TitledTextAreaPanelLabelHeight+ViewConstant.TitledTextAreaPanelTextAreaHeightUnit*textAreaHeight));
		
		// Create Component
		this.titleLabel = new JLabel(title);
		this.add(this.titleLabel, BorderLayout.NORTH);
		
		this.textArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_NONE);
		this.textArea.addMouseWheelListener(new MouseWheelHandler());
		this.add(this.textArea, BorderLayout.CENTER);
		this.textArea.setText(content);
		this.textArea.setEditable(editable);
	}
	
	// Getter & Setter
	public void setContent(String content) {this.textArea.setText(content);}
	public String getContent() {return this.textArea.getText();}
	public String getTitle() {return this.titleLabel.getText();}
	
	// Inner Class
	private class MouseWheelHandler implements MouseWheelListener {
		@Override public void mouseWheelMoved(MouseWheelEvent e) {((Component) e.getSource()).getParent().dispatchEvent(e);}
	}
}
