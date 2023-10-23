package Project1.backend.stack;

/**
 * @author ROXAS, Johan Rickardo & LACANILAO, Marvin Patrick
 * @version 1.00 (12 October 2023)
 * @param <T> The type of element stored in the node of the stack.
 */
public class Node<T> {
    /**
     * The data stored in this node.
     */
    private T data;

    /**
     * A reference to the next node in the stack.
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
     * Get the data stored in the node.
     * @return data being stored
     */
    public T getData() {
        return data;
    } // end of getData accessor method

    /**
     * Set the data to be stored in the node.
     * @param data given data to be stored.
     */
    public void setData(T data) {
        this.data = data;
    } // end of setData mutator method

    /**
     * Get a reference to the next Node.
     * @return reference to the next Node.
     */
    public Node<T> getNext() {
        return next;
    } // end of getNext accessor method

    /**
     * Set the reference to the next Node.
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
