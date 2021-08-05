package aug;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/
public class Solution0805 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        subSum(root, targetSum, new ArrayList<>());
        // 경로 전체 탐색
        return result;
        // bfs -> queue
        // dfs -> stack
    }

    private void subSum(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return ;
        }

        path.add(node.val);
        // 마지막 노드 인데,
        if (node.left == null && node.right == null && node.val == targetSum)  {
            result.add(new ArrayList<>(path));
        } else {
            subSum(node.left, targetSum - node.val, path);
            subSum(node.right, targetSum - node.val, path);
        }
        //
        path.remove(path.size() - 1);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
