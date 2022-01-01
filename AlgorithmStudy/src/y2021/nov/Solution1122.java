package y2021.nov;

import model.TreeNode;
import y2021.aug.Codec;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class Solution1122 {
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
            BST 에서 특정 노드 지우기
         */

        // 탐색
        if (root == null) {
            return null;
        }

        int val = root.val;
        if (val == key) {
            // 자식 변경
            return changeNode(root.left, root.right);
            // 또 다른 방법으로 min or max를 찾아서 해당 노드로 교체
            // value를 교체 해당 노드를 제거하면 되니까.

        }
        if (val < key) {
            root.left = deleteNode(root.left, key);
        }
        if (val > key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode changeNode(TreeNode left, TreeNode right) {

        if (left != null && right != null) {
            // node2.left = node1
            // node2.left 가 값이 있으면????
            right.left = changeNode(left, right.left);
            return right;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        Solution1122 s = new Solution1122();
        Codec c = new Codec();
        // 5,4,6,2,null,null,7
        System.out.println(c.serialize(s.deleteNode(c.deserialize("5,3,6,2,4,null,7"), 3)));
    }

}
