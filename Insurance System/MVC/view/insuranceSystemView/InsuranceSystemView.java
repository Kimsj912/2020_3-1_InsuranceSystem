package view.insuranceSystemView;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JPanel;

import view.aConstant.InsuranceSystemViewConstant;
import view.panel.BasicPanel;

@SuppressWarnings("serial")
public class InsuranceSystemView extends JPanel implements BasicPanel {
	
	// Component
	private CenterPanel centerPanel;
	
	// Constructor
	public InsuranceSystemView() {
		// Set Attributes
		this.setBackground(InsuranceSystemViewConstant.InsuranceSystemPanelBackground);
		this.setLayout(new BorderLayout());
		
		// Create Component
		this.centerPanel = new CenterPanel();
		this.add(this.centerPanel, BorderLayout.CENTER);
		this.add(Box.createHorizontalStrut(InsuranceSystemViewConstant.LeftRightMargin), BorderLayout.WEST);
		this.add(Box.createHorizontalStrut(InsuranceSystemViewConstant.LeftRightMargin), BorderLayout.EAST);
		this.add(Box.createVerticalStrut(InsuranceSystemViewConstant.DownMargin), BorderLayout.SOUTH);
	}
	
	// Create Time Use
	public void addToLinkPanel(JComponent...comps) {this.centerPanel.addToLinkPanel(comps);}
	public void setLinkPanelWidth(int w) {this.centerPanel.setLinkPanelWidth(w);}
	
	// Initialize Time Use
	@Override public void addComponent(JComponent comp) {this.centerPanel.addComponent(comp);}
	@Override public void addBackButton(ActionListener actionListener) {this.centerPanel.addBackButton(actionListener);}
	@Override public void addEmptyToolSpace() {this.centerPanel.addEmptyToolSpace();}
}
