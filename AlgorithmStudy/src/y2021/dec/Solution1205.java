package y2021.dec;

import model.TreeNode;

// https://leetcode.com/problems/house-robber-iii/
public class Solution1205 {
    public int rob(TreeNode root) {

        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2]; // 0, 털었을때 . 1, 안털었을때
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] dp = new int[2];
        // 왼쪽에서 털었을때
        // 오른쪽 털었을때

        dp[0] = node.val + left[1] + right[1]; // 털고, 아래 자식들중 안털었을때를 더함
        dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 안털면 자식 결과에서 큰것들 더함

        return dp;
    }
}
