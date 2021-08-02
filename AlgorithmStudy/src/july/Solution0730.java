package july;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3831/
public class Solution0730 {

    public static void main(String[] args) {
        Solution0730 solution0730 = new Solution0730();
        int[][] input = {
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        };
        solution0730.updateMatrix(input);
    }

    // 가장 가까운 0까지의 거리를 구하기
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; // 세로 (행)
        int n = mat[0].length; // 가로 (열)
        Integer[][] updateMat = new Integer[m][n];

        // 지나온 길을 넣는다.
        // 0인 길을
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    updateMat[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else { // 1
                    // 경~ 아무것도 안함 ~축
                    updateMat[i][j] = null;
                }
            }
        }

        // Q : [0,0] [0,1] => 하나씩 뽑아서 상사
        // x, y
        int[][] 상하좌우 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int 원본위치 = mat[cell[0]][cell[1]];

            for (int[] 위치 : 상하좌우) {
                int newX = cell[0] + 위치[0];
                int newY = cell[1] + 위치[1];
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                    continue;
                }
                // 여기서 먼가 함
                Integer 상하좌우중하나 = updateMat[newX][newY]; //x = 1, y =0
                Integer 수정된메트릭스에서원본위치 = updateMat[cell[0]][cell[1]]; // 정환님 대박 !! ~^_^~bb
                if (상하좌우중하나 != null && (상하좌우중하나 == 0 || 상하좌우중하나 <= 수정된메트릭스에서원본위치 + 1)) {
                    continue;
                }
                queue.add(new int[]{newX, newY});
                updateMat[newX][newY] = updateMat[cell[0]][cell[1]] + 1;
            }

            // 로직을 태운다.
        }
        int[][] finalMat = new int[m][n];
        for (int i = 0; i < updateMat.length; i++) {
            for (int j = 0; j < updateMat[i].length; j++) {
                finalMat[i][j] = updateMat[i][j] == null ? 1 : updateMat[i][j];
            }
        }

        return finalMat;


        /**
         * [[0,0,0],[0,1,0],[0,0,0]]
         * [[0,0,0],[0,1,0],[1,1,1]]
         * [[1,1,0],[1,1,1],[1,1,1]]
         *
         * Your answer
         *
         * [[0,0,0],[0,1,0],[0,0,0]]
         * [[0,0,0],[0,1,0],[1,1,1]]
         * [[1,1,0],[1,1,1],[1,1,1]]
         *
         * Expected answer
         * [[0,0,0],[0,1,0],[0,0,0]]
         * [[0,0,0],[0,1,0],[1,2,1]]
         * [[2,1,0],[3,2,1],[4,3,2]]
         */

        //

        // [[1,1,0],[1,1,1],[1,1,1]]
        // mat[][] 값은 0 또는 1
        // [[0,0,0]
        // ,[0,1,0]
        // ,[null,null,null]]
        //
        // [[0,0,0]
        //  [0,0,0]
        //  [0,0,0]

        // '근처(상하좌우)'의 min 값의 + 1

        // findZeroDistance
        // 4 3 2
        // 3 2 1 2
        // 2 1 x 1 2
        //   2 1 2
        //     2

    }

    public int[][] updateMatrix2(int[][] mat) {

        int width = mat[0].length;
        int height = mat.length;
        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    continue;
                }

                result[i][j] = findNear(mat, width, height, i, j);

            }
        }

        return result;
    }

    private int findNear(int[][] mat, int w, int h, int i, int j) {
        int distance = 1;
        int idx = 0;
        while (true) {
            idx++;

            if (j - idx >= 0 && mat[i][j - idx] == 0) {
                return distance;
            }
            if (j + idx <= w - 1 && mat[i][j + idx] == 0) {
                return distance;
            }

            if (i - idx >= 0 && mat[i - idx][j] == 0) {
                return distance;
            }

            if (i + idx <= h - 1 && mat[i + idx][j] == 0) {
                return distance;
            }
            distance++;
            if (j - idx >= 0) {
                if (i - idx >= 0 && mat[i - idx][j - idx] == 0) {
                    return distance;
                }
                if (i + idx <= h - 1 && mat[i + idx][j - idx] == 0) {
                    return distance;
                }
            }

            if ((j + idx <= w - 1)) {
                if (i - idx >= 0 && mat[i - idx][j + idx] == 0) {
                    return distance;
                }
                if (i + idx <= h - 1 && mat[i + idx][j + idx] == 0) {
                    return distance;
                }
            }
        }

    }


}

