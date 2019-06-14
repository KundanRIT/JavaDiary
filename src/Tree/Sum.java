package Tree;

public class Sum {

    private static int sum = 0;

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inOrder();

        loadSum(tree.getRoot());

        tree.inOrder();
    }

    private static void loadSum(TreeNode root) {
        if (root != null) {
            loadSum(root.right);
            sum += root.value;
            root.value = sum;
            loadSum(root.left);
        }
    }
}
