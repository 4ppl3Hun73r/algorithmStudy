package y2022.nov;

// https://leetcode.com/problems/where-will-the-ball-fall/
public class Solution1101 {
    public int[] findBall(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;

        int result[] = new int[cLen];
        for (int i = 0; i < cLen; i++) {
            int currentCol = i;
            for (int j = 0; j < rLen; j++) {
                int next = currentCol + grid[j][currentCol];
                if (next < 0 || next >= cLen || grid[j][currentCol] != grid[j][next]) {
                    result[i] = -1;
                    break;
                }
                result[i] = next;
                currentCol = next;
            }
        }

        return result;

    }
}
