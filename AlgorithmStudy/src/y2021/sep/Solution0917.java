package y2021.sep;

import java.util.ArrayList;
import java.util.List;

public class Solution0917 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int maxLen = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(maxLen);

        int col = 0;
        int row = 0;
        int boundColMin = 0;
        int boundColMax = matrix[0].length - 1;
        int boundRowMin = 1;
        int boundRowMax = matrix.length - 1;
        int direction = 0; // 0 is right, 1 is down, 2 is left, 3 is up
        if (boundColMax == 0) direction = 1;
        for (int i = 0; i < maxLen; i++) {
            // System.out.println(direction + " : " + row + ", " + col);
            result.add(matrix[row][col]);
            if (direction == 0) {
                col++;
                if (col == boundColMax) {
                    direction = 1;
                    boundColMax--;
                }
            } else if (direction == 1) {
                row++;
                if (row == boundRowMax) {
                    direction = 2;
                    boundRowMax--;
                }
            } else if (direction == 2) {
                col--;
                if (col == boundColMin) {
                    direction = 3;
                    boundColMin ++;
                }
            } else if (direction == 3) {
                row--;
                if (row == boundRowMin) {
                    direction = 0;
                    boundRowMin++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution0917 s = new Solution0917();
        //[1,2,3]
        //[4,5,6]
        //[7,8,9]
        System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        // 1,2,3,6,9,8,7,4,5

        System.out.println(s.spiralOrder(new int[][]{{2},{3}}));
    }
}
