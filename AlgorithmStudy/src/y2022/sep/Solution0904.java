package y2022.sep;

import model.TreeNode;

import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class Solution0904 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        dfs(root, map, 0, 0);

        List<List<Integer>> ans = new ArrayList<>(map.size());

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        Comparator<int[]> comparator = (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        };


        for (int i = 0; i < keyList.size(); i++) {
            List<int[]> t = map.get(keyList.get(i));
            t.sort(comparator);
            List<Integer> sub = new ArrayList<>();
            for (int[] ints : t) {
                sub.add(ints[0]);
            }
            ans.add(sub);
        }

        return ans;
    }

    private void dfs(TreeNode node, Map<Integer, List<int[]>> map, int row, int col) {
        if (node == null) {
            return ;
        }

        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }

        map.get(col).add(new int[]{node.val, row});

        dfs(node.left, map, row + 1, col - 1);
        dfs(node.right, map, row + 1, col + 1);
    }
}
