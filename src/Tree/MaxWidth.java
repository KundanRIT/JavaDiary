package Tree;

import java.util.LinkedList;

public class MaxWidth {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
//        tree.insert(60);
        tree.insert(80);
        tree.insert(75);
        tree.insert(85);
        tree.inOrder();
        System.out.println("Maximum Width - " + maxWidthOfTree(tree.getRoot()));
    }

    public static int maxWidthOfTree(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);
        int max = 1;
        while ( !queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.print(pop.value + " ");
            if (pop.left != null)
                queue1.addLast(pop.left);
            if (pop.right != null)
                queue1.addLast(pop.right);
            if (queue.isEmpty()) {
                System.out.print("| ");
                queue.addAll(queue1);
                if (max < queue1.size()) {
                    max = queue1.size();
                }
                queue1 = new LinkedList<>();
            }
        }
        return max;
    }
}
