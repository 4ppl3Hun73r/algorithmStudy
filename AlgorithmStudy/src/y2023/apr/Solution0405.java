package y2023.apr;

// https://leetcode.com/problems/minimize-maximum-of-array/
public class Solution0405 {
    public int minimizeArrayValue(int[] nums) {
        /*

        [증가, 감소]
        0이상이어야함

        sum(nums) => 변동이 없음

        최대 수중 최소값....
         */

        /*long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (int)((sum - 1) / (nums.length - 1));*/

        long answer = 0;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }

        return (int) answer;

    }
}
