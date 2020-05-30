package view.insuranceSystemView;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import view.aConstant.InsuranceSystemViewConstant;
import view.component.SeparateLine;

@SuppressWarnings("serial")
public class LinkPanel extends JPanel {

	// Constructor
	public LinkPanel() {
		// Set Attribute
		this.setBackground(InsuranceSystemViewConstant.LinkPanelBackground);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(230, Integer.MAX_VALUE));
	}
	
	public void addToLinkPanel(JComponent comp) {
		this.add(comp);
		this.add(new SeparateLine(InsuranceSystemViewConstant.LinkPanelSeperatorColor));
	}
}
