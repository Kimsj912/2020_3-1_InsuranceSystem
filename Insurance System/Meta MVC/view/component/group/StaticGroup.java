package view.component.group;

import java.awt.Component;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import view.aConstant.ViewConstant;
import view.component.SeparateLine;

@SuppressWarnings("serial")
public class StaticGroup extends JPanel {

	// Example
	// int[] = {3,2,1}
	// () () ()
	// (  )(  )
	// (      )
	
	// Attribute 
	private int[] groupDesign;
	
	// Working Variable
	private int nowAdded;
	
	// Component
	private Vector<JPanel> innerPanels;
	
	// Constructor
	public StaticGroup(int[] groupDesign) {
		// Set Attribute
		this.groupDesign=groupDesign;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(ViewConstant.BasicGroupBorderColor));
		
		// Create Component
		this.innerPanels = new Vector<JPanel>();
		for(int i=0; i<groupDesign.length; i++) {
			JPanel innerPanel = new JPanel();
			innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.X_AXIS));
			this.innerPanels.add(innerPanel);
			this.add(innerPanel);
			this.add(new SeparateLine(ViewConstant.BasicGroupBorderColor));
		}
		this.remove(this.getComponents()[this.getComponents().length-1]);
	}
	
	// Any Time Use
	public void addGroupComponent(Component...comps) {for(Component comp : comps) {this.addGroupComponent(comp);}}
	public void addGroupComponent(Component comp) {
		int seatNum = 0;
		for(int i=0; i<this.groupDesign.length; i++) {
			if(this.nowAdded < seatNum + this.groupDesign[i]) {this.innerPanels.get(i).add(comp); break;}
			else {seatNum +=this.groupDesign[i];}
		}
		this.nowAdded++;
	}
}
