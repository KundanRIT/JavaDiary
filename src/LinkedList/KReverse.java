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
        System.out.println(linkedlist);
        linkedlist.head = new KReverse().reverseKGroup(linkedlist.head, 2);
        System.out.println(linkedlist);
    }

    public LinkedNode reverseKGroup(LinkedNode head, int k) {
        LinkedNode cursor = head;
        LinkedNode prev = null;
        int move = 1;

        LinkedNode go = head;

        while (cursor != null) {
            if (move == k ){
                LinkedNode temp = cursor.next;
//                cursor.next = ;
                prev = cursor;
                cursor = temp;

                move = 1;
            } else {
                cursor = cursor.next;
                move++;
            }
        }
        return head;
    }
}
