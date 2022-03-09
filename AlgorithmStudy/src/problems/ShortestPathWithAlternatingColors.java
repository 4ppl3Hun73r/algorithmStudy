package problems;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        /*
        N개의 노드가 존재
        answer[x] -> 0 에서 x까지 색을 교차해서 이동할때의 최단 경로, 도달할수 없으면 -1 반환

        0에서 시작해서 모든 노드를 방문할수 있는지 방문한다면 가장 짧게 도달하는 경로

         */
        int[] ans = new int[n];

        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            redMap.put(i, new ArrayList<>());
            blueMap.put(i, new ArrayList<>());
            ans[i] = Integer.MAX_VALUE;
        }

        for (int[] redEdge : redEdges) {
            redMap.get(redEdge[0]).add(redEdge[1]);
        }

        for (int[] blueEdge : blueEdges) {
            blueMap.get(blueEdge[0]).add(blueEdge[1]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 다음으로 red를 가야함 1 red
        queue.add(new int[]{0, 0, 2}); // 디음으로 blue를 가야함 2 blue

        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];
        redVisited[0] = true;
        blueVisited[0] = true;

        while (!queue.isEmpty()) {
            int[] graph = queue.poll();
            int node = graph[0];
            int step = graph[1];
            int nextColor = graph[2];

            ans[node] = Math.min(ans[node], step);
            if (nextColor == 1) {
                // 다음으로 red를 가야함
                List<Integer> nextNodes = redMap.get(node);
                for (Integer nextNode : nextNodes) {
                    if (!redVisited[nextNode]) {
                        queue.add(new int[]{nextNode, step + 1, 2});
                        redVisited[nextNode] = true;
                    }
                }
            } else {
                // 다음으로 blue를 가야함
                List<Integer> nextNodes = blueMap.get(node);
                for (Integer nextNode : nextNodes) {
                    if (!blueVisited[nextNode]) {
                        queue.add(new int[]{ nextNode, step + 1, 1});
                        blueVisited[nextNode] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ShortestPathWithAlternatingColors s = new ShortestPathWithAlternatingColors();

        System.out.println(Arrays.toString(s.shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{1, 2}})));
    }
}
