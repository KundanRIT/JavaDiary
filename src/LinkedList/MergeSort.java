package LinkedList;

public class MergeSort {
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
        System.out.println(linkedList);
        linkedList.head = mergesort(linkedList.head);
        System.out.println(linkedList);
    }

    private static LinkedNode<Integer> mid(LinkedNode<Integer> head) {
        LinkedNode<Integer> fast = head.next;
        LinkedNode<Integer> slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    private static LinkedNode<Integer> merge(LinkedNode<Integer> left, LinkedNode<Integer> right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        LinkedNode<Integer> merged = null;
        if (left.value < right.value) {
            merged = left;
            merged.next = merge(left.next, right);
        } else {
            merged = right;
            merged.next = merge(left, right.next);
        }
        return merged;
    }

    public static LinkedNode<Integer> mergesort(LinkedNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        LinkedNode<Integer> mid = mid(head);
        LinkedNode<Integer> midNext = mid.next;
        mid.next = null;
        return merge(mergesort(head), mergesort(midNext));
    }
}