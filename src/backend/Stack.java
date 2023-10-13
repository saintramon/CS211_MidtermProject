package backend;

import java.lang.*;

/**
 * @author ROXAS, Johan Rickardo & LACANILAO, Marvin Patrick
 * A stack implementation that implements the StackInterface.
 * @param <T> The type of elements stored in the stack.
 */
public class Stack<T> implements StackInterface<T> {

    /**
     * The last and top element of the stack.
     */
    private Node<T> top;

    /**
     * The number of elements stored in the stack.
     */
    private int count;

    /**
     * Constructs a Stack with null values.
     */
    public Stack() {
        top = null;
        count = 0;
    } // end of Stack default constructor

    /**
     * Inserts a given Node in the Stack and sets itself as the top node.
     * @param item given data to be inserted.
     */
    @Override
    public void push(T item) {
        Node<T> node = new Node<>(item);
        if (!isEmpty()) {
            node.setNext(top);
        } // end of if-else
        top = node;
        count++;
    } // end of push method

    /**
     * Removes an element from the Stack and returns the removed element.
     * @return The element being removed.
     */
    @Override
    public T pop(){
        T topElement = null;
        if (!isEmpty()) {
            topElement = top.getData();
            if (count == 1) {
                top = null;
            } else {
                top = top.getNext();
            } // end of if-else (count)
            count--;
        } // end of if
        return topElement;
    } // end of pop method

    /**
     * Returns the top element of the stack without deleting the element.
     * @return The data of the top element.
     */
    @Override
    public T peek() {
        if (!isEmpty()) {
            return top.getData(); // returns if stack and top is not null
        } // end of if-else (isEmpty)
        return null;
    } // end of peek method

    /**
     * Represents the size or length of the stack using the stack's count.
     * @return Integer representation of the stack's size.
     */
    @Override
    public int size() {
        return this.count;
    } // end of size method

    /**
     * Checks the stack's size if it is empty or not.
     * @return true if the stack is empty, false if otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0; // returns true if count is equal to 0.
    } // end of isEmpty method
} // end of class Stack
