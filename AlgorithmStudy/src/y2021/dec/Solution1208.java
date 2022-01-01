package y2021.dec;

import model.TreeNode;

// https://leetcode.com/problems/binary-tree-tilt/
public class Solution1208 {

    /*
                    4
                 /     \
                2       9
              /   \       \
            3      5       7


                    4
                 /     \
                2 <-(3/5)      9
              /   \       \
             3(0)  5(0)       7
     */

    int result;
    public int findTilt(TreeNode root) {
        // 1322 ->
        // 4문제를 다 푼사람이 100명도 안되요
        // 3문제를 풀면 상위권인데, 빨리풀어야 된다.
        // 47분이 걸렸는데 제출을 2번 실패했어요. 실패시마다 +5분
        // easy / mid / mid / hard
        //
        result = 0;
        dfs(root);
        return result;
    }

    /**
     *
     * @param node
     * @return 하의 노드의 sum
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        int tmp = node.val;

        node.val = Math.abs(leftSum - rightSum);
        result += node.val;

        return tmp + leftSum + rightSum;
    }
}
