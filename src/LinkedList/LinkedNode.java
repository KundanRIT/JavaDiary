package LinkedList;

public class LinkedNode<T> {
    public T value;
    public LinkedNode<T> next;

    public LinkedNode(T value, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
