package y2023.jan;

import java.util.Arrays;

// https://leetcode.com/problems/best-team-with-no-conflicts/
public class Solution0131 {
    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;

        int[][] ageScoreArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            ageScoreArr[i][0] = ages[i];
            ageScoreArr[i][1] = scores[i];
        }

        // 나이가 같으면 점수 순, 나이가 다르면 나이순
        Arrays.sort(ageScoreArr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        System.out.println(Arrays.deepToString(ageScoreArr).replaceAll("],", "\n"));

        Integer[][] dp = new Integer[n][n];

        return find(dp, ageScoreArr, -1, 0);
    }

    private int find(Integer[][] dp, int[][] ageScoreArr, int prevAgeIdx, int ageIdx) {
        if (ageIdx >= ageScoreArr.length) {
            return 0;
        }
        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        if (dp[prevAgeIdx + 1][ageIdx] != null) {
            return dp[prevAgeIdx + 1][ageIdx];
        }

        if (prevAgeIdx == -1 || ageScoreArr[ageIdx][1] >= ageScoreArr[prevAgeIdx][1]) {
            return dp[prevAgeIdx + 1][ageIdx] = Math.max(find(dp, ageScoreArr, prevAgeIdx, ageIdx + 1),
                    ageScoreArr[ageIdx][1] + find(dp, ageScoreArr, ageIdx, ageIdx + 1));
        }

        return dp[prevAgeIdx + 1][ageIdx] = find(dp, ageScoreArr, prevAgeIdx, ageIdx + 1);
    }

    public static void main(String[] args) throws Exception {
        Solution0131 s = new Solution0131();

        System.out.println(s.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }
}
