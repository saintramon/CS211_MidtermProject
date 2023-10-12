package backend;

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

    @Override
    public void push(T item) {

    } // end of push method

    @Override
    public T pop() throws StackUnderflowException {
        return null;
    } // end of pop method

    @Override
    public T peek() throws StackUnderflowException {
        return null;
    } // end of peek method

    /**
     * TODO: Documentation
     * @return Integer representation of the stack's size.
     */
    @Override
    public int size() {
        return this.count;
    } // end of size method

    /**
     * TODO: Documentation
     * @return true if the stack is empty, false if otherwise.
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    } // end of isEmpty method
} // end of class Stack
