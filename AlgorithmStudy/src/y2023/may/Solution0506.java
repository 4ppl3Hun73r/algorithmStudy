package y2023.may;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
public class Solution0506 {
    public int numSubseq(int[] nums, int target) {

        int mod = 1000000007;

        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int answer = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                answer += power[right - left];
                answer %= mod;
                left++;
            } else {
                right--;
            }
        }


        return answer;


    }
}
