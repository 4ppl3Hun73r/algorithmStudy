package y2022.feb;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/
public class Solution0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            while (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            ans.add(getSummary(a, nums[i]));
        }

        return ans;
    }

    private String getSummary(int a, int b) {
        if ( a == b ) {
            return Integer.toString(a);
        }

        return a + "->" + b;
    }
}
