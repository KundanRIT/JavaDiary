package Tree;

public class MaxPath {

    static int maxsum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(new TreeNode(2), new TreeNode(3), 4);
        root.right = new TreeNode(new TreeNode(5), new TreeNode(6), 7);

        /**
         *       1
         *   4       7
         * 2   3   5   6
         */

        new BST().inOrderUtil(root);

        System.out.println();

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        /**
         * l + node + r
         * l + node
         * node + r
         * node
         */
        deep(root);

        return maxsum;
    }

    public static int deep(TreeNode root) {

        if (root == null)
            return 0;

        int l = deep(root.left);
        int r = deep(root.right);

        int maxSingle = Math.max(Math.max(l, r) + root.value, root.value);
        maxsum = Math.max(Math.max(maxSingle, l + r + root.value), maxsum);

        return maxSingle;
    }
}
