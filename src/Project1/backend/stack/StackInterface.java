package Project1.backend.stack;

/**
 * @author ROXAS, Johan Rickardo
 * @version 1.00 (12 October 2023)
 * An interface representing a generic stack data structure.
 * @param <T> The type of elements in the stack.
 */
public interface StackInterface<T> {
    /**
     * Adds an item to the top of the stack.
     * @param item element is to be added to the stack.
     */
    public void push(T item);

    /**
     * Removes and returns the top element from the stack.
     * @return the elemet removed from the top.
     */
    public T pop();

    /**
     * Retrieves top element of the stack without removing it.
     * @return the element at the top of the stack.
     */
    public T peek() ;

    /**
     * Returns the size of the stack, indicating the number of elements it contains.
     * @return The size of the stack.
     */
    public int size();

    /**
     * Check if the stack is empty.
     * @return true if empty, false if not.
     */
    public boolean isEmpty();
}
