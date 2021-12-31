package dec;

import model.TreeNode;

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class Solution1231 {
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return diff;
    }

    private void dfs(TreeNode node, int min, int max) {
        // 8 - 1 => 7
        // 0 -> min 극단적 양측 값만 보면 된다.
        if (node != null) {
            diff = Math.max(diff,
                Math.max(
                    Math.abs(min - node.val),
                    Math.abs(max - node.val))
            );
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);

            dfs(node.left, min, max);
            dfs(node.right, min, max);
        }
    }
}
