package y2022.dec;

import java.util.*;

// https://leetcode.com/problems/sum-of-distances-in-tree/
public class Solution1222 {

    int[] distance;
    int[] count;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        List<Set<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[2]);
        }

        distance = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);


        dfs(0, -1, tree);
        dfs2(0, -1, tree, n);

        return distance;
    }

    public void dfs(int node, int parent, List<Set<Integer>> tree) {
        for (int child: tree.get(node))
            if (child != parent) {
                dfs(child, node, tree);
                count[node] += count[child];
                distance[node] += distance[child] + count[child];
            }
    }

    public void dfs2(int node, int parent, List<Set<Integer>> tree, int n) {
        for (int child: tree.get(node))
            if (child != parent) {
                distance[child] = distance[node] - count[child] + n - count[child];
                dfs2(child, node, tree, n);
            }
    }
}
