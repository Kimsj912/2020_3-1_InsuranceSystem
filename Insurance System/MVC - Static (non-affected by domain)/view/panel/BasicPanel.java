package view.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.aConstant.ViewConstant;
import view.component.BackButton;
import view.component.LogoutButton;

@SuppressWarnings("serial")
public class BasicPanel extends JPanel {
	
	// Component 
	private JPanel mainPanel, toolPanel;
	
	// Constructor
	public BasicPanel() {
		// Set Attributes
		this.setBackground(ViewConstant.BasicPanelBackground);
		this.setLayout(new BorderLayout());
		
		// Create Component
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout());
		centerPanel.setBackground(this.getBackground());
		this.add(centerPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setPreferredSize (new Dimension(0, 0)); // hide scroll bar
		scrollPane.getVerticalScrollBar().setUnitIncrement(ViewConstant.BasicPanelVerticalScrollUnit);
		
		centerPanel.add(Box.createHorizontalBox());
		centerPanel.add(scrollPane);
		centerPanel.add(Box.createHorizontalBox());
		
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(ViewConstant.BasicPanelBackground);
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(this.mainPanel);
		
		this.toolPanel = new JPanel();
		this.toolPanel.setBackground(ViewConstant.BasicPanelBackground);
		this.toolPanel.setLayout(new BorderLayout());
		super.add(this.toolPanel, BorderLayout.NORTH);
		
		super.add(Box.createVerticalStrut(ViewConstant.BackButtonSize.height), BorderLayout.SOUTH);
	}
	
	// Initialize Time Use
	public void addComponents(Vector<JComponent> viewInfo) {
		for(JComponent comp : viewInfo) {this.addComponent(comp);}
	}
	private void addComponent(JComponent comp) {
		comp.setAlignmentX(CENTER_ALIGNMENT);
		this.mainPanel.add(comp);
		this.mainPanel.add(Box.createVerticalStrut(ViewConstant.BasicPanelComponentGap));
	}
	public void addToolBTN(Component comp, String borderLayoutPosition) {this.toolPanel.add(comp, borderLayoutPosition);}
	public void addBackButton(ActionListener actionListener) {
		BackButton bb = new BackButton(actionListener); this.toolPanel.add(bb, BorderLayout.WEST);
		LogoutButton lb = new LogoutButton(actionListener); this.toolPanel.add(lb, BorderLayout.EAST);
	}
	public void addEmptyToolSpace() {
		this.addToolBTN(Box.createVerticalStrut(ViewConstant.BackButtonSize.height), BorderLayout.WEST);
		this.addToolBTN(Box.createVerticalStrut(ViewConstant.LogoutButtonSize.height), BorderLayout.EAST);		
	}
}
