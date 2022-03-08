package problems;

import java.util.*;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Map<Integer, List<Integer>> subMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            subMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                subMap.get(manager[i]).add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, informTime[headID]});
        int maxTime = 0;
        while(!queue.isEmpty()) {
            int[] m = queue.poll();

            maxTime = Math.max(maxTime, m[1]);
            // 하위로 전파
            List<Integer> sub = subMap.get(m[0]);
            for (int i = 0; i < sub.size(); i++) {
                int e = sub.get(i);
                if (informTime[e] != 0) {
                    queue.add(new int[]{e, m[1] + informTime[e]});
                }
            }
        }

        return maxTime;
    }
}
