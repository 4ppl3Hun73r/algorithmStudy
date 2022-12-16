package y2022.dec;

import model.TreeNode;

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class Solution1209 {

    int v = 0;
    public int maxAncestorDiff(TreeNode root) {
        /*
        v = | 부모(들) - 자식 | 중 가장 큰 값
        음성이 오늘따라 자꾸 끊어지네요 (ㅠ)
        오 미디엄 바로 풀렸네요
        오...
        좋네요. 소리만 이상하지 ㅎㅎ
        그러게요 ㅋㅋㅋ
       ㅅ음성도 안되는데 마무리 하시죠 ㅋ ㅋㅋㅋ 넵 고생하셨습니다! b

         */

        dfs(root, root.val, root.val);

        return v;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }
        v = Math.max(v, Math.max(Math.abs(min - node.val), Math.abs(max - node.val)));

        dfs(node.left, Math.min(min, node.val), Math.max(max, node.val));
        dfs(node.right, Math.min(min, node.val), Math.max(max, node.val));
    }
}
