package y2023.apr;

// https://leetcode.com/problems/restore-the-array/
public class Solution0423 {
    public int numberOfArrays(String s, int k) {
        // 여러 숫자가 공백 없이 S 가 되었다.
        // 1 < N < k 사이의 값이라는 것만 안다.
        // 숫자는 0으로 시작하지는 않는다.

        int n = s.length();
        int[] dp = new int[n + 1];
        return dfs(dp, 0, s, k);

    }

    int mod = 1000000007;
    private int dfs(int[] dp, int start, String s, int k) {
        if (dp[start] != 0) {
            return dp[start];
        }

        if (start == s.length()) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        int count = 0;
        for (int end = start; end < s.length(); end++) {
            String currNumber = s.substring(start, end + 1);
            if (Long.parseLong(currNumber) > k) {
                break;
            }
            count = (count + dfs(dp, end + 1, s, k)) % mod;
        }

        return dp[start] = count;
    }
}
