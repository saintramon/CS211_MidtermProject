package Project1.backend.stack;

/**
 * @author ROXAS, Johan Rickardo
 * @version 1.00 (12 October 2023)
 * An interface representing a generic stack data structure.
 * @param <T> The type of elements in the stack.
 */
public interface StackInterface<T> {
    /**
     * TODO: Documentation
     * @param item
     */
    public void push(T item);

    /**
     * TODO: Documentation
     * @return
     */
    public T pop();

    /**
     * TODO: Documentation
     * @return
     */
    public T peek() ;

    /**
     * TODO: Documentation
     * @return The size of the stack.
     */
    public int size();

    /**
     * TODO: Documentation
     * @return
     */
    public boolean isEmpty();
}
