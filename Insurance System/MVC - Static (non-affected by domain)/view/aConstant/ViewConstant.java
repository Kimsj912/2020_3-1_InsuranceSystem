package view.aConstant;

import java.awt.Color;
import java.awt.Dimension;

public class ViewConstant {

	// Theme
	public static final Color ThemeColor = Color.white;
	
	// Main Frame
	public static final String MainFrameTitle = "Insurance System";
	public static final Dimension MainFrameSize = new Dimension(1200, 800);
	
	// Basic Panel
	public static final Color BasicPanelBackground = ViewConstant.ThemeColor;
	public static final int BasicPanelVerticalScrollUnit = 16;
	public static final int BasicPanelComponentGap = 10;
	
	// Basic Button
	public static final Color BasicButtonBackground = Color.LIGHT_GRAY;
	
	// Back Button
	public static final String BackButtonIdentifier = "Back Button"; // 유니크 하기만 하면 됨
	public static final String BackButtonText = "←";
	public static final Dimension BackButtonSize = new Dimension(50, 30);
	public static final Color BackButtonBackground = ViewConstant.ThemeColor;
	
	// Logout Button
	public static final String LogoutButtonIdentifier = "Logout Button"; // 유니크 하기만 하면 됨
	public static final String LogoutButtonText = "Logout";
	public static final Dimension LogoutButtonSize = new Dimension(80, 30);
	public static final Color LogoutButtonBackground = ViewConstant.ThemeColor;
	
	// Titled Text Area
	public static final Color TitledTextAreaPanelBackground = ViewConstant.ThemeColor;
	public static final int TitledTextAreaPanelLabelHeight = 20;
	public static final int TitledTextAreaPanelTextAreaHeightUnit = 20;
}
