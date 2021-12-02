package problems;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {
    Map<Integer, List<Integer>> leavesMap;
    int maxDepth = 0;
    public int deepestLeavesSum(TreeNode root) {

        leavesMap = new HashMap<>();
        leaves(root, 0);

        int result = 0;
        for (int leave : leavesMap.get(maxDepth)) {
            result += leave;
        }

        return result;
    }

    private void leaves(TreeNode node, int depth) {
        if (node == null) {
            return ;
        }

        if (node.left == null && node.right == null) {
            if (!leavesMap.containsKey(depth)) {
                leavesMap.put(depth, new ArrayList<>());
            }
            leavesMap.get(depth).add(node.val);
            maxDepth = Math.max(maxDepth, depth);
        }

        leaves(node.left, depth + 1);
        leaves(node.right, depth + 1);
    }
}
