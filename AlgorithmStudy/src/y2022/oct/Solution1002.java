package y2022.oct;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class Solution1002 {
    public int numRollsToTarget(int n, int k, int target) {

        int mod = 1000000007;
        long[][] dp = new long[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int dice = 1; dice <= k; dice++) {
                    if (j >= dice) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - dice]) % mod;
                    } else {
                        break;
                    }
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        return (int)dp[n][target];
    }

    public static void main(String[] args) {

        Solution1002 s = new Solution1002();

        System.out.println(s.numRollsToTarget(6, 6, 30));
    }
}
