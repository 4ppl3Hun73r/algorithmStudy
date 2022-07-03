package y2022.jul;

// https://leetcode.com/problems/wiggle-subsequence/
public class Solution0703 {
    public int wiggleMaxLength(int[] nums) {
        /*
        양의 정수만 들어 있는 nums 가 있다.

        각 배열의 차가 +, - 가 반복되면 wiggle 하다.

        가장 긴 wiggle을 만들 수 있는 subsequence 의 길이는 어떻게 되는가?

        subsequence 는 순서는 바꾸지 않고 제거해서 만들 수 있다.


        dp[n][0] -> 올라가기
        dp[n][1] -> 내려가기

        [1,17,5,10,13,15,10,5,16,8]
         16,-12,5,-3,2,-5,-5,11,-8

         1, 17, 10, 13, 10, 16, 8

        0 : [0, 1, 1, 3, 3, 5, 5, 5, 7, 7]
        1 : [0, 0, 2, 2, 4, 4, 6, 6, 6, 8]

        nums의 차이가 양수
        dp[n][0] = dp[n - 1][1] + 1
        dp[n][1] = dp[n - 1][1]

        nums의 차이가 음수
        dp[n][0] = dp[n - 1][0]
        dp[n][1] = dp[n - 1][0] + 1
         */

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {
            // 양수
            if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);

    }
}
