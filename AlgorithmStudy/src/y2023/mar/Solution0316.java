package y2023.mar;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class Solution0316 {
    int postorderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {


        /*
                3
             /    \
            9     20
           / \   /  \
          11 10  15   7

                3
             /    \
            10    20
            /    /  \
            9   15   7
           /
          11


        Inorder   : 9,3,15,20,7
        Postorder : 9,15,7,20,3

                    Left <- R -> Right
        InOrder   : 11 9 10 3 15 20 7
        PostOrder : 11 10 9 15 7 20 3

        PostOrder의 끝 = root
        Inorder에서 왼쪽과 오른쪽은 루트기준으로 알 수 있다.

        Inorder   => (Left, Root, Right)
        PostOrder => (Left, Right, Root)
         */

        Map<Integer, Integer> inorderValueIdxMap = new HashMap<>();
        Map<Integer, Integer> postOrderValueIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderValueIdxMap.put(inorder[i], i);
            postOrderValueIdxMap.put(postorder[i], i);
        }

        postorderIdx = postorder.length - 1;
        return find(0, postorder.length - 1, inorderValueIdxMap, postorder);
    }

    private TreeNode find(int startIdx, int endIdx, Map<Integer, Integer> inorderValueIdxMap, int[] postorder) {
        if (startIdx > endIdx || postorderIdx < 0) {
            return null;
        }
        // 9  3 15 20 7
        // 9 15 7 20       3

        // 9    15 <   20   >  7
        /*

        Inorder   : 9,      3,    15,20,7
        Postorder : 9,     15,7,20, 3

        postOrder index 중에서 전 root와
         */

        TreeNode root = new TreeNode(postorder[postorderIdx--]);
        int center = inorderValueIdxMap.get(root.val);
        root.right = find(center + 1, endIdx, inorderValueIdxMap, postorder);
        root.left = find(startIdx, center - 1, inorderValueIdxMap, postorder);

        return root;
    }

    public static void main(String[] args) throws Exception {
        Solution0316 s = new Solution0316();

        System.out.println(s.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }

}

