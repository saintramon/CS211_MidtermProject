package midlab2.backend;

/**
 * Represents a node in a data structure and implements the Comparable interface for comparing nodes based on their counts.
 */
public class Node implements Comparable<Node>{
    /**
     * Stores the character symbol associated with the node.
     */
    private char symbol;
    /**
     * Stores the count or frequency of the symbol in the data structure.
     */
    private int count;
    /**
     * References the left child node in a binary tree.
     */
    private Node left;
    /**
     * References the right child node in a binary tree.
     */
    private Node right;
    /**
     * Default constructor for the Node class, initializes symbol to 'x', count to 0, and sets left and right child nodes to null.
     */
    public Node(){
        this.symbol = 'x';
        this.count = 0;
        this.left = null;
        this.right = null;
    } // end of Node default constructor
    /**
     * Constructor that allows specifying symbol and count, initializing left and right child nodes to null.
     * @param symbol The character symbol associated with the node.
     * @param count The count or frequency of the symbol.
     */
    public Node(char symbol, int count){
        this.symbol = symbol;
        this.count = count;
        this.left = null;
        this.right = null;
    }
    /**
     * Constructor that allows specifying symbol, count, and left and right child nodes.
     * @param symbol The character symbol associated with the node.
     * @param count The count or frequency of the symbol.
     * @param left The left child node.
     * @param right The right child node.
     */
    public Node(char symbol, int count, Node left, Node right){
        this.symbol = symbol;
        this.count = count;
        this.left = left;
        this.right = right;
    }
    /**
     * Getter method for retrieving the symbol associated with the node.
     * @return The character symbol of the node.
     */
    public char getSymbol() {
        return symbol;
    }
    /**
     * Setter method for updating the symbol associated with the node.
     * @param symbol The new character symbol to set.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    /**
     * Getter method for retrieving the count of the symbol in the node.
     * @return The count of the symbol in the node.
     */
    public int getCount() {
        return count;
    }
    /**
     * Setter method for updating the count of the symbol in the node.
     * @param count The new count to set.
     */
    public void setCount(int count) {
        this.count = count;
    }
    /**
     * Getter method for retrieving the left child node.
     * @return The left child node.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Setter method for updating the left child node reference.
     * @param left The new left child node.
     */
    public void setLeft(Node left) {
        this.left = left;
    }
    /**
     * Getter method for retrieving the right child node.
     * @return The right child node.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Setter method for updating the right child node reference.
     * @param right The new right child node.
     */
    public void setRight(Node right) {
        this.right = right;
    }
    /**
     * Implementation of the compareTo method from the Comparable interface to compare nodes based on their counts.
     * @param another The node to compare with.
     * @return 0 if counts are equal, 1 if the current node's count is greater, -1 if the current node's count is less.
     */
    public int compareTo(Node another){
        if (this.count == another.count){
            return 0;
        } else if (this.count > another.count) {
            return 1;
        }else {
            return -1;
        }
    }
    /**
     * Overrides the toString method to provide a string representation of the symbol associated with the node.
     * @return String representation of the current symbol
     */
    public String toString() {
        return String.valueOf(symbol);
    }
}
