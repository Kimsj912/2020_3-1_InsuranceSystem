package component.group;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import aConstant.ViewConstant;
import component.SeparateLine;

@SuppressWarnings("serial")
public class DynamicGroup extends JPanel {

	// Constructor
	public DynamicGroup() {
		// Set Attribute
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(ViewConstant.BasicGroupBorderColor));
	}
	
	// Any Time Use
	public void addGroupComponent(Component...comps) {for(Component comp : comps) {this.addGroupComponent(comp);}}
	public void addGroupComponent(Component comp) {
		this.add(comp);
		this.add(new SeparateLine(ViewConstant.BasicGroupBorderColor));
	}
}
