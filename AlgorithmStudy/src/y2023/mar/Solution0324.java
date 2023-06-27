package y2023.mar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class Solution0324 {
    public int minReorder(int n, int[][] connections) {
        /*
        방향을 가진 그래프
        모든 그래프의 방향을 0 번째 노드로 향하게 할 수 있는 최소한의 수정 횟수 == n
         */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] connection : connections) {
            // 0 -> 1 로 갈 수 있다.
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(-connection[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0);
    }

    private int dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int n) {
        int changeCnt = 0;
        visited[n] = true;

        // 연결된 그래프 모두 탐색
        for (Integer next : graph.get(n)) {
            int absNext = Math.abs(next);

            if (!visited[absNext]) {
                changeCnt += dfs(graph, visited, absNext);
                if (next > 0) {
                    changeCnt ++;
                }
            }
        }

        return changeCnt;
    }
}
