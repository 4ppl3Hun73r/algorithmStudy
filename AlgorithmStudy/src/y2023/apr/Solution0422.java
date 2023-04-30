package y2023.apr;

// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class Solution0422 {
    public int minInsertions(String s) {


        /*

        가운데에서 좌우로 퍼져 나가면서 체크
          zzaazz
            00

          zzabzz
            11

          zzazz
            0




         */
        // https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/solutions/3442382/image-explanation-recursion-top-down-bottom-up-bottom-up-o-n-c-java-python/
        // 몰르겠다... 어렵다... dp 싫다.
        return s.length() - longestPalindromeSubseq(s);

    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] dpPrev = new int[n];

        for ( int start = n - 1; start >= 0; start--) {
            dp[start] = 1;
            // [a d a c a]
            // [0 0 0 0 1]
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[end] = dpPrev[end - 1] + 2;
                    // p[ 0 0 0 0 1]
                    // d[ 0 0 0 1 3]
                } else {
                    dp[end] = Math.max(dpPrev[end], dp[end - 1]);
                }
            }
            dpPrev = dp.clone();
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution0422 s = new Solution0422();

        System.out.println(s.minInsertions("abaca"));
    }
}
