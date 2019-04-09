package Tree;

public class Mirror {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(50);
        tree1.left = new TreeNode(new TreeNode(20), new TreeNode(40), 30);
        tree1.right = new TreeNode(new TreeNode(60), new TreeNode(80), 70);

        TreeNode tree2 = new TreeNode(50);
        tree2.left = new TreeNode(new TreeNode(80), new TreeNode(60), 70);
        tree2.right = new TreeNode(new TreeNode(40), new TreeNode(20), 30);

        new BST().inOrderUtil(tree1);
        System.out.println();
        new BST().inOrderUtil(tree2);
        System.out.println();
        System.out.println(checkMirror(tree1, tree2));
    }

    private static boolean checkMirror(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.value == root2.value
                && checkMirror(root1.left, root2.right)
                && checkMirror(root1.right, root2.left);
    }
}
