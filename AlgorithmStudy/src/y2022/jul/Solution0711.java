package y2022.jul;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class Solution0711 {

    public List<Integer> rightSideView(TreeNode root) {
        /*
        트리를 오른쪽에서 봤을때 모습을 depth 순서대로 반환

        BFS -> 다 봐야 하고
            1      <-
           2  3    <-
         4      5  <-
           6       <-
           -> 1, 3, 5, 6

           q = [1]
             = [2,3]
             = [4,5]
             = [6]
        DFS -> [1,3,5,6] -> 다봐야해요.
         */
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int size = queue.size();

            // depth
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(node.val);
        }

        return ans;

    }
}
