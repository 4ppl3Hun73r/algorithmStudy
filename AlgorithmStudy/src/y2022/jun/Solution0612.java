package y2022.jun;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-erasure-value/
public class Solution0612 {
    public int maximumUniqueSubarray(int[] nums) {
        /*
        가장 긴 unique 한 연속적인 하위배열의 합을 반환
         */
        int ans = 0;

        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (numIndexMap.containsKey(n)) {
                int idx = numIndexMap.get(n);
                while (start <= idx) {
                    numIndexMap.remove(nums[start]);
                    sum -= nums[start];
                    start++;
                }
            }
            numIndexMap.put(n, i);
            sum += n;
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
