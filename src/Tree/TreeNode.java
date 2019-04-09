package Tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(int value) {
        this(null, null, value);
    }
}
