package problems;

import model.TreeNode;

// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode clonedTarget = getTargetCopy(original.left, cloned.left, target);
        if (clonedTarget == null) {
            clonedTarget = getTargetCopy(original.right, cloned.right, target);
        }

        return clonedTarget;

    }
}
