package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.aConstant.ButtonConstant;
import view.aConstant.ViewConstant;
import view.component.button.BackButton;
import view.component.button.LogoutButton;
import view.panel.BasicPanel;

@SuppressWarnings("serial")
public class InsuranceSystemPanel_Old extends BasicPanel {
	
	// Component 
	private JPanel mainPanel, toolPanel;
	
	// Constructor
	public InsuranceSystemPanel_Old() {
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
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
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
		
		super.add(Box.createVerticalStrut(ButtonConstant.BackButtonSize.height), BorderLayout.SOUTH);
	}
	
	// Initialize Time Use
	@Override 
	public void addComponent(JComponent comp) {
		comp.setAlignmentX(CENTER_ALIGNMENT);
		this.mainPanel.add(comp);
		this.mainPanel.add(Box.createVerticalStrut(ViewConstant.BasicPanelComponentGap));
	}
	public void addToolBTN(Component comp, String borderLayoutPosition) {this.toolPanel.add(comp, borderLayoutPosition);}
	@Override
	public void addBackButton(ActionListener actionListener) {
		BackButton bb = new BackButton(actionListener); this.toolPanel.add(bb, BorderLayout.WEST);
		LogoutButton lb = new LogoutButton(actionListener); this.toolPanel.add(lb, BorderLayout.EAST);
	}
	@Override
	public void addEmptyToolSpace() {
		this.addToolBTN(Box.createVerticalStrut(ButtonConstant.BackButtonSize.height), BorderLayout.WEST);
		this.addToolBTN(Box.createVerticalStrut(ButtonConstant.LogoutButtonSize.height), BorderLayout.EAST);		
	}
}
