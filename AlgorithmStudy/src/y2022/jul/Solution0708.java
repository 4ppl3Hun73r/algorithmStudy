package y2022.jul;

// https://leetcode.com/problems/paint-house-iii/
public class Solution0708 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        /*
        m 개 만큼의 집이 있다.
        집은 1 ~ n 까지의 색으로 칠할 수 있다.
        현재 집의 색은 houses 이며, 0 이면 색이 칠해지지 않은 상태이다.
        house[i] 를 n 색으로 칠하는 비용은 cost[i][j] 이다.

        houese는 동일한 색을 그룹으로 묶을 수 있는데
        {1, 2, 2, 1, 1} -> [1], [2, 2], [1, 1] -> 3그룹
        이런 식이다.
        target 만큼의 색 그룹 으로 만들 수 있는 최소한의 cost 를 구하라.

        hint.
        Define dp[i][j][k] as the minimum cost w
        here we have k neighborhoods in the first i houses
        and the i-th house is painted with the color j.

        i번째 집을 j 색으로 칠했을때 k 이웃?

        dp[0][0][0] -> 0번째 집을 0색으로 칠하고, 0번째 그룹
        dp[0][1][0] -> 0번쨰 집을 1색으로 칠하고, 0번째 그룹
        dp[0][2][0] -> 0번쨰 집을 2색으로 칠하고, 0번쨰 그룹

        dp[1][0][0] -> 1번째 집을 0색으로 칠하고, 0번째 그룹
        dp[1][1][0] -> 1번째 집을 1색으로 칠하고, 0번째 그룹
        ...
         */
        final int MAX_COST = 1000001;

        // m 번째 집이 k 번째 그룹일 때 n 색으로 칠했을때의 최소 비용
        int[][][] dp = new int[m][target + 1][n];

        // dp 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = MAX_COST;
                }
            }
        }

        // 0 번째 집 초기화
        for (int color = 1; color <= n; color++) {
            if (houses[0] == color) {
                dp[0][1][color - 1] = 0;
            } else if (houses[0] == 0) {
                dp[0][1][color - 1] = cost[0][color - 1];
            }
        }

        // 집 -> 그룹 -> 색
        for (int house = 1; house < m; house++) {
            for (int neighborhoods = 1; neighborhoods <= Math.min(target, house + 1); neighborhoods++) {
                for (int color = 1; color <= n; color++) {
                    // 집이 이미 칠해져 있고, 새로 칠할 색이랑 다르면 패스
                    if (houses[house] != 0 && color != houses[house]) {
                        continue;
                    }

                    int currCost = MAX_COST;
                    // 이전 집과 동일한 색일때 / 다른 색일때의 비용 계산
                    for (int prevColor = 1; prevColor <= n; prevColor++) {
                        if (prevColor != color) {
                            // 다른 색일때 그룹 분리 하면서 비용 계산
                            currCost = Math.min(currCost, dp[house - 1][neighborhoods - 1][prevColor - 1]);
                        } else {
                            // 같은 색일떄 그룹 분리 안하고 비용 계산
                            currCost = Math.min(currCost, dp[house - 1][neighborhoods][color - 1]);
                        }
                    }

                    int costToPaint = houses[house] != 0 ? 0 : cost[house][color - 1];
                    dp[house][neighborhoods][color - 1] = currCost + costToPaint;
                }
            }
        }

        int minCost = MAX_COST;
        // dp[마지막집][타겟]의 최소값을 찾기
        for (int color = 1; color <= n; color++) {
            minCost = Math.min(minCost, dp[m - 1][target][color - 1]);
        }

        return minCost == MAX_COST ? -1 : minCost;
    }
}
