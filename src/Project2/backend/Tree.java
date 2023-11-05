package Project2.backend;

public interface Tree<T extends Comparable<T>>{
    public Tree<T> insert(T data);
    public void traverse();
    public T getMinimum();
    public T getMaximum();
}
