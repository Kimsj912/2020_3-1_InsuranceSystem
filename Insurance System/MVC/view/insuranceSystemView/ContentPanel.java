package view.insuranceSystemView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import view.aConstant.ButtonConstant;
import view.aConstant.InsuranceSystemViewConstant;
import view.aConstant.ViewConstant;
import view.component.button.BackButton;
import view.component.button.LogoutButton;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel {

	// Component
	private JPanel toolPanel, mainPanel;
			
	public ContentPanel() {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(InsuranceSystemViewConstant.ContentPanelBackground);
		
		// Create Component
		this.toolPanel = new JPanel();
		this.toolPanel.setLayout(new BorderLayout());
		this.toolPanel.setBackground(InsuranceSystemViewConstant.ContentPanelBackground);
		this.add(this.toolPanel, BorderLayout.NORTH);
		
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(InsuranceSystemViewConstant.ContentPanelBackground);
		this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
		this.mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 32, 0, 32));
		this.add(this.mainPanel, BorderLayout.CENTER);
	}
	
	// Initialize Time Use
	public void addComponent(JComponent comp) {
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
		this.addToolBTN(Box.createVerticalStrut(ButtonConstant.BackButtonSize.height), BorderLayout.WEST);
		this.addToolBTN(Box.createVerticalStrut(ButtonConstant.LogoutButtonSize.height), BorderLayout.EAST);		
	}
}
