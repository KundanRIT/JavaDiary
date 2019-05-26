package LinkedList;

public class RemoveLastN {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        linkedlist.prepend(19);
        linkedlist.prepend(99);
//        linkedlist.prepend(27);
//        linkedlist.prepend(33);
//        linkedlist.prepend(81);
//        linkedlist.prepend(4);
        System.out.println(linkedlist);

        linkedlist.head = removeFromLastN(linkedlist.head, 2);

        System.out.println(linkedlist);
    }

    private static LinkedNode<Integer> removeFromLastN(LinkedNode<Integer> head, int n) {

        if (n == 0)
            return head;

        LinkedNode<Integer> toEnd = head;
        LinkedNode<Integer> toN = head;
        LinkedNode<Integer> prev = null;

        for (int i = 0; i < n; i++) {

            if (toEnd == null) {
                return null;
            }

            toEnd = toEnd.next;
        }

        while (toEnd != null) {
            toEnd = toEnd.next;
            prev = toN;
            toN = toN.next;
        }

        if (prev == null)
            return head.next;

        prev.next = toN.next;

        return head;
    }
}
