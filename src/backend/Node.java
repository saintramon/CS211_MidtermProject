package backend;

/**
 * @author ROXAS, Johan Rickardo & LACANILAO, Marvin Patrick
 * @version 1.00 (12 October 2023)
 * @param <T> The type of element stored in the node of the stack.
 */
public class Node<T> {
    /**
     * TODO: Documentation
     */
    private T data;

    /**
     * TODO: Documentation
     */
    private Node<T> next;

    /**
     * Constructs an object of Node with null values.
     */
    public Node() {
        data = null;
        next = null;
    } // end of Node default constructor

    /**
     * Constructs an object of Node with user-defined values.
     * @param data given data to be stored.
     * @param next given reference to the next node.
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    } // end of Node constructor

    /**
     * Constructs an object of Node with user-defined data.
     * @param data given data to be stored.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    } // end of Node constructor (data only)

    /**
     * TODO: Documentation
     * @return data being stored
     */
    public T getData() {
        return data;
    } // end of getData accessor method

    /**
     * TODO: Documentation
     * @param data given data to be stored.
     */
    public void setData(T data) {
        this.data = data;
    } // end of setData mutator method

    /**
     * TODO: Documentation
     * @return reference to the next Node.
     */
    public Node<T> getNext() {
        return next;
    } // end of getNext accessor method

    /**
     * TODO: Documentation
     * @param next given reference to the next Node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    } // end of setNext mutator method

    /**
     * Returns a String implementation of the Node's data
     * @return
     */
    public String toString() {
        return "" + this.data;
    } // end of toString method
} // end of class Node
