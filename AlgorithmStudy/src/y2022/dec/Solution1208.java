package y2022.dec;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/leaf-similar-trees/
public class Solution1208 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /*

         */
        List<Integer> leafList = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();

        dfs(root1, leafList);
        dfs(root2, leafList2);

        return leafList.equals(leafList2);
    }

    private void dfs(TreeNode node, List<Integer> leafList) {
        if (node == null) {
            return ;
        }

        if (node.left == null && node.right == null) {
            leafList.add(node.val);
        }

        dfs(node.left, leafList);
        dfs(node.right, leafList);
    }
}
