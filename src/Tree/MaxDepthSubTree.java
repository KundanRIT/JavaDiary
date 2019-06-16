package Tree;

public class MaxDepthSubTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        int depth = depth(root);

        System.out.println(findDepth(root, 1, depth));
    }

    private static int depth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }

    private static int findDepth(TreeNode root, int currentDepth, int maxDepth) {
        if (root == null)
            return -1;

        if (currentDepth == maxDepth) {
            return root.value;
        }

        int inLeft = findDepth(root.left, currentDepth+1, maxDepth);
        int inRight = findDepth(root.right, currentDepth+1, maxDepth);

        if (inLeft != -1 && inRight != -1)
            return root.value;
        else
            return inLeft == -1 ? inRight : inLeft;
    }
}
