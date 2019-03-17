package LinkedList;

public class Reverse {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        linkedlist.prepend(19);
        linkedlist.prepend(99);
        linkedlist.prepend(27);
        linkedlist.prepend(33);
        linkedlist.prepend(81);
        linkedlist.prepend(4);
        System.out.println(linkedlist);

        linkedlist.head = reverse(linkedlist.head);

        System.out.println(linkedlist);
    }

    public static LinkedNode<Integer> reverse(LinkedNode<Integer> head) {
        LinkedNode<Integer> prev = null;
        LinkedNode<Integer> temp;
        LinkedNode<Integer> cursor = head;
        while (cursor != null) {
            temp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = temp;
        }
        return prev;
    }
}