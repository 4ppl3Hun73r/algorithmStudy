package y2022.jan;

// https://leetcode.com/problems/stone-game-iv/
public class Solution0122 {
    public boolean winnerSquareGame(int n) {
        /*
        A / B
        n을 제거해 나감
        1, 4, 9, 16, 25 36 과 같이 제곱으로만 제거 가능

        제곱에 근접해서 제거해 나갔을때 결국
        n = i * i + j * j + (1, 2, 3)

        남는 수가 2면 B가 승
        남는 수가 1, 3이면 A가 승
         */
        /*

        boolean turn = true;
        while ( n > 1 ) {
            int sqrt = (int)Math.sqrt(n);
            System.out.printf("%d, %d", n, sqrt);
            n = n - (sqrt * sqrt);
            System.out.printf(", %d\n", n);
            turn = !turn;
        }

        if (n == 0) {
            return !turn;
        }

        return turn;

        틀리는 케이스가 있음 8, 37 -> false 로 나옴. 답은 true
         */

        /*
        dp로 풀어 보기

        dp[i] = true => 돌이 i이면 A가 이김

        A가 이기는 경우, 자신이 질경우 + (x * x) 가 될때
        dp[0] = false
        dp[1] = true
        dp[2] = false
        dp[3] = true
        dp[4] = true
        dp[5] = false
        dp[6] = true
        dp[7] = false
        dp[8] = true
        dp[9] = true
        dp[10] = false
         */

        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            if (dp[i]) {
                // 자기가 이기는 경우는 스킵
                continue;
            }
            for (int j = 1; i + j * j <= n; j++) { // 질경우 + (x * x) 는 무조건 이김
                dp[i + j * j] = true;
            }
        }

        return dp[n];
    }

    // 37 33 29
    // A  4
    // B     4

    public static void main(String[] args) {
        Solution0122 s = new Solution0122();

        // System.out.println(s.winnerSquareGame(1));
        // System.out.println(s.winnerSquareGame(2));
        // System.out.println(s.winnerSquareGame(3));
        // System.out.println(s.winnerSquareGame(4));
        System.out.println(s.winnerSquareGame(37)); // true
    }
}
