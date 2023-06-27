package y2023.jun

// https://leetcode.com/problems/longest-arithmetic-subsequence/
class Solution0623 {
    fun longestArithSeqLength(nums: IntArray): Int {

        // 1 ~ 500
        // map<nums, Index>
        // 1,1,1,1,1,1 => 6 / diff : 0

        // 9 4 7 2 10 // dp[4][3] = 3
        // ^ ^
        // 4, 7, 10
        //dp[][] = dp[전][크기] + 1
        //dp[1][3] = 1;
        //dp[2][3] = 2;

        // 9 4 7 2 10
        //   4
        // 9       => dp[1][-5] = 2
        //     7
        // 9   7   => dp[2][2] = 2
        //   4 7   => dp[2][-3] = 2
        //       2
        // 9     2 => dp[3][-7] = 2
        //   4   2 => dp[3][-2] = 2
        //         => dp[i][diff] = dp[j][diff] + 1
        //     7 2 => dp[3][-5] = 2
        //         10
        //      7  10 => dp[4][-3] = dp[2][-3]+1 = 3
        val len = nums.size
        val dp = Array(len) {
            mutableMapOf<Int, Int>()
        }
        var ans = 0
        for( i in 0 until len) {
            for (j in 0 until i) {
                val diff = nums[j] - nums[i]

                //dp[j][diff] + 1
                //dp[i][diff] = dp[j][diff] + 11
                dp[i][diff] = (dp[j][diff] ?: 1) + 1
                ans = ans.coerceAtLeast(dp[i][diff] ?: 0)
            }
        }

        //
        // dp[0][5] = 1
        // dp[0][2] = 1
        // dp[0][7] = 1
        // dp[0][-1] = 1
        // dp[1][3] = 1
        // dp[1][2] = 1
        // dp[1][-6] = 1
        // dp[2][5] = 1
        // dp[2][-3] = 1
        // dp[3][-8] = 1

        return ans
    }
}