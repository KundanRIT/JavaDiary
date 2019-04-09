package Tree;

public class BST {

    private TreeNode root;
    private int size = 0;

    private void inOrderUtil(TreeNode root) {
        if (root != null) {
            inOrderUtil(root.left);
            System.out.print(root.value + " ");
            inOrderUtil(root.right);
        }
    }

    public void inOrder() {
        System.out.println("Inorder is : Size("+size+")");
        inOrderUtil(root);
        System.out.println();
    }

    private TreeNode insertUtil(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            size++;
        } else {
            if (root.value < val) {
                root.right = insertUtil(root.right, val);
            } else if (root.value > val) {
                root.left = insertUtil(root.left, val);
            }
        }
        return root;
    }

    public void insert(int val) {
        root = insertUtil(root, val);
    }

    public int getSize() {
        return size;
    }

    public TreeNode getRoot() {
        return root;
    }
}
