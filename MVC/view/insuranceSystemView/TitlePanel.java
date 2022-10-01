package view.insuranceSystemView;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.aConstant.InsuranceSystemViewConstant;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel {

	// Constructor
	public TitlePanel() {
		// Set Attribute
		this.setBackground(InsuranceSystemViewConstant.TitlePanelBackground);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// Create Component
		JLabel titleLabel = new JLabel(InsuranceSystemViewConstant.TitlePanelTitle);
		titleLabel.setFont(InsuranceSystemViewConstant.TitlePanelTitleFont);
		titleLabel.setForeground(InsuranceSystemViewConstant.TitlePanelForeground);
		this.add(titleLabel);
	}
}
