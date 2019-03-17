package LinkedList;

public class LinkedList<T> {

    LinkedNode<T> head = null;
    int size;

    public void prepend(T value) {
        head = new LinkedNode<T>(value, head);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LinkedList{ ");
        for (LinkedNode<T> cursor = head; cursor != null; cursor = cursor.next) {
            builder.append(cursor.value).append(" ");
        }
        builder.append("}");
        return builder.toString();
    }
}
