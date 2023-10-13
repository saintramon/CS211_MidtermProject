package backend.stack;

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
     * @throws StackUnderflowException
     */
    public T pop() throws StackUnderflowException;

    /**
     * TODO: Documentation
     * @return
     * @throws StackUnderflowException
     */
    public T peek() throws StackUnderflowException;

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
