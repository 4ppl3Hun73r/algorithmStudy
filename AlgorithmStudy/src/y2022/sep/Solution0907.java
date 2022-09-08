package y2022.sep;

import model.TreeNode;

// https://leetcode.com/problems/construct-string-from-binary-tree/
public class Solution0907 {
    public String tree2str(TreeNode root) {
        /*
             1
            2 3
           4
        "1(2(4))(3)"

             1
           2   3
            4
        "1(2()(4))(3)"
         */
        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);
            if (node.left == null && node.right == null) {
                return ;
            }
            if (node.right == null) {
                sb.append('(');
                preorder(node.left, sb);
                sb.append(')');
            } else {
                sb.append('(');
                preorder(node.left, sb);
                sb.append(')');
                sb.append('(');
                preorder(node.right, sb);
                sb.append(')');
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution0907 s = new Solution0907();

        ///System.out.println(s.tree2str());
    }
}
