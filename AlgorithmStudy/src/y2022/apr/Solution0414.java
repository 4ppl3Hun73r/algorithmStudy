package y2022.apr;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class Solution0414 {
    public TreeNode searchBST(TreeNode root, int val) {
        /*
        BST 에서 val을 찾기
         */
        if (root == null) {
            return root;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);
    }

    public TreeNode searchBSDT(TreeNode root, int val) {
        return searchBFS(root, val);
    }
    //통과  bbbbb
    private TreeNode searchBFS(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                continue;
            }

            if (currentNode.val ==  val) {
                return currentNode;
            }

            if (currentNode.val < val) {
                queue.add(currentNode.right);
            } else {
                queue.add(currentNode.left);
            }
        }

        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        /*
        BST 에서 val을 찾기
         */
        if (root == null) {
            return root;
        }

        if (root.val < val) {
            return searchBST2(root.right, val);
        } else if (root.val > val) {
            return searchBST2(root.left, val);
        } else {
            return root;
        }
    }

    public TreeNode searchBST3(TreeNode root, int val) {
        /*
        BST 에서 val을 찾기
         */
        if (root == null) {
            return root;
        }

        TreeNode current = root;

        while (current != null) {
            if (current.val < val) {
                current = current.right;
            } else if (current.val > val) {
                current = current.left;
            } else {
                return current;
            }
        }

        return current;
    }
}
