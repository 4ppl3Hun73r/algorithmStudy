package y2021.july;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution0720 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int rootVal = root.val;

        // p < a < q;
        // q < a < p;
        // l = min(p,q) < h = max(p,q)
        //
        //

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        TreeNode node = root;
        while (node != null) {
            int parentVal = node.val;

            if (min > parentVal && max > parentVal) {
                node = node.right;
            } else if (min < parentVal && max < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }

        return null;
    }
    public boolean contains(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        boolean self = node.val == value;
        if (!self) {
            return contains(node.left, value) || contains(node.right, value);
        }
        return true;
    }
}