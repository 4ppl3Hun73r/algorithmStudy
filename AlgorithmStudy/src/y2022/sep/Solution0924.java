package y2022.sep;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class Solution0924 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        findSum(root, targetSum, new ArrayList<Integer>());

        return result;
    }

    private void findSum(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        // 마지막 노드는 무조건 leaf 여야함
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            findSum(node.left, targetSum - node.val, path);
            findSum(node.right, targetSum - node.val, path);
        }
        path.remove(path.size() - 1);
    }
}
