package y2023.mar;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-cycle-in-a-graph/
public class Solution0326 {

    int answer = -1;

    public int longestCycle(int[] edges) {
        // 가장 긴 사이클을 찾아라.

        int n = edges.length;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visit);
            }
        }
        return answer;
    }

    private void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visited[neighbor]) {
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist, visited);
        } else if (neighbor != -1 && dist.containsKey(neighbor)) {
            answer = Math.max(answer, dist.get(node) - dist.get(neighbor) + 1);
        }
    }
}
