package Project1.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * The RoundJButton class extends JButton to create a custom rounded button with a rounded rectangular shape.
 */
public class RoundJButton extends JButton {
    /**
     * The shape of the rounded button
     */
    private Shape shape;
    /**
     *An instance of the Resources class for resources access
     */
    Resources resources = new Resources();
    /**
     * Constructs a new RoundJButton. The button is set to be non-opaque
     * to make it visually round.
     */
    public RoundJButton() {
        setOpaque(false);
    }
    /**
     * Paints the component with a filled rounded rectangle representing the button.
     * @param g The Graphics object used for rendering.
     */
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    /**
     * Paints the border of the rounded button with a rounded rectangular shape.
     * @param g The Graphics object used for rendering.
     */
    protected void paintBorder(Graphics g) {
        g.setColor(resources.greyishBlack);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    /**
     * Checks whether a point (x, y) is contained within the rounded button shape.
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @return true if the point is contained within the button's shape, false otherwise.
     */
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}