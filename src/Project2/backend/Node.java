package Project2.backend;

public class Node {
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
}
