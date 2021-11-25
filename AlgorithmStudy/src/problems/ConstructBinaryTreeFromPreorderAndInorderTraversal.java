package problems;

import model.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        /*
        nov.Solution1121.buildTree
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
         */

        int preorderLen = preorder.length;
        int inorderIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        for (int i = 1; i < preorderLen; i++) {
            // left가 right인지 확인할려면 inorder 에서 확인?
            // stack 은 -> root -> (right|root) -> (right|root) 이런식으로 들어가게 됨 (postorder에 따라)
            // left 연결시점을 찾아야함.
            // inorder의 끝과 inorder가 같으면 중복을 제거해 나가면서 root 지점을 찾음 (left를 연결 가능한)
            while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                prev = stack.pop(); // root가 됨.
                inorderIndex ++;
            }

            TreeNode node = new TreeNode(preorder[i]);
            if (prev != null) {
                prev.right = node;
            } else if (!stack.isEmpty()){
                stack.peek().left = node;
            }
            stack.push(node);
            prev = null;
        }

        return root;
    }
}
