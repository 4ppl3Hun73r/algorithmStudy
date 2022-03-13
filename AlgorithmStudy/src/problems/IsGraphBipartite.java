package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        /*

        그래프를 2그룹으로 나누는 문제

        좀 헷갈리기는 하는데 그래프에 대해서 그룹핑?

         */

        int n = graph.length;
        int[] group = new int[n];

        Map<Integer, Set<Integer>> connectMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            connectMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < graph.length; i++) {
            Set<Integer> set = connectMap.get(i);
            for (int node : graph[i]) {
                set.add(node);
            }
        }

        for (int i = 0; i < n; i++) {
            if (group[i] == 0 && !dfs(connectMap, group, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> connectMap, int[] group, int n, int g) {
        group[n] = g;

        Set<Integer> connectSet = connectMap.get(n);

        for (Integer idx : connectSet) {
            if (group[idx] == g) { // 같은 그룹에 있으면 안됨
                return false;
            }
            if (group[idx] == 0 && !dfs(connectMap, group, idx, -g)) { // 아직 결정 안되었으면 다른 그룹으로 매핑해서 탐색
                return false;
            }
        }

        return true;
    }
}
