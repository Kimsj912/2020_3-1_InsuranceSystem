package view.insuranceSystemView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.aConstant.InsuranceSystemViewConstant;
import aConstant.ViewConstant;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	
	// Component
	private LinkPanel linkPanel;
	private ContentPanel contentPanel;
	
	public CenterPanel() {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(InsuranceSystemViewConstant.CenterPanelBackground);
		
		// Create Component
		this.add(new TitlePanel(), BorderLayout.NORTH);
		
		this.linkPanel = new LinkPanel();
		this.add(this.linkPanel, BorderLayout.WEST);
		
		this.contentPanel = new ContentPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setPreferredSize (new Dimension(0, 0)); // hide scroll bar
		scrollPane.getVerticalScrollBar().setUnitIncrement(ViewConstant.BasicPanelVerticalScrollUnit);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(this.contentPanel);
		this.add(scrollPane, BorderLayout.CENTER);
	}
	
	// Create Time Use
	public void addToLinkPanel(JComponent...comps) {for(JComponent comp : comps) {this.linkPanel.addToLinkPanel(comp);}}
	public void setLinkPanelWidth(int w) {this.linkPanel.setPreferredSize(new Dimension(w, Integer.MAX_VALUE));}
	
	// Initialize Time Use
	public void addComponent(JComponent comp) {this.contentPanel.addComponent(comp);}
	public void addBackButton(ActionListener actionListener) {this.contentPanel.addBackButton(actionListener);}
	public void addEmptyToolSpace() {this.contentPanel.addEmptyToolSpace();}
}
