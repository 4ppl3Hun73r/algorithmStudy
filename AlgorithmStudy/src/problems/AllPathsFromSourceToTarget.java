package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        for (int node : graph[0]) {
            List<Integer> g = new ArrayList<>();
            g.add(0);
            g.add(node);
            queue.add(g);
        }

        int lastNode = graph.length - 1;
        while (!queue.isEmpty()) {
            List<Integer> g = queue.poll();
            int nextNode = g.get(g.size() - 1);
            if (nextNode == lastNode) {
                result.add(g);
                continue;
            }

            for(int node : graph[nextNode]) {
                List<Integer> newG = new ArrayList<>(g);
                newG.add(node);
                queue.add(newG);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
        System.out.println(a.allPathsSourceTarget(
                new int[][] {
                        {4, 3, 1},
                        {3, 2, 4},
                        {3},
                        {4},
                        {}
                }
        ));
    }
}
