package y2022.sep;

import model.TreeNode;
import y2021.aug.Codec;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class Solution0901 {

    int cnt = 0;

    public int goodNodes(TreeNode root) {
        /*
        자기까지 도달하는 Path 에서 자기보다 큰게 없으면 goodnode
         */
        dfs(root, Integer.MIN_VALUE);

        return cnt;
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            cnt++;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);
    }

    public static void main(String[] args) throws Exception {
        Solution0901 s = new Solution0901();
        Codec c = new Codec();

        System.out.println(s.goodNodes(c.deserialize("3,1,4,3,null,1,5")));
    }
}
