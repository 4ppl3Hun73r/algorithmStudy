package problems;

import model.GridCodec;

import java.util.Arrays;

// https://leetcode.com/problems/dungeon-game/
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;

        int[][] dp = new int[r + 1][c + 1];
        for (int i = r; i >= 0; i--) {
            for (int j = c; j >= 0; j--) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[r][c - 1] = 1;
        dp[r - 1][c] = 1;
        // 도착지 오른쪽 아래를 1로 초기화
        /*
        종료 지점에서 역으로 탐색
        dp[i][j] = if min(dp[i + 1][j], dp[i - 1]) - dungeon[i][j] > 0 ? min(dp[i + 1][j], dp[i - 1]) - dungeon[i][j] : 1// 최소로 1의 체력이 있어야 한다.
         */



        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int needHp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];

                if (needHp > 0) {
                    dp[i][j] = needHp;
                } else {
                    dp[i][j] = 1;
                }
                System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        GridCodec g = new GridCodec();
        DungeonGame d = new DungeonGame();

        System.out.println(d.calculateMinimumHP(g.getIntGrid("[[-2,-3,3],[-5,-10,1],[10,30,-5]]")));
        System.out.println(d.calculateMinimumHP(g.getIntGrid("[[2,3,3],[5,10,1],[10,30,5]]")));
        System.out.println(d.calculateMinimumHP(g.getIntGrid("[[2,3,3],[5,-10,1],[10,30,5]]")));
    }
}
