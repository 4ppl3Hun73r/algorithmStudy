package y2022.may;

import model.TreeNode;

// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class Solution0517 {
    TreeNode ans = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        /*
        binaryTree
        original <-> cloned

        original의 target 에 대응하는  cloned 의 node를 반환
         */

        dfs(original, cloned, target);

        return ans;
    }

    private void dfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (ans != null || original == null) {
            return;
        }

        if (original == target) {
            ans = cloned;
            return ;
        }
        dfs(original.left, cloned.left, target);
        dfs(original.right, cloned.right, target);
    }
}
