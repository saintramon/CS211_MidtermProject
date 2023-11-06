package Project2.backend;

import Project2.frontend.Resources;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HuffmanTree extends JPanel {
    private final Resources resources = new Resources();

    private Node root;

    private Point clickPoint; // track initial dragging

    private Point offset = new Point(0, 0);

    private JSlider zoomSlider;
    private double zoomLevel = 1.0;


    public HuffmanTree() {
        root = null;
        clickPoint = null;
        zoomSlider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100); // Adjust the min, max, and initial values as needed

        zoomSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                zoomLevel = zoomSlider.getValue() / 100.0;
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clickPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clickPoint = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (clickPoint != null) {
                    Point newPoint = e.getPoint();
                    int dx = newPoint.x - clickPoint.x;
                    int dy = newPoint.y - clickPoint.y;
                    // Adjust the current view's position based on the mouse drag
                    scroll(dx, dy);
                    clickPoint = newPoint;
                }
            }
        });

        setLayout(new BorderLayout());
        add(zoomSlider, BorderLayout.SOUTH);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node node) {
        root = node;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.translate(offset.x, offset.y);
        g2d.scale(zoomLevel, zoomLevel);

        if (this.root != null) {
            drawHuffmanTree(g2d, getWidth() / 2, 30, this.root, getWidth());
        }

        g2d.dispose();
    } // end of paintComponent method

    /**
     * If the root node of the tree is not null, the method will call itself recursively with the root node as input.
     * The method checks if the currently processed node is not null. If not, it sets the color to 'sage' from the Resource class
     * The method sets the font to bold "Arial" and 13 in size. It draws the node's symbol and count on screen.
     * If the current node has a left child, the method recursively calls itself with the child as input, and draws a line to connect the left child to the node,
     * and draws the symbol '0' between the child and the node.
     *
     * If current node has a right child, the method recursively calls itself with the right child as input, draws a line to connect the right child to the node,
     * and draws the symbol '1' between the child and the node.
     *
     * By recursively calling itself with both children of each node, the method paints the entire Huffman tree.
     * @param g graphics object used for drawing
     * @param x x-coordinate for the current node
     * @param y y-coordinate for the current node
     * @param node current node being processed
     * @param xOffset horizontal offset for drawing child nodes
     */
    private void drawHuffmanTree(Graphics g, int x, int y, Node node, int xOffset) {
        if (node != null) {
            g.setColor(resources.sage);

            g.drawOval(x - 25, y - 15, 50, 50);

            g.setFont(new Font("Arial", Font.BOLD, 13));
            g.setColor(Color.BLACK);

            g.drawString(String.valueOf(node.getSymbol()), x - 5, y + 5);
            g.drawString(String.valueOf(node.getCount()), x - 5, y + 20);

            if (node.getLeft() != null) {
                int nextX = x - xOffset;
                int nextY = y + 50;
                g.drawLine(x, y, nextX, nextY);
                drawHuffmanTree(g, nextX, nextY, node.getLeft(), xOffset / 2);
                g.drawString("0", (x + nextX) / 2, (y + nextY) / 2);
            }

            if (node.getRight() != null) {
                int nextX = x + xOffset;
                int nextY = y + 50;
                g.drawLine(x, y, nextX, nextY);
                drawHuffmanTree(g, nextX, nextY, node.getRight(), xOffset / 2);
                g.drawString("1", (x + nextX) / 2, (y + nextY) / 2);
            }
        }
    }

    private void scroll(int dx, int dy) {
        offset.x += dx;
        offset.y += dy;
        repaint();
    }

}
