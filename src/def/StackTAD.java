package def;

public interface StackTAD<E>
{
    void push(E element);
    E pop();
    int size();
    boolean isEmpty();
    void clear();
    E top();
}
