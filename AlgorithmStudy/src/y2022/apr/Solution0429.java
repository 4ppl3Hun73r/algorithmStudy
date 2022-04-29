package y2022.apr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/is-graph-bipartite/
public class Solution0429 {
    public boolean isBipartite(int[][] graph) {
        /*
         그래프를 두개의 그룹으로 나눌수 있나요?
         0 - 1
         |   |
         2 - 3  4 - 5

         0,1,2,3,4,5
        A 0
        B 1, 2
        A 3

         0,1,2,3,4,5

         0
         1,2,3,4,5,1,2

         0 - 1, 2
         1 - 0, 3
         2 - 0, 3
         3 - 1, 2, 4
         4 - 3, 5
         5 - 4



         dequeue : 4, 5
         A - 0
         B - 1, 2
         0 - 1
         | \ |
         2 - 3

         A - 0, {3}
         B - 1, 2, 3
         */
        // A - set
        // B - set
        // GrayA, GrayB - set

        Map<Integer, Set<Integer>> nodeSetMap = new HashMap<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            nodeSetMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            for (int no : graph[i]) {
                nodeSetMap.get(i).add(no);
            }
        }
        // [[1],[0,3],[3],[1,2]]
        //i  0    1    2     3
        //  0 - 1
        //  1 - 0, 3
        //  2 - 3
        //  3 - 1, 2
        // 0 -1  0->1, 1 -> 0 , 0
        // |
        // 2

        int[] groups = new int[n]; // 0 -> gray / 1 -> groupA / -1 -> groupB
        for (int i = 0; i < n; i++) {
            if (groups[i] == 0) {
                if (!dfs(nodeSetMap, groups, 1, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int[] groups, int group, int node) {
        groups[node] = group;

        for (Integer nextNode : map.get(node)) {
            if (groups[nextNode] == group) {
                return false;
            }
            if (groups[nextNode] == 0 && !dfs(map, groups, -group, nextNode)) {
                return false;
            }
        }

        return true;
    }
}
