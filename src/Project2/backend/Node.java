package Project2.backend;

public class Node implements Comparable<Node>{
    private char symbol;
    private int count;
    private Node left;
    private Node right;

    public Node(){
        this.symbol = 'x';
        this.count = 0;
        this.left = null;
        this.right = null;
    }

    public Node(char symbol, int count){
        this.symbol = symbol;
        this.count = count;
        this.left = null;
        this.right = null;
    }

    public Node(char symbol, int count, Node left, Node right){
        this.symbol = symbol;
        this.count = count;
        this.left = left;
        this.right = right;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

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
     * TODO: Documentation
     * @return String representation of the current symbol
     */
    public String toString() {
        return String.valueOf(symbol);
    }
}
