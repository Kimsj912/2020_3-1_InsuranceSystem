package component.textArea;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BasicTitledTextArea extends JPanel {
	
	// Component
	protected JLabel titleLabel; 
	protected PlaceholderTextArea textArea;
	
	// Getter & Setter
	public void setContent(String content) {this.textArea.setText(content);}
	public String getContent() {return this.textArea.getText();}
	public String getTitle() {return this.titleLabel.getText();}
	public void setComponentForeGround(Color c) {this.titleLabel.setForeground(c); this.textArea.setForeground(c);}
	
	// Inner Class
	protected class MouseWheelHandler implements MouseWheelListener {
		@Override public void mouseWheelMoved(MouseWheelEvent e) {((Component) e.getSource()).getParent().dispatchEvent(e);}
	}
}
