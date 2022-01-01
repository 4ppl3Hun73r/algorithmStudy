package y2021.nov;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/all-paths-from-source-to-target/
public class Solution1128 {
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
}
