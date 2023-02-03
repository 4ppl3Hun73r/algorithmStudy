package y2023.jan;

import java.util.Arrays;

// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
public class Solution0125 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        boolean[] visit1 = new boolean[n];
        boolean[] visit2 = new boolean[n];

        dfs(node1, edges, dist1, visit1);
        dfs(node2, edges, dist2, visit2);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (minDistTillNow > Math.max(dist1[i], dist2[i])) {
                minDistNode = i;
                minDistTillNow = Math.max(dist1[i], dist2[i]);
            }
        }

        return minDistNode;
    }

    private void dfs(int node, int[] edges, int[] dist, boolean[] visit) {
        visit[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visit[neighbor]) {
            dist[neighbor] = 1 + dist[node];
            dfs(neighbor, edges, dist, visit);
        }
    }
}
