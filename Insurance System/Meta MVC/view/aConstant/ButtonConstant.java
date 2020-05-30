package view.aConstant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ButtonConstant {

	// Basic Button
	public static final Color BasicButtonBackground_Clicked = new Color(255,90,0);
	public static final Color BasicButtonBackground_MouseOn = new Color(255,120,0);
	public static final Color BasicButtonBackground_Normal =  new Color(161,165,177);
	public static final Color BasicButtonForeground =  Color.white;
	
	// Back Button
	public static final String BackButtonIdentifier = "Back Button"; // 유니크 하기만 하면 됨
	public static final String BackButtonText = "←";
	public static final Dimension BackButtonSize = new Dimension(50, 30);
	public static final Color BackButtonForeground = new Color(161,165,177);
	public static final Color BackButtonBackground = ViewConstant.ThemeColor;
	
	// Logout Button
	public static final String LogoutButtonIdentifier = "Logout Button"; // 유니크 하기만 하면 됨
	public static final String LogoutButtonText = "Logout";
	public static final Dimension LogoutButtonSize = new Dimension(80, 30);
	public static final Color LogoutButtonForeground = new Color(161,165,177);
	public static final Color LogoutButtonBackground = ViewConstant.ThemeColor;
	
	// Select Button + ActionButton
	public static final Color SelectButtonForeground =new Color(106,107,112);
	public static final Color SelectButtonBackground_Normal = Color.white;
	public static final Color SelectButtonBackground_Clicked = new Color(214,231,248);
	public static final Color SelectButtonBackground_MouseOn = new Color(214,231,248);
	public static final Color SelectButtonBorderColor = new Color(229,234,239);
	
	// Link Button
	public static final int LinkButtonPreferredHeight = 65;
	public static final Color LinkButtonBackgroundColor = new Color(220,225,231);
	public static final Color LinkButtonClickColor = new Color(220,225,231);
	public static final Color LinkButtonMouseOnColor = new Color(242,245,250);
	public static final Color LinkButtonForegroundColor = new Color(68,68,68);
	public static final Font LinkButtonFont = new Font("맑은 고딕", Font.PLAIN, 20);
}
