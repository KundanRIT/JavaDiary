package LinkedList;

public class KReverse {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        linkedlist.prepend(1);
        linkedlist.prepend(2);
        linkedlist.prepend(3);
        linkedlist.prepend(4);
        linkedlist.prepend(5);
        linkedlist.prepend(6);
        linkedlist.prepend(7);
        linkedlist.prepend(8);
        System.out.println(linkedlist);
        linkedlist.head = new KReverse().reverseKGroup(linkedlist.head, 3);
        System.out.println(linkedlist);
    }

    public LinkedNode reverseKGroup(LinkedNode head, int k) {
        LinkedNode cursor = head;
        LinkedNode prev = null;
        LinkedNode next = null;

        int count = 0;
        while (count < k && cursor != null) {
            next = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
