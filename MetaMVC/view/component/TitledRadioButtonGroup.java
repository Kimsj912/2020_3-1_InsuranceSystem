package component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import aConstant.ViewConstant;

@SuppressWarnings("serial")
public class TitledRadioButtonGroup extends JPanel {
	
	// Component
	private JLabel titleLabel; 
	private Vector<BasicRadioButton> btns;
	
	// Constructor
	public TitledRadioButtonGroup(String title, Class<? extends Enum<?>> targetEnum, boolean multiSelectable, int nameWidth) {
		// Set Attribute
		this.setLayout(new BorderLayout());
		this.setBackground(ViewConstant.OutputTextAreaPanelBackground);
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE, ViewConstant.TitledRadioButtonButtonMaximumSize.height*this.getEnumNames(targetEnum).length));
		
		// Create Component
		JPanel innerPanel = new JPanel();
		innerPanel.setBackground(ViewConstant.InputTextAreaPanelBackground);
		innerPanel.setLayout(new BorderLayout());
		this.add(innerPanel, BorderLayout.WEST);
		
		this.titleLabel = new JLabel("  "+title);
		this.titleLabel.setFont(ViewConstant.InputTextAreaPanelLabelFont);
		this.titleLabel.setPreferredSize(new Dimension(nameWidth, ViewConstant.InputTextAreaPanelLabelFont.getSize()));
		innerPanel.add(this.titleLabel, BorderLayout.CENTER);
		
		JPanel innerPanel2 = new JPanel();
		innerPanel2.setLayout(new BoxLayout(innerPanel2, BoxLayout.Y_AXIS));
		innerPanel2.setBackground(ViewConstant.TitledRadioButtonGroupBackground);
		this.add(innerPanel2, BorderLayout.CENTER);
		
		this.btns = new Vector<BasicRadioButton>();
		ButtonGroup group = new ButtonGroup();
		for(String optionName : this.getEnumNames(targetEnum)) {
			this.btns.add(new BasicRadioButton(optionName));
			if(!multiSelectable) {group.add(this.btns.lastElement());}
			innerPanel2.add(this.btns.lastElement());
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
		    this.setIcon(new ImageIcon(ViewConstant.TitledRadioButtonGroupNormalIcon));
		    this.setSelectedIcon(new ImageIcon(ViewConstant.TitledRadioButtonGroupSelectedIcon));
			this.setText(text);
			this.setForeground(ViewConstant.TitledRadioButtonGroupTextColor);
			this.setBackground(ViewConstant.TitledRadioButtonGroupButtonColor);
			this.setMaximumSize(ViewConstant.TitledRadioButtonButtonMaximumSize);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setFocusable(false);
		}
	}
}
