package Project2.backend;

import javax.swing.*;
import java.awt.*;

public class HuffmanTree extends JPanel {
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
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(node.getSymbol()) + ":" + node.getCount(), x, y);

            if (node.getLeft() != null) {
                int nextX = x - xOffset;
                int nextY = y + 50;
                g.drawLine(x, y, nextX, nextY);
                drawHuffmanTree(g, nextX, nextY, node.getLeft(), xOffset / 2);
            }

            if (node.getRight() != null) {
                int nextX = x + xOffset;
                int nextY = y + 50;
                g.drawLine(x, y, nextX, nextY);
                drawHuffmanTree(g, nextX, nextY, node.getRight(), xOffset / 2);
            }
        }
    }
}
