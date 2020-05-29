package view.panel;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class BasicPanel extends JPanel {
	
	// Initialize Time Use
	public abstract void addComponent(JComponent comp);
	public abstract void addBackButton(ActionListener actionListener);
	public abstract void addEmptyToolSpace();
}
