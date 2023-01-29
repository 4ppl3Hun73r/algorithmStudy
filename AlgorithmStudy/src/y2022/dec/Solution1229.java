package y2022.dec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/single-threaded-cpu/
public class Solution1229 {
    public int[] getOrder(int[][] tasks) {

        int taskLength = tasks.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        int[][] sortTasks = new int[taskLength][3];
        for (int i = 0; i < taskLength; ++i) {
            sortTasks[i][0] = tasks[i][0];
            sortTasks[i][1] = tasks[i][1];
            sortTasks[i][2] = i;
        }

        Arrays.sort(sortTasks, Comparator.comparingInt(a -> a[0])); // enqueueTime
        int[] order = new int[taskLength];

        long currTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;
        while (taskIndex < tasks.length || !pq.isEmpty()) {
            if (pq.isEmpty() && currTime < sortTasks[taskIndex][0]) {
                currTime = sortTasks[taskIndex][0];
            }

            while (taskIndex < taskLength && currTime >= sortTasks[taskIndex][0]) {
                pq.offer(sortTasks[taskIndex++]);
            }

            int processTime = pq.peek()[1];
            int idx = pq.peek()[2];
            pq.poll();

            currTime += processTime;
            order[ansIndex++] = idx;
        }

        return order;
    }
}
