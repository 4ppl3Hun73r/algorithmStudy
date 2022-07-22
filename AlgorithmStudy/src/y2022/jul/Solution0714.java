package y2022.jul;

import model.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Solution0714 {

    Map<Integer, Integer> inorderValIdxMap = new HashMap<>();
    int preorderIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        preorder 탐색 배열과
        inorder 탐색 배열을 가지고 원본 트리를 복구 하기
                  3
                 / \
                9   20
                   /  \
                  15   7
        Input:
        preorder  = [3,9,20,15,7]
          inorder = [9,3,15,20,7],
        Output: [3,9,20,null,null,15,7]
        (a) Inorder   (Left, Root, Right)
        (b) Preorder  (Root, Left, Right)
        (c) Postorder (Left, Right, Root)
                 3
                / \
               9    20
              / \   / \
             2   8 15 7
            /
           1
          /
         0
        preorder  = [3,9,2,1,0,8,20,15,7]
          inorder = [0,1,2,9,8,3,15,20,7]
                     ^         |       ^
                     ^     | ^
                     ^   | N
                     ^ | N
                     |
                             |
                                     | ^
                                  ^
                                  |
                                       |
         */
        for (int i = 0; i < inorder.length; i++) {
            inorderValIdxMap.put(inorder[i], i);
        }

        preorderIdx = 0;
        return dac(preorder, 0, preorder.length - 1);
    }

    private TreeNode dac(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preorderIdx];
        preorderIdx++;
        TreeNode node = new TreeNode(rootVal);

        node.left = dac(preorder, left, inorderValIdxMap.get(rootVal) - 1);
        node.right = dac(preorder, inorderValIdxMap.get(rootVal) + 1, right);

        return node;
    }

    public TreeNode buildTreeLoop(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderValIdxMap.put(inorder[i], i);
        }

        TreeNode root = null;
        TreeNode curr;

        int leftEnd = 0;
        int rightStart = 0;

        /*
        preorder  = [3,9,2,1,0,8,20,15,7]
        inorder = [0,1,2,9,8,3,15,20,7]
        */


        while (leftEnd < rightStart) {
            int rootVal = preorder[preorderIdx];
            TreeNode node = new TreeNode(rootVal);

            if (root == null) {
                root = node;
            }

            int inorderRootIdx = inorderValIdxMap.get(rootVal);

            leftEnd = inorderRootIdx - 1;
            rightStart = inorderRootIdx + 1;


            preorderIdx++;
        }


        return dac(preorder, 0, preorder.length - 1);
    }


    public TreeNode buildTreeIterativeSolution(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode top = stack.peek();
            int indexTop = inorderMap.get(top.val);
            int indexVal = inorderMap.get(preorder[i]);

            TreeNode node = new TreeNode(preorder[i]);

            if (indexVal < indexTop) {
                top.left = node;
            } else {
                while (indexVal > indexTop) {
                    top = stack.pop();
                    indexTop = stack.isEmpty() ? Integer.MAX_VALUE : inorderMap.get(stack.peek().val);
                }
                top.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
