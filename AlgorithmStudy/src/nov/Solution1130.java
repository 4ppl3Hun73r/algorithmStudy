package nov;

public class Solution1130 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }

        int[][] left = new int[row + 1][col];
        int[][] right = new int[row + 1][col];
        int[][] height = new int[row][col];

        for (int i = 0; i < col; i++) {
            right[0][i] = col;
        }

        for (int i = 1; i <= row; i++) {
            // left
            int leftPos = 0;
            for (int j = 0; j < col; j++) {
                if (matrix[i - 1][j] == '1') {
                    // 왼쪽 설정
                    left[i][j] = Math.max(left[i - 1][j], leftPos);
                } else {
                    leftPos = j + 1;
                }
            }

            // right
            int rightPos = col;
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i - 1][j] == '1') {
                    // 오른쪽 끝 위치 설정
                    right[i][j] = Math.min(right[i - 1][j], rightPos);
                } else {
                    // 오른쪽 끝 재설정
                    right[i][j] = col;
                    rightPos = j;
                }
            }
        }

        int max = 0;
        for (int j = 0; j < col; j++) {
            int cnt = 1;
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == '1') {
                    height[i][j] = cnt++;
                    // 높이를 구하면서 크기도 계산

                    max = Math.max((right[i + 1][j] - left[i + 1][j]) * height[i][j], max);
                } else {
                    cnt = 1;
                }
            }

        }

        //System.out.println(Arrays.deepToString(left).replaceAll("],", "\n"));
        //System.out.println(Arrays.deepToString(right).replaceAll("],", "\n"));
        //System.out.println(Arrays.deepToString(height).replaceAll("],", "\n"));

        return max;
    }

    public static void main(String[] args) throws Exception {
        Solution1130 s = new Solution1130();
        System.out.println(s.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
