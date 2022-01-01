package y2021.nov;


import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
public class Solution1116 {

    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // x = m * n / 1 ~ m => 수가 row에서 작은것들 찾는거
            // x =
            count += Math.min(x / i, n); // x / i = y, y * i =
            System.out.println(String.format("x : %d, m : %d, n : %d, k : %d, x/i: %d, count : %d", x, m, n, k, x / i, count));
        }
        // Grid안에서 '지정한 값'보다 작은 Cell의 수 => count
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        /*
        [1, 2, 3
         2, 4, 6
         3, 6, 9
         [1, 2, 2, 3, 3, 4, 6, 6, 9]
         */
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            // Grid 안에서 찾는게 아니라 1 ~ 9 사이에서 찾기
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
            System.out.println(String.format("hi : %d", hi));
        }
        return lo;
    }

    public int findKthNumberFail(int m, int n, int k) {
        /*
        Binary Search
        3, 3, 5
        [1, 2, 3
         2, 4, 6
         3, 6, 9

         [1, 2, 2, 3, 3, 4, 6, 6, 9]
         [(1,1), (1,2), (2,1), (1,3), (3,1), (2,2), (2,3), (3,2), (3,3)]

         [1, 2, 2, 3, 3, 4, 4, 4, 6, 6, 8, 8, 9, 12, 12, 16]
         [(1,1), (1,2), (2,1), (1,3), (3,1), (1,4), (4,1), (2,2), (2,3), (3,2), (2,4), (4,2), (3,3), (3,4), (4,3), (4,4)]
            P    |------------------6-------------------|    P    [-----------4------------|    P   |------2----|    P

        [[1, 2, 3
         [2, 4, 6]]
         [1, 2, 2, 3, 4, 6]
         [(1,1), (1,2), (2,1), (1,3), (2,2), (2,3)]

         [[1, 2, 3, 4, 5
         [2, 4, 6, 8, 10]]
        [1, 2, 2, 3, 4, 4, 5, 6, 8, 10]
        [(1,1), (1,2), (2,1) (1,3), (1,4) (2,2), (1,5), (2,3), (2,4), (2,5)]

         // (N, N) 에서 (N+1, N+1) 사이를 기준으로 수량 계산?

                   n=m
                    1
                   / \
                  2    2    => 2^1 ~ 2^2 - 1
                /  \  / \
               3   4  3  4   => 2^2 ~ 2^3 - 1번째수 수
              / \  / \/ \/ \


         */

        // 4*4 : 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16
        // 3*4 : 1 2 2 3 3 4 4 6 6 8 9 12            (2*4 3 6 9 12)
        // 2*4 : 1 2 2 3 4 4 6 8                     (1*4 2 4 6 8)
        // 1*4 : 1 2 3 4

        // k번째 값이어서. mid => (m/2*n/2) 보다 작거나 같음 (m+n) = k ?
        // 1 <= k <= m * n
        // max = n * m;

        /*
        [[1, 2, 3
            [2, 4, 6
               [3, 6, 9]]
        [1, 2, 2, 3, 3, 4, 6, 6, 9]

        [[1, 2, 3, 4
            [2, 4, 6, 8
               [3, 6, 9, 12
                  [4, 8, 12, 16]]
        [1, 2, 2, 3, 3, 4, 4, 4, 6, 6, 8, 8, 9, 12, 12, 16]

        [[1, 2, 3, 4, 5
            [2, 4, 6, 8, 10]]
        [1, 2, 2, 3, 4, 4, 5, 6, 8, 10]

        // m = 4 , n = 4
        [[  1( 1, 1),   2( 1, 2),   3( 1, 3),   4( 1, 4)
                     [  2( 2, 1),   4( 2, 2),   6( 2, 3),   8( 2, 4)
                                 [  3( 3, 1),   6( 3, 2),   9( 3, 3),  12( 3, 4)
                                             [  4( 4, 1),   8( 4, 2),  12( 4, 3),  16( 4, 4)]]
               2           3           4          5            6          7            8
               1           2           3          4            3          2            1
        // m = 3 , n = 4
        [[  1( 1, 1),   2( 1, 2),   3( 1, 3),   4( 1, 4)
                     [  2( 2, 1),   4( 2, 2),   6( 2, 3),   8( 2, 4)
                                 [  3( 3, 1),   6( 3, 2),   9( 3, 3),  12( 3, 4)
               2           3           4          5            6          7
               1           2           3          3            2          1
               1           3           6          9            11         12
         */

        int[] group = new int[m + n - 1];
        group[0] = 1;
        int inc = 1;
        int min = Math.min(m, n);
        for (int i = 1; i < group.length; i++) {
            group[i] = group[i - 1] + inc;
            if (group[i] == min) {
                inc = 0;
            }
            if (group[i] == min && group[i - 1] == min) {
                inc = -1;
            }
        }
        System.out.println(Arrays.toString(group));

        return 0;
    }

    private void printGrid(int m, int n) {
        Cell[][] grid = new Cell[m][n];
        Cell[] flat = new Cell[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Cell((i + 1) * (j + 1), i + 1, j + 1);
                flat[idx++] = grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(grid).replaceAll("],", "\n"));
        //System.out.println(Arrays.toString(flat));
        Arrays.sort(flat, Comparator.comparingInt(a -> a.val));
        System.out.println(Arrays.toString(flat));
    }
    class Cell {
        int val;
        int x;
        int y;

        public Cell(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%3d(%2d,%2d)", val, x, y);
            // return String.format("%d", val);
            // return String.format("(%2d,%2d)", x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        Solution1116 solution1116 = new Solution1116();
        solution1116.findKthNumber(3, 3, 5);
        //solution1116.findKthNumber(1, 4, 2);
        //solution1116.findKthNumber(4, 1, 2);
        /*solution1116.printGrid(3, 3);
        solution1116.printGrid(4, 4);
        solution1116.printGrid(2, 5);
        solution1116.printGrid(10, 10);*/
        // solution1116.printGrid(30000, 30000); OOM
    }
}
