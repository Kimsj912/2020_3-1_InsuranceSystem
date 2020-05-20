package view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import view.aConstant.ViewConstant;

@SuppressWarnings("serial")
public class TitledRadioButtonGroup extends JPanel {
	
	// Component
	private JLabel titleLabel; 
	private Vector<BasicRadioButton> btns;
	
	// Constructor
	public TitledRadioButtonGroup(String title, Class<? extends Enum<?>> targetEnum, boolean multiSelectable) {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(ViewConstant.TitledTextAreaPanelBackground);
//		this.setPreferredSize(new Dimension(0, 0));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, ViewConstant.TitledRadioButtonButtonMaximumSize.height*this.getEnumNames(targetEnum).length));
		
		// Create Component
		this.titleLabel = new JLabel(title);
		this.add(this.titleLabel, BorderLayout.NORTH);
		
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.setBackground(ViewConstant.TitledRadioButtonGroupBackground);
		this.add(innerPanel, BorderLayout.CENTER);
		
		this.btns = new Vector<BasicRadioButton>();
		ButtonGroup group = new ButtonGroup();
		for(String optionName : this.getEnumNames(targetEnum)) {
			this.btns.add(new BasicRadioButton(optionName));
			if(!multiSelectable) {group.add(this.btns.lastElement());}
			innerPanel.add(this.btns.lastElement());
		}
	}
	
	// Getter & Setter
	private String[] getEnumNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
	public String getTitle() {return this.titleLabel.getText();}
	public Vector<String> getSelectedOptionNames() {
		Vector<String> result = new Vector<String>();
		for(BasicRadioButton btn : this.btns) {if(btn.isSelected()) {result.add(btn.getText());}}
		return result;
	}
	
	// Inner Class
	private class BasicRadioButton extends JRadioButton {
		// Constructor
		public BasicRadioButton(String text) { 
			// Set Attribute
			this.setText(text);
			this.setBackground(ViewConstant.TitledRadioButtonGroupButtonColor);
			this.setMaximumSize(ViewConstant.TitledRadioButtonButtonMaximumSize);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setFocusable(false);
		}
	}
}
