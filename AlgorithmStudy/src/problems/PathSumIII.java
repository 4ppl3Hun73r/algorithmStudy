package problems;

import aug.Codec;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return find(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int find(TreeNode node, int targetSum) {
        if (node == null) return 0;

        int result = 0;
        if (node.val == targetSum) {
            result ++;
        }

        return result + find(node.left, targetSum - node.val) + find(node.right, targetSum - node.val);
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        PathSumIII p  = new PathSumIII();
        //System.out.println(p.pathSum(c.deserialize("10,5,-3,3,2,null,11,3,-2,null,1"), 8));
        // 3
        //System.out.println(p.pathSum(c.deserialize("1,-2,-3,1,3,-2,null,-1"), -1));
        System.out.println(p.pathSum(c.deserialize("1,-2,-3,1,3,-2,null,-1"), -2));
    }
}
