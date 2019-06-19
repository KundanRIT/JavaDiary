package LinkedList;

public class Cycle {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.prepend(20);
        linkedList.prepend(12);
        linkedList.prepend(34);
        linkedList.prepend(91);
        linkedList.prepend(87);
        linkedList.prepend(72);
        linkedList.prepend(45);
        linkedList.prepend(2);

        linkedList.head.next.next.next.next.next.next.next.next = linkedList.head;
        LinkedNode x = detectCycle(linkedList.head);

        int k = 0;
        for (LinkedNode cursor = linkedList.head; cursor != null && k < 20; cursor = cursor.next, k++) {
            System.out.print(cursor.value + " ");
        }
        System.out.println();
        if (x != null)
            removeCycle(linkedList.head, x);

        k = 0;
        for (LinkedNode cursor = linkedList.head; cursor != null && k < 20; cursor = cursor.next, k++) {
            System.out.print(cursor.value + " ");
        }
    }

    public static LinkedNode detectCycle(LinkedNode head) {

        LinkedNode slow = head;
        LinkedNode fast = head;
        int k=0;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return slow;
        }

        return null;
    }

    public static void removeCycle(LinkedNode head, LinkedNode pointer) {
        LinkedNode p1 = head;
        LinkedNode p2;
        while (p1 != null) {
            System.out.println(p1.value);
            p2 = pointer;

            while (p2.next != p1 && p2.next != pointer) {
                p2 = p2.next;
            }

            if (p2.next == p1) {
                p2.next = null;
                break;
            }

            p1 = p1.next;
        }
    }
}
