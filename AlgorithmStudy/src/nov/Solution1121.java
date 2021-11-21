package nov;

import model.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class Solution1121 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
                  3
                 / \
                9   20
                   /  \
                  15   7
        Input:
          inorder = [9,3,15,20,7],
        postorder = [9,15,7,20,3]
        Output: [3,9,20,null,null,15,7]

        (a) Inorder   (Left, Root, Right) : 4 2 5 1 3
        (c) Postorder (Left, Right, Root) : 4 5 2 3 1
         */
        int postorderLen = postorder.length;
        int inorderLen = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[postorderLen - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        for (int i = postorderLen - 2; i >= 0; i--) {
            // left가 right인지 확인할려면 inorder 에서 확인?
            // stack 은 -> root -> (right|root) -> (right|root) 이런식으로 들어가게 됨 (postorder에 따라)
            // left 연결시점을 찾아야함.
            // inorder의 끝과 inorder가 같으면 중복을 제거해 나가면서 root 지점을 찾음 (left를 연결 가능한)
            while (!stack.isEmpty() && stack.peek().val == inorder[inorderLen]) {
                prev = stack.pop(); // root가 됨.
                inorderLen --;
            }

            TreeNode node = new TreeNode(postorder[i]);
            if (prev != null) { // root 후보가 있으면 현재 노드는 left로 연결
                prev.left = node;
            } else if (!stack.isEmpty()){
                // 스택에는 root 역할을 들어가 있어야 함
                // 스택의 root 다음은 right이므로 연결
                stack.peek().right = node;
            }
            stack.push(node);
            prev = null;
        }

        return root;
    }
}
