package y2023.feb;


// https://leetcode.com/problems/jump-game-ii/
public class Solution0208 {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // dp[i] = i까지 도달할수 있는 최소한의 step
        // dp[0] = 0번째는 도달 불가하기 때문에 0
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            for (int j = i; j <= i + step && j< nums.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
                // dp[j] -> 이미 누군가 여기까지 N값 안에 올수 있다.
                // dp[i] + 1 -> dp[i] 번째 에서 한걸음 더 하면 올수 있다.
                // 이 둘중 작은값이 dp[j] 까지 도달하는 가장 작은 step!!!
            }
        }

        // [2,3,1,1,4]
        // [0,9,9,9,9]
        // i = 0, dp[0] = min(0, 0 + 1), dp[1] = min(9, 0 + 1), dp[2] = min(9, 0 + 1), [0, 1, 1, 9, 9]
        // i = 1, dp[1] = min(1, 1 + 1), dp[2] = min(1, 1 + 1), dp[3] = min(9, 1 + 1), dp[4] = min(9, 1 + 1), [0, 1, 1, 2, 2]
        // i = 2, dp[2] = min(1, 1 + 1), dp[3] = min(1, 2 + 1), [0, 1, 1, 2, 2]
        // i = 3, dp[3] = min(2, 2 + 1), dp[4] = min(2, 2 + 1), [0, 1, 1, 2, 2]
        // i = 4, dp[4] = min(2, 2 + 1), [0, 1, 1, 2, 2]

        return dp[nums.length - 1];
    }

}
