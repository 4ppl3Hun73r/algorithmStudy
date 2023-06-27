package y2023.mar;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
public class Solution0331 {

    public int ways(String[] pizza, int k) {
        /*
        피자를 자른다
        가로로 자르면 위쪽을 버리고
        세로로 자르면 왼쪽을 버린다.

        (k-1) 번 잘라서 K 개의 조각으로 나누기   (사과는 하나 포함 되어야 함)

        A..
        AAA
        ...
         */

        int rows = pizza.length;
        int cols = pizza[0].length();
        int apples[][] = new int[rows + 1][cols + 1];
        int dp[][][] = new int[k][rows][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + apples[row + 1][col] + apples[row][col + 1]
                        - apples[row + 1][col + 1];
                dp[0][row][col] = apples[row][col] > 0 ? 1 : 0;
            }
        }
        int mod = 1000000007;
        for (int remain = 1; remain < k; remain++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int next_row = row + 1; next_row < rows; next_row++) {
                        if (apples[row][col] - apples[next_row][col] > 0) {
                            dp[remain][row][col] += dp[remain - 1][next_row][col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                    for (int next_col = col + 1; next_col < cols; next_col++) {
                        if (apples[row][col] - apples[row][next_col] > 0) {
                            dp[remain][row][col] += dp[remain - 1][row][next_col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0];
    }


    int mod = (int) (1e9) + 7;
    Boolean[][][][] hasAppleCache;
    Integer[][][][][] memo;

    public int waysFail(String[] pizza, int k) {
        /*
        피자를 자른다
        가로로 자르면 위쪽을 버리고
        세로로 자르면 왼쪽을 버린다.
        (k-1) 번 잘라서 K 개의 조각으로 나누기   (사과는 하나 포함 되어야 함)
        A..
        AAA
        ...
         */

        int rowLen = pizza.length;
        int colLen = pizza[0].length();

        hasAppleCache = new Boolean[rowLen + 1][colLen + 1][rowLen + 1][colLen + 1];
        memo = new Integer[rowLen + 1][colLen + 1][rowLen + 1][colLen + 1][k];

        buildHasApple(pizza);

        return helper(0, 0, rowLen, colLen, pizza, k - 1);
    }

    long cacheHit = 0;
    long call = 0;
    private int helper(int r, int c, int rowLen, int colLen, String[] pizza, int k) {
        call++;
        if (k == 0) {
            return 1;
        }

        if (memo[r][c][rowLen][colLen][k] != null) {
            cacheHit++;
            return memo[r][c][rowLen][colLen][k];
        }

        int ans = 0;
        // 가로로 자르기
        for (int j = r + 1; j < rowLen; j++) {
            // r ~ j 자르 구간에 사과가 있으면
            if (hasApple(r, c, j, colLen) && hasApple(j, c, rowLen, colLen)) {
                ans += helper(j, c, rowLen, colLen, pizza, k - 1);
                ans = ans % mod;
            }
        }

        // 세로로 자르기
        for (int j = c + 1; j < colLen; j++) {
            if (hasApple(r, c, rowLen, j) && hasApple(r, j, rowLen, colLen)) {
                ans += helper(r, j, rowLen, colLen, pizza, k - 1);
                ans = ans % mod;
            }
        }

        return memo[r][c][rowLen][colLen][k] = ans % mod;
    }

    //j ==2 , r = 1, c = 0,
    //1,0, 3, 2
    // 1~3 row, 0 ~ 2 col
    //
    private boolean hasApple(int r, int c, int r2, int c2) {
        return hasAppleCache[r][c][r2][c2];
    }

    private void buildHasApple(String[] pizza) {

        int rowLen = pizza.length;
        int colLen = pizza[0].length();

        // prefix sum
        int[][] prefixSum = new int[rowLen + 1][colLen + 1];
        for (int r = rowLen - 1; r >= 0; r--) {
            for (int c = colLen - 1; c >= 0; c--) {
                prefixSum[r][c] = (pizza[r].charAt(c) == 'A' ? 1 : 0) + prefixSum[r + 1][c] + prefixSum[r][c + 1]
                        - prefixSum[r + 1][c + 1];
            }
        }

        System.out.println(Arrays.deepToString(prefixSum).replaceAll("],", "\n"));
        for (int i = 0; i <= rowLen; i++) {
            for (int j = 0; j <= colLen; j++) {
                for (int r = i + 1; r <= rowLen; r++) {
                    for (int c = j + 1; c <= colLen; c++) {
                        hasAppleCache[i][j][r][c] = rangeSum(prefixSum, i, j, r, c) > 0;
                    }
                }
            }
        }

        System.out.println(rangeSum(prefixSum, 0, 0, 1, 1));
        System.out.println(rangeSum(prefixSum, 0, 0, 1, 3));

        System.out.println(rangeSum(prefixSum, 0, 0, 3, 0));
    }

    private int rangeSum(int[][] prefixSum, int y0, int x0, int y1, int x1) {
        //(x1, y1) - (x0 - 1, y1) - (x1, y0 - 1) + (x0 -1, y0 - 1) = (x0, y0) ~ (x1, y1)
        return prefixSum[y1][x1] - (x0 - 1 >= 0 ? prefixSum[y1][x0 - 1] : 0)
                - (y0 - 1 >= 0 ? prefixSum[y0 - 1][x1] : 0)
                + (x0 - 1 >= 0 && y0 - 1 >= 0 ? prefixSum[y0 - 1][x0 - 1] : 0);
    }

    public static void main(String[] args) throws Exception {
        Solution0331 s = new Solution0331();

        System.out.println(s.ways(new String[]{"A..", "AAA", "..."}, 3));

        //System.out.println(s.ways(new String[]{"A..", "AA.", "..."}, 3));

        //System.out.println(s.ways(new String[]{"A..", "A..", "..."}, 1));

        //System.out.println(s.ways(new String[]{"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA","A.AA.A.....AA..AA.AA.A....AAA.A........AAAAA.A.AA.","A..AA.AAA..AAAAAAAA..AA...A..A...A..AAA...AAAA..AA","....A.A.AA.AA.AA...A.AA.AAA...A....AA.......A..AA.","AAA....AA.A.A.AAA...A..A....A..AAAA...A.A.A.AAAA..","....AA..A.AA..A.A...A.A..AAAA..AAAA.A.AA..AAA...AA","A..A.AA.AA.A.A.AA..A.A..A.A.AAA....AAAAA.A.AA..A.A",".AA.A...AAAAA.A..A....A...A.AAAA.AA..A.AA.AAAA.AA.","A.AA.AAAA.....AA..AAA..AAAAAAA...AA.A..A.AAAAA.A..","A.A...A.A...A..A...A.AAAA.A..A....A..AA.AAA.AA.AA.",".A.A.A....AAA..AAA...A.AA..AAAAAAA.....AA....A....","..AAAAAA..A..A...AA.A..A.AA......A.AA....A.A.AAAA.","...A.AA.AAA.AA....A..AAAA...A..AAA.AAAA.A.....AA.A","A.AAAAA..A...AAAAAAAA.AAA.....A.AAA.AA.A..A.A.A...","A.A.AA...A.A.AA...A.AA.AA....AA...AA.A..A.AA....AA","AA.A..A.AA..AAAAA...A..AAAAA.AA..AA.AA.A..AAAAA..A","...AA....AAAA.A...AA....AAAAA.A.AAAA.A.AA..AA..AAA","..AAAA..AA..A.AA.A.A.AA...A...AAAAAAA..A.AAA..AA.A","AA....AA....AA.A......AAA...A...A.AA.A.AA.A.A.AA.A","A.AAAA..AA..A..AAA.AAA.A....AAA.....A..A.AA.A.A...","..AA...AAAAA.A.A......AA...A..AAA.AA..A.A.A.AA..A.",".......AA..AA.AAA.A....A...A.AA..A.A..AAAAAAA.AA.A",".A.AAA.AA..A.A.A.A.A.AA...AAAA.A.A.AA..A...A.AAA..","A..AAAAA.A..A..A.A..AA..A...AAA.AA.A.A.AAA..A.AA..","A.AAA.A.AAAAA....AA..A.AAA.A..AA...AA..A.A.A.AA.AA",".A..AAAA.A.A.A.A.......AAAA.AA...AA..AAA..A...A.AA","A.A.A.A..A...AA..A.AAA..AAAAA.AA.A.A.A..AA.A.A....","A..A..A.A.AA.A....A...A......A.AA.AAA..A.AA...AA..",".....A..A...A.A...A..A.AA.A...AA..AAA...AA..A.AAA.","A...AA..A..AA.A.A.AAA..AA..AAA...AAA..AAA.AAAAA...","AA...AAA.AAA...AAAA..A...A..A...AA...A..AA.A...A..","A.AA..AAAA.AA.AAA.A.AA.A..AAAAA.A...A.A...A.AA....","A.......AA....AA..AAA.AAAAAAA.A.AA..A.A.AA....AA..",".A.A...AA..AA...AA.AAAA.....A..A..A.AA.A.AA...A.AA","..AA.AA.AA..A...AA.AA.AAAAAA.....A.AA..AA......A..","AAA..AA...A....A....AA.AA.AA.A.A.A..AA.AA..AAA.AAA","..AAA.AAA.A.AA.....AAA.A.AA.AAAAA..AA..AA.........",".AA..A......A.A.AAA.AAAA...A.AAAA...AAA.AAAA.....A","AAAAAAA.AA..A....AAAA.A..AA.A....AA.A...A.A....A..",".A.A.AA..A.AA.....A.A...A.A..A...AAA..A..AA..A.AAA","AAAA....A...A.AA..AAA..A.AAA..AA.........AA.AAA.A.","......AAAA..A.AAA.A..AAA...AAAAA...A.AA..A.A.AA.A.","AA......A.AAAAAAAA..A.AAA...A.A....A.AAA.AA.A.AAA.",".A.A....A.AAA..A..AA........A.AAAA.AAA.AA....A..AA",".AA.A...AA.AAA.A....A.A...A........A.AAA......A...","..AAA....A.A...A.AA..AAA.AAAAA....AAAAA..AA.AAAA..","..A.AAA.AA..A.AA.A...A.AA....AAA.A.....AAA...A...A",".AA.AA...A....A.AA.A..A..AAA.A.A.AA.......A.A...A.","...A...A.AA.A..AAAAA...AA..A.A..AAA.AA...AA...A.A.","..AAA..A.A..A..A..AA..AA...A..AA.AAAAA.A....A..A.A"}, 8));
        //System.out.println(s.call);
        //System.out.println(s.cacheHit);
    }
}
