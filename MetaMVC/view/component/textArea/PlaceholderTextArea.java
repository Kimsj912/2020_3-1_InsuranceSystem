package component.textArea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PlaceholderTextArea extends JTextArea {
	
	// Attribute
    private String placeholder;

	@Override
    protected void paintComponent(Graphics pG) {
        super.paintComponent(pG);
        if (this.placeholder == null || this.placeholder.length() == 0 || getText().length() > 0) {return;}
        Graphics2D g = (Graphics2D) pG;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(this.getDisabledTextColor());
		g.drawString(this.placeholder, this.getInsets().left, pG.getFontMetrics().getMaxAscent() + this.getInsets().top);
    }

    // Getter & Setter
    public void setPlaceholder(String s) { this.placeholder = s;}
}
