package y2022.may;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/
public class Solution0514 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // times[i] = (ui, vi, wi)
        // u -> v
        // k node에서 시작해서 n개의 노드에 신호가 도달할때까지의 시간, 도달 못하면 -1

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new int[]{v, w});
        }

        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visited[k] = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int duration = visited[u];
            if (!graph.containsKey(u)) {
                continue;
            }
            List<int[]> next = graph.get(u);
            for (int[] nodes : next) {
                int v = nodes[0];
                int w = nodes[1];

                int nextDuration = duration + w;
                if (visited[v] > nextDuration) {
                    visited[v] = nextDuration;
                    queue.offer(v);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, visited[i]);
        }

        if (max == Integer.MAX_VALUE) {
            return -1;
        }


        return max;
    }
}
