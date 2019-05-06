package Tree;

import java.util.ArrayList;
import java.util.List;

public class Ancestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> ans1 = ancestors(root, 5, new ArrayList<>());
        System.out.println(ans1);
        List<Integer> ans2 = ancestors(root, 5, new ArrayList<>());
        System.out.println(ans2);
        if (ans1 == null || ans2 == null)
            System.out.println("null");
        else {
            int lca = Integer.MIN_VALUE;
            for (int i=0, j=0; i<ans1.size() && j<ans2.size(); i++,j++) {
                if (! ans1.get(i).equals(ans2.get(j))) {
                    break;
                } else {
                    lca = ans1.get(i);
                }
            }
            System.out.println("Lowest Common Ancestor - " + lca);
        }
    }

    private static List<Integer> ancestors(TreeNode root, int val, List<Integer> ans) {
        if (root == null)
            return null;
        ans.add(root.value);
        if (root.value == val)
            return ans;
        else {
            List<Integer> x = ancestors(root.left, val, ans);
            if (x != null)
                return x;
            else {
                List<Integer> y =  ancestors(root.right, val, ans);
                if (y != null)
                    return y;
                else {
                    ans.remove((Integer) root.value);
                    return null;
                }
            }
        }
    }
}
