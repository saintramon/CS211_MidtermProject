package frontend;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundBorder extends AbstractBorder {
    private int radius;
    private Color color;
    private Color fillColor;

    public RoundBorder(int radius, Color color, Color fillColor) {
        this.radius = radius;
        this.color = color;
        this.fillColor = fillColor;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Color oldColor = g.getColor();

        g.setColor(fillColor);
        g.fillRoundRect(x, y, width - 1, height - 1, radius, radius);

        g.setColor(color);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g.setColor(oldColor);

    }

    public Insets getBorderInsets(Component c) {
        int value = (int) Math.ceil(radius / 2.0);
        return new Insets(value, value, value, value);
    }

    public Insets getBorderInsets(Component c, Insets insets) {
        insets = getBorderInsets(c);
        return insets;
    }
}
