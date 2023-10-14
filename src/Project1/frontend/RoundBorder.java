package Project1.frontend;
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

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // Paint other components first (e.g., background)
        super.paintBorder(c, g, x, y, width, height);

        // Now, paint the round border
        Color oldColor = g.getColor();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fillColor);
        g2d.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2d.setColor(color);
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2d.setColor(oldColor);
    }


    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }
}
