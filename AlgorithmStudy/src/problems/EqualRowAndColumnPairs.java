package problems;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/equal-row-and-column-pairs/
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> rowCntMap = new HashMap<>();
        int n = grid.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
                sb.append(',');
            }

            String s = sb.toString();
            rowCntMap.put(s, rowCntMap.getOrDefault(s, 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]);
                sb.append(',');
            }

            String s = sb.toString();
            ans += rowCntMap.getOrDefault(s, 0);
        }

        return ans;
    }
}
