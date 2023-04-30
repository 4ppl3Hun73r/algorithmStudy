package y2023.apr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
public class Solution0409 {
    public int largestPathValue(String colors, int[][] edges) {


        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = colors.length();
        for (int i = 0; i < len; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[][] count = new int[len][26];
        boolean[] visited = new boolean[len];
        boolean[] checkCycle = new boolean[len];

        int answer = 0;
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, dfs(i, colors, graph, count, visited, checkCycle));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;


    }

    private int dfs(int idx, String colors, Map<Integer, List<Integer>> graph, int[][] count, boolean[] visited, boolean[] checkCycle) {
        if (checkCycle[idx]) {
            return Integer.MAX_VALUE;
        }

        if (visited[idx]) {
            return count[idx][colors.charAt(idx) - 'a'];
        }

        visited[idx] = true;
        checkCycle[idx] = true;

        if (graph.containsKey(idx)) {
            for (int neighbor : graph.get(idx)) {
                if (dfs(neighbor, colors, graph, count, visited, checkCycle) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for (int i = 0; i < 26; i++) {
                    count[idx][i] = Math.max(count[idx][i], count[neighbor][i]);
                }
            }
        }

        count[idx][colors.charAt(idx) - 'a']++;
        checkCycle[idx] = false;

        return count[idx][colors.charAt(idx) - 'a'];
    }
}
