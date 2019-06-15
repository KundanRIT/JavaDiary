package Tree;

import java.util.Stack;

public class NTree {
    public static void main(String[] args) {
        NTreeNode root = new NTreeNode(1);

        root.children = new NTreeNode(2);
        root.children.children = new NTreeNode(21);
        root.children.children.next = new NTreeNode(22);
        root.children.children.next.next = new NTreeNode(23);

        root.children.next = new NTreeNode(3);
        root.children.next.children = new NTreeNode(31);
        root.children.next.children.next = new NTreeNode(32);
        root.children.next.children.next.next = new NTreeNode(33);

        root.children.next.next = new NTreeNode(4);
        root.children.next.next.children = new NTreeNode(41);
        root.children.next.next.children.next = new NTreeNode(42);
        root.children.next.next.children.next.next = new NTreeNode(43);

        root.children.next.next.next = new NTreeNode(5);
        root.children.next.next.next.children = new NTreeNode(51);
        root.children.next.next.next.children.next = new NTreeNode(52);
        root.children.next.next.next.children.next.next = new NTreeNode(53);

//        root.children.children.next.next.next = root.children.next.children;
//        root.children.next.children.next.next.next = root.children.next.next.children;
//        root.children.next.next.children.next.next.next = root.children.next.next.next.children;

        NTreeNode cursor = root.children;
        int leafsum = 0;
        Stack<NTreeNode> nextLevels = new Stack<>();

        while (cursor != null) {
            if (cursor.children == null) {
                leafsum += cursor.value;
            } else {
                nextLevels.push(cursor.children);
            }

            if (cursor.next == null) {
                cursor = nextLevels.empty() ? null : nextLevels.pop();
            } else {
                cursor = cursor.next;
            }
        }

        System.out.println(leafsum);
    }
}
