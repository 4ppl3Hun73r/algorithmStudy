package y2023.jan;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
public class Solution0104 {
    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        int result = 0;
        for (Integer count : countMap.values()) {
            if (count == 1) {
                return -1;
            }
            result += count / 3;
            if (count % 3 != 0) {
                result ++;
            }
        }
        return result;
    }
}
