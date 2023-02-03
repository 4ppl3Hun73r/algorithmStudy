package y2023.jan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
public class Solution0112 {
    int[] result;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        /*
            트리에서 자기의 라벨과 동일한 자식이 얼마나 있는지 count
         */
        result = new int[n];

        List<Set<Integer>> tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0, 0, tree, labels.toCharArray());

        return result;
    }

    private int[] dfs(int n, int parent, List<Set<Integer>> tree, char[] labels) {
        /*
        반환 값이.
        int[] labels = new int[26];
         */
        // 자식없는 노드에서 count 배열을 만드는 걸로.
        int[] count = new int[26];
        count[labels[n] - 'a']++;

        for (Integer child : tree.get(n)) {
            if (child == parent) {
                continue;
            }
            int[] subCount = dfs(child, n, tree, labels);
            for (int i = 0; i < 26; i++) {
                count[i] += subCount[i];
            }
        }

        result[n] = count[labels[n] - 'a'];
        return count;
    }

}