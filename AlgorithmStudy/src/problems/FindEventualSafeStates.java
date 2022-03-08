package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        /*
         나가는 경로가 없을때 terminalNode
         모든 경로를 추적했을때 마지막이 terminalNode이면 safeNode

         모든 safeNode를 반환 (순서대로 정렬하여서)
         */
        int nodeCnt = graph.length;

        Set<Integer> safeNode = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nodeCnt; i++) {
            if (!safeNode.contains(i) || !visited.contains(i)) {
                dfs(i, graph, visited, safeNode);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nodeCnt; i++) {
            if (safeNode.contains(i)) {
                ans.add(i);
            }
        }

       return ans;
    }

    private boolean dfs(int node, int[][] graph, Set<Integer> visited, Set<Integer> safeNode) {
        if (visited.contains(node)) {
            return safeNode.contains(node);
        }
        visited.add(node);

        int[] nextNodes = graph[node];
        boolean isSafe = true;
        for (int i = 0; i < nextNodes.length; i++) {
            int nextNode = nextNodes[i];
            if (safeNode.contains(nextNode)) {
                continue;
            }
            if (nextNode == node) {
                isSafe = false;
            } else {
                isSafe = dfs(nextNode, graph, visited, safeNode);
            }
            if (!isSafe) {
                break;
            }
        }

        if (isSafe) {
            safeNode.add(node);
        }

        return isSafe;
    }

    public static void main(String[] args) throws Exception {
        FindEventualSafeStates f = new FindEventualSafeStates();

        /*System.out.println(f.eventualSafeNodes(new int[][]{
                {1,2},{2,3},{5},{0},{5},{},{}
        }));*/

        System.out.println(f.eventualSafeNodes(new int[][]{
                {1,2,3,4},{1,2},{3,4},{0,4},{}
        }));
    }
}
