package y2021.sep;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3961/
public class Solution0903 {

    public List<TreeNode> generateTrees(int n) {
        // 1 <= n <= 8
        // [1, 2, 3, 4, 5]
        // [1, [2,3,4,5]]
        // getTreeList(1, tree(2,3,4)) => tree node list;
        // getTreeList(2, tree(1,3,4)) => tree node list;
        // tree(1, 2) -> 1, 2 / 2, 1
        List<TreeNode> treeNodeList = tree(1, n);
        return treeNodeList;
    }

    private List<TreeNode> tree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        for (int i = start; i <= end; i++) {
            // 1,2,3,4,5,6
            // 1
           List<TreeNode> left = tree(start, i - 1);
           List<TreeNode> right = tree(i + 1, end);

           for (TreeNode l : left) {
               for (TreeNode r : right) {
                   TreeNode root = new TreeNode(i);
                   root.left = l;
                   root.right = r;
                   list.add(root);
               }
           }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution0903 s = new Solution0903();
        System.out.println(s.generateTrees(3));
    }

    // [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
    // [[1,null,2,null,3],[2,1,3]]

}
