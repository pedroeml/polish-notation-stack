package def;

import java.util.EmptyStackException;

public class StackLinked<E> implements StackTAD<E> {
    private static final class Node<E> {
        public E element;
        public Node<E> next;
        
        public Node(E e){
            element = e;
            next = null;
        }
    }

    private Node<E> head;
    private int count;
    
    public StackLinked() {
        clear();
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }
    
    public void clear() {
        head = null;
        count = 0;        
    }

    public E top() {
        if(isEmpty())
            throw new EmptyStackException();
        return head.element;
    }

    public void push(E element) {
        Node<E> n = new Node<E>(element);
        n.next = head;
        head = n;
        count++;
    }
    
    public E pop() {
        if(isEmpty())
            throw new EmptyStackException();
        E item = head.element;
        head = head.next;
        count--;
        return item;
    }
    
	public void print()  {
        System.out.print("[ ");
        print(head);
        System.out.println("]");
    }

    private void print(Node<E> p){
        if(p == null) return;
        System.out.printf("%6.6f ", p.element);
        print(p.next);
    }
}
