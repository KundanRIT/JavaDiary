package Tree;

public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(new TreeNode(20), new TreeNode(30), 30);
        root.right = new TreeNode(new TreeNode(60), new TreeNode(80), 70);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        System.out.println(isBST(root));
    }

    private static boolean isBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null) {
            if (root.value <= root.left.value)
                return false;
        }
        if (root.right != null) {
            if (root.value >= root.right.value)
                return false;
        }
        return isBST(root.left) && isBST(root.right);
    }
}
