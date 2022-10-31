package y2022.oct;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/continuous-subarray-sum/
public class Solution1026 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // subarray 의 합이 k 되거나 k * n(int) 으로 이뤄지면 true
        // -> 합이 k 가 된다. K * 1 -> k * n 조건만 보면 됨
        // sum % k == 0 이면 true


        /* 시간 초과
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;

        */

        // https://leetcode.com/problems/continuous-subarray-sum/discuss/150330/Math-behind-the-solutions
        // 연속된 합을 k 의 나머지(mod)로 구할때
        // 앞에 mod 의 결과 와 동일한 mod 가 나오게 된다면 해당 지점까지가 mod 했을때 0이 나오는 지점이 된다.


        if (nums.length < 2) return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int rem = 0;
            if (k != 0) {
                rem = currSum % k;
            }
            if (map.containsKey(rem)) {
                if (i - map.get(rem) > 1) {
                    return true;
                }
            }
            map.putIfAbsent(rem, i);
        }

        return false;
    }
}
