package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int key = queue.poll();
            List<Integer> keys = rooms.get(key);

            for (Integer newKey : keys) {
                if (!visited[newKey]) {
                    queue.add(newKey);
                }
            }

            visited[key] = true;
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}
