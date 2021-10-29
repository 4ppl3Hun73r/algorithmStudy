package problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valuePosMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needVal = target - nums[i];
            if (valuePosMap.containsKey(needVal)) {
                return new int[]{i, valuePosMap.get(needVal)};
            }
            valuePosMap.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}
