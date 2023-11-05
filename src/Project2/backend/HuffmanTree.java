package Project2.backend;

import Project2.frontend.Resources;

import javax.swing.*;
import java.awt.*;

public class HuffmanTree extends JPanel {
    private final Resources resources = new Resources();

    private Node root;

    public HuffmanTree() {
        root = null;
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
        if (this.root != null) {
            drawHuffmanTree(g, getWidth() / 2, 30, this.root, getWidth() / 4);
        }
    }

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
}
