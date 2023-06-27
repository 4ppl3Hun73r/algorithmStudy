package y2023.may;

// https://leetcode.com/problems/stone-game-ii/
public class Solution0526 {
    public int stoneGameII(int[] piles) {
        /*
        Alice 가 시작
        각 턴에 X 개를 가져 올 수 있음
        1 <= X <= 2M
        가져온 다음 M = max(X, M) 으로 설정됨
        시작 M = 1
        모든 돌맹이를 가져올때까지 계속 됨

        [2,7,9,4,4]

        A : 2
        B :   7, 9
        A :        4, 4

        A : 2, 7
        B :      9, 4, 4


        1 - 1, 2
        2 - 1, 2, 3, 4
        3 - 1, 2, 3, 4, 5, 6
        4 - 1, 2, 3, 4, 5, 6, 7, 8
        ...

        1 <= piles.length <= 100
        1 <= piles[i] <= 104

        [1,2,3,4,5,100]

        dp[i+~~~] = Math.max(value, dp[i+~~)

        중복? cache?

        // dp[i][j][k]
        // dp[엘리스선택][밥의선택][N개선택]
         */
        Integer[][][] dp = new Integer[2][piles.length + 1][piles.length + 1];

        return dfs(piles, dp, Player.ALICE, 0, 1);
    }

    enum Player {
        ALICE(0), BOB(1);

        int idx;

        Player(int i) {
            this.idx = i;
        }
    }

    private int dfs(int[] piles, Integer[][][] dp, Player player, int start, int M) {
        if ( start >= piles.length) {
            return 0;
        }

        if (dp[player.idx][start][M] != null) {
            return dp[player.idx][start][M];
        }

        int res = player == Player.BOB ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int subsum = 0;
        for (int x = 1; x <= Math.min(2 * M, piles.length - start); x++) {
            subsum += piles[start + x - 1]; // 내가 N 개를 뽑고 있음

            if (player == Player.ALICE) { // alice
                res = Math.max(res, subsum + dfs(piles, dp, Player.BOB, start + x, Math.max(x, M)));
            } else {
                res = Math.min(res, dfs(piles, dp, Player.ALICE, start + x,  Math.max(x, M)));
            }
        }

        return dp[player.idx][start][M] = res;
    }

    public static void main(String[] args) throws Exception {
        Solution0526 s = new Solution0526();

        System.out.println(s.stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(s.stoneGameII(new int[]{1,2,3,4,5,100}));
    }
}
