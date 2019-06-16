package Tree;

import java.util.ArrayList;
import java.util.List;

public class MaxDiffAns {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);


        System.out.println("----"+maxAncestorDiff(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffUtil(root, new ArrayList<>(), 0);
    }

    public static int maxAncestorDiffUtil(TreeNode root, List<Integer> anscesors, int maxDiff) {
        if (root == null)
            return maxDiff;

        for (int anscestor: anscesors) {
            int absdiff = Math.abs(root.value - anscestor);
            if (absdiff > maxDiff) {
                System.out.println(root.value + " " + anscestor);
                maxDiff = absdiff;
            }
        }

        anscesors.add(root.value);

        return Math.max(maxAncestorDiffUtil(root.left, new ArrayList<>(anscesors), maxDiff),
                maxAncestorDiffUtil(root.right, new ArrayList<>(anscesors), maxDiff));
    }
}
