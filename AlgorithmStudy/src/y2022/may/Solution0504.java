package y2022.may;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/
public class Solution0504 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCntMap = new HashMap<>();

        for (int num : nums) {
            numCntMap.put(num, numCntMap.getOrDefault(num, 0) + 1);
        }

        int pair = 0;
        for (int num : nums) {
            int need = k - num;
            if (need == num) {
                int cnt = numCntMap.getOrDefault(need, 0);
                pair += cnt / 2;
                numCntMap.remove(need);
            } else {
                int numCnt = numCntMap.getOrDefault(num, 0);
                int needCnt = numCntMap.getOrDefault(need, 0);
                int min = Math.min(numCnt, needCnt);
                pair += min;
                numCntMap.put(num, numCnt - min);
                numCntMap.put(need, needCnt - min);
            }
        }

        return pair;
    }
}
