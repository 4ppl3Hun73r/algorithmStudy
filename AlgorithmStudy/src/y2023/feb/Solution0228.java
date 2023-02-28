package y2023.feb;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-subtrees/
public class Solution0228 {
    Map<String, Boolean> cacheMap = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        /*
        leaf -> 3 - null, null

         */

        // -> [3,Null,null] -> set / map -> 겹치면 중복이구나 -> result add
                 preorder(root);

        return result;
    }

    private String preorder(TreeNode node) {
        if (node == null) {
            // value.append("Null");
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(',');
        sb.append(preorder(node.left));
        sb.append(preorder(node.right));

        String subtree = sb.toString();
        /*
        cache 처리를 해서 나중에 중복를 할 수 있게
         */
        System.out.println(subtree);
        if (cacheMap.containsKey(subtree)) {
            if (!cacheMap.get(subtree)) {
                result.add(node);
                cacheMap.put(subtree, true);
            }
        } else {
            cacheMap.put(subtree, false);
        }

        return subtree;

    }

    public static void main(String[] args) throws Exception {
        Solution0228 s = new Solution0228();

        /*TreeNode root = new TreeNode(2,
                new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null));*/

        TreeNode root = new TreeNode(2,
                new TreeNode(2, new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(3), new TreeNode(3)));

        // [0,0,0,0,null,null,0,null,null,null,0]

        System.out.println(s.findDuplicateSubtrees(root));
    }

    /*
          0
       0    0
     0       0
               0
                0
     */
}
