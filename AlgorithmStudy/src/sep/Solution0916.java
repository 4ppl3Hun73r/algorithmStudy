package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3976/
public class Solution0916 {

    public int maxTurbulenceSize(int[] arr) {
        // i <= k < j
        // arr[k] > arr[k + 1] k 가 홀수
        // arr[k] < arr[k + 1] k 가 짝수
        // or
        // arr[k] > arr[k + 1] k 가 짝수
        // arr[k] < arr[k + 1] k 가 홀수

        // [9,4,2,10,7,8,8,1,9]
        // arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
        // 4 > 2, 2 < 10, 10 > 7, 8 < 8, 8 > 1, 1 < 9
        //
        // [4,8,12,16]
        // arr[1] > arr[2] k 가 홀수,
        // [4,8] , [8,12], [12,16] 지그재그 확인

        int[][] dp = new int[len][2];
        // dp[i][0] => i번째까지 최고 길이 (짝수) arr[i] > arr[i+1]
        // dp[i][1] => i번째까지 최고 길이 (홀수) arr[i] < arr[i-1]

        int[] dp2 = new int[len];
        // dp2[i] = dp2[i - 1] + 1;
        // dp[i][j] => i ~ j  사이의 최고길이

        int len = arr.length;
        int max = 1;
        int up = 1;
        int down = 1;
        for (int i = 0; i < len - 1; i++) {
            // [9,4,2,10,7,8,8,1,9]
            // (u, d)
            // (1, 2) 9 > 4
            // (1, 2) 4 > 2
            // (3, 1) 2 < 10
            // (1, 4) 10 > 7
            // (5, 1) 7 < 8
            // (1, 1) 8 == 8
            // dp[i][0] up  -> dp[i - 1][1] + 1 , dp[i][0] = 1
            // dp[i][1] down  -> dp[i -1][0] + 1, dp[i][1] = 1
            if (arr[i] > arr[i + 1]) {
                down = up + 1;
                up = 1;
            } else if (arr[i] < arr[i + 1]) {
                up = down + 1;
                down = 1;
            } else {
                // 같을때
                up = 1;
                down = 1;
            }
            max = Math.max(max, Math.max(up, down));
        }

        return max;
    }

    public int solution(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }


}
