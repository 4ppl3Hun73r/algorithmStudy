package y2022.dec;

import java.util.Arrays;

// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
public class Solution1225 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            int query = queries[i];
            for (int num : nums) {
                if (query >= num) {
                    count++;
                    query -= num;
                }
                else {
                    break;
                }
            }
            ans[i] = count;

        }

        return ans;
    }
}
