package view.panel;

import java.awt.event.ActionListener;

import javax.swing.JComponent;

public interface BasicPanel {
	
	// Initialize Time Use
	public void addComponent(JComponent comp);
	public void addBackButton(ActionListener actionListener);
	public void addEmptyToolSpace();
}
