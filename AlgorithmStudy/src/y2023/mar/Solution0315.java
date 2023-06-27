package y2023.mar;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
public class Solution0315 {
    public boolean isCompleteTree(TreeNode root) {
        // 컴플리트 트리인지 확인
        // 모든 레벨 + 1이어야하고
        // 왼쪽부터 채워야함

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean missingNode = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                missingNode = true;
            } else {
                // 내 앞에 null 이 있으면 Complete가 아님
                if (missingNode) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}
