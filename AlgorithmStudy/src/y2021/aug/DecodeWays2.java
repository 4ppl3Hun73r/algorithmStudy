package y2021.aug;

// https://leetcode.com/problems/decode-ways-ii/solution/
public class DecodeWays2 {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;

        // 123456
        // dp[0] : 1
        // dp[1] : 1, 1 => 1
        // dp[2] : 2, 1 => 12 => 12, 1 / 2
        // dp[3] : 3, 123 => 123, 12 / 3, 1 / 2 / 3,
        for (int i = 2; i < len + 1; i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            if (first == '*') {
                if (second == '*') {
                    // **(0 ~ 9, or *) => 81 + 9 + 6 => 96
                    // dp[3] = fn(dp[2] + dp[1]);
                    // **? =>

                    dp[i] += 15 * dp[i - 2];
                }else if(second <= '6'){
                    dp[i] += 2*dp[i-2];
                }else{
                    dp[i] += dp[i-2];
                }
            } else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){
                        dp[i] += 9*dp[i-2];
                    }else{ // first == '2'
                        dp[i] += 6*dp[i-2];
                    }
                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];
                }
            }

            // Since the answer may be very large, return it modulo 10^9 + 7.

            dp[i] = dp[i] % 1000000007;

        }



        return dp[len];
    }
}
