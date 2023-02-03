package y2023.jan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
public class Solution0113 {

    int resultLongestPath = 1;

    public int longestPath(int[] parent, String s) {

        int n = s.length();
        List<Set<Integer>> tree = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }

        int root = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                root = i;
                continue;
            }
            tree.get(parent[i]).add(i);
        }

        dfs(root, tree, s.toCharArray());

        return resultLongestPath;

    }

    private int dfs(int root, List<Set<Integer>> tree, char[] chars) {
        if (tree.get(root).size() == 0) {
            return 1;
        }

        int ch = chars[root];

        int longestPath = 0;
        int longestPath2 = 0;
        for (Integer child : tree.get(root)) {
            // 일단 dfs 는 한번은 태워야함.
            int subPath = dfs(child, tree, chars);

            if (chars[child] == ch) {
                continue;
            }
            if (subPath > longestPath) {
                longestPath2 = longestPath;
                longestPath = subPath;
            } else if (subPath > longestPath2) {
                longestPath2 = subPath;
            }
        }

        resultLongestPath = Math.max(resultLongestPath, longestPath + longestPath2 + 1);

        return longestPath + 1;
    }
}
