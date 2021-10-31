package problems;

import model.GridCodec;

import java.util.Arrays;

// https://leetcode.com/problems/dungeon-game/
public class DungeonGame {
    // TODO 푸는중
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;

        int[][] dp = new int[r][c];

        /*
        dp[0][0] => 해당 위치까지의 도달할수 있는 최소 HP
         */

        dp[0][0] = Math.min(dungeon[0][0], 0); // 음수는 그대로 넣기
        for (int i = 1; i < c; i++) {
            dp[0][i] = dp[0][i - 1] + dungeon[0][i] > 0 ? dp[0][i - 1] : dp[0][i - 1] + dungeon[0][i];
        }
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i - 1][0] + dungeon[i][0] > 0 ? dp[i - 1][0] : dp[i - 1][0] + dungeon[i][0];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                int left = j - 1;
                int up = i - 1;
                // move rightward
                int leftHp = 0;
                if (left >= 0) {
                    leftHp = dp[i][left];
                }
                // move downward
                int upHp = 0;
                if (up >= 0) {
                    upHp = dp[up][j];
                }

                int maxHp = 0;
                if (leftHp < 0 && upHp < 0) {
                    maxHp = Math.max(leftHp, upHp);
                } else {
                    maxHp = Math.min(leftHp, upHp);
                }

                if (dungeon[i][j] + maxHp > 0) {
                    dp[i][j] = maxHp;
                } else {
                    dp[i][j] = maxHp + dungeon[i][j];
                }
                System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));
            }
        }

        return -(dp[r - 1][c - 1] - 1);
    }

    public static void main(String[] args) {
        GridCodec g = new GridCodec();
        DungeonGame d = new DungeonGame();

        System.out.println(d.calculateMinimumHP(g.getIntGrid("[[-2,-3,3],[-5,-10,1],[10,30,-5]]")));
        System.out.println(d.calculateMinimumHP(g.getIntGrid("[[2,3,3],[5,10,1],[10,30,5]]")));
        System.out.println(d.calculateMinimumHP(g.getIntGrid("[[2,3,3],[5,-10,1],[10,30,5]]")));
    }
}
