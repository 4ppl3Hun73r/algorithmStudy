package y2022.jun;

import java.util.List;

public class Solution0613 {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
        삼각형에서 가장 작은 합을 찾는거
        다음 경로는 i or i + 1 만 가능

        2         -> 2
        3 4        -> 3
        6 5 7       -> 5
        4 1 8 3      -> 1

           2         -> 2
          5 6        -> 3
        11 10 13       -> 5
        15 11 18 16      -> 1
         */
        //DP[r,i] = Math.min(DP[r-1,i],DP[r-1,i-1]) + DP[r,i]
        for (int r = 1; r < triangle.size(); r++) {
            List<Integer> beforeRow = triangle.get(r - 1);
            List<Integer> row = triangle.get(r);

            for (int i = 0; i < row.size(); i++) {
                int dp1 = Integer.MAX_VALUE;
                int dp2 = Integer.MAX_VALUE;

                if (i == 0) {
                    dp1 = beforeRow.get(i);
                } else if (i == beforeRow.size()) {
                    dp2 = beforeRow.get(i - 1);
                } else {
                    dp1 = beforeRow.get(i);
                    dp2 = beforeRow.get(i - 1);
                }
                row.set(i, Math.min(dp1, dp2) + row.get(i));
            }
        }

        int ans = Integer.MAX_VALUE;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (Integer num : lastRow) {
            ans = Math.min(num, ans);
        }

        return ans;
    }
}
