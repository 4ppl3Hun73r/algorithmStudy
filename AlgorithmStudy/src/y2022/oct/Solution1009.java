package y2022.oct;


import model.TreeNode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class Solution1009 {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> findValSet = new HashSet<>();

        return find(root, k, findValSet);
    }

    private boolean find(TreeNode node, int k, Set<Integer> findValSet) {
        if (node == null) {
            return false;
        }
        int val = node.val;
        int diff = k - val;
        if (findValSet.contains(diff)) {
            return true;
        }
        findValSet.add(val);

        return find(node.left, k, findValSet) || find(node.right, k, findValSet);
    }
}
