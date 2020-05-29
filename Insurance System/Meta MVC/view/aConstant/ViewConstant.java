package view.aConstant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class ViewConstant {

	// Theme
	public static final Color ThemeColor = Color.white;
	
	// Main Frame
	public static final String MainFrameTitle = "Insurance System";
	public static final Dimension MainFrameSize = new Dimension(1400, 800);
	
	// Basic Panel
	public static final Color BasicPanelBackground = ViewConstant.ThemeColor;
	public static final int BasicPanelVerticalScrollUnit = 16;
	public static final int BasicPanelComponentGap = 10;
	
	// Basic Label
	public static final Color BasicLabelBackground = Color.white;
	public static final String BasicLabelFont = "¸¼Àº °íµñ";
	
	// Output Text Area
	public static final Color OutputTextAreaPanelBackground = Color.white;
	public static final int OutputTextAreaPanelTextAreaHeightUnit = 20;
	public static final Font OutputTextAreaPanelLabelFont = new Font("¸¼Àº °íµñ", Font.BOLD, 15);
	public static final Border OutputTextAreaEmptyBorder = BorderFactory.createEmptyBorder(5, 15, 0, 0);
	
	// Input Text Area
	public static final Font InputTextAreaPanelLabelFont = new Font("¸¼Àº °íµñ", Font.PLAIN, 15);
	public static final int InputTextAreaPanelTextAreaHeightUnit = 20;
	public static final Color InputTextAreaPanelBackground = new Color(235,240,245);
	public static final int InputTextAreaBasicBound = 25;
	public static final Border InputTextAreaEmptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	public static final Border InputTextAreaBorder = BorderFactory.createLineBorder(new Color(173,185,193));
	public static final Border InputTextAreaPanelBorder = BorderFactory.createLineBorder(new Color(220,226,229));
	
	// Titled Radio Button Group
	public static final String TitledRadioButtonGroupNormalIcon = "Radio_Normal.png";
	public static final String TitledRadioButtonGroupSelectedIcon = "Radio_Selected.png";
	public static final Color TitledRadioButtonGroupBackground = ViewConstant.ThemeColor;
	public static final Color TitledRadioButtonGroupButtonColor = ViewConstant.ThemeColor;
	public static final Color TitledRadioButtonGroupTextColor = new Color(110,110,110);
	public static final int TitledRadioButtonTitleHeightSize = 20;
	public static final Dimension TitledRadioButtonButtonMaximumSize = new Dimension(Integer.MAX_VALUE, 27);
	public static final Font TitledRadioButtonLabelFont = new Font("¸¼Àº °íµñ", Font.PLAIN, 15);
	
	// Basic Group
	public static final Color BasicGroupBorderColor = new Color(220,226,229);
}
