package nov;

import aug.Codec;
import model.TreeNode;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class Solution1103 {
    int result;
    public int sumNumbers(TreeNode root) {
        result = 0;
        sumRecu(root, 0, true);
        return result;
    }

    private void sumRecu(TreeNode node, int currentVal, boolean isRoot) {
        int val = (currentVal * 10) + node.val;
        if (node.left == null && node.right == null) {
            result += val;
            return;
        }
        if (node.left != null) {
            sumRecu(node.left, val, false);
        }

        if (node.right != null) {
            sumRecu(node.right, val, false);
        }
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        Solution1103 s = new Solution1103();

        //System.out.println(s.sumNumbers(c.deserialize("1,2,3")));
        //System.out.println(s.sumNumbers(c.deserialize("4,9,0,5,1")));
        //System.out.println(s.sumNumbers(c.deserialize("4,9,null,5,1"))); //986
        System.out.println(s.sumNumbers(c.deserialize("4,9,0,null,1"))); //531

    }
}
