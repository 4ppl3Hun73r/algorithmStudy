package aug;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3957/
public class Solution0831 {
    public int maxCount(int m, int n, int[][] ops) {
        // ops[][]
        return 0;
    }

    // m = 39999;
    // n = 39999;
    // ops = new int[][] {{19999, 19999}};
    // count = minx * miny
    /*
    -> 40000, 40000, []
     */
    public int maxCount_mem_exceed(int m, int n, int[][] ops) {

        int[][] input = new int[m][n];

        int max = Integer.MIN_VALUE;
        for (int[] op : ops) {
            int row = op[0];
            int column = op[1];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int val = ++input[i][j];
                    max = Math.max(val, max);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = input[i][j];

                if (val < max) {
                    break;
                }
                count++;
            }
        }

        return count;
    }

    /*
    var maxCount = function(m, n, ops) {
        let row = [];
        let col = [];

        for (let i = 0; i < m; i++) {
            row[i] = 0;
        }
        for (let i = 0; i < n; i++) {
            col[i] = 0;
        }

        for (let i = 0; i < ops.length; i++) {
            let r = ops[i][0];
            let c = ops[i][1];

            for (let j = 0; j < r; j++) {
                row[j]++;
            }
            for (let j = 0; j < c; j++) {
                col[j]++;
            }
        }

        let max = row[0];
        let resultX = 0;
        let resultY = 0;
        for (let i = 0; i < m; i++) {
            if (row[i] !== max) break;
            resultX ++;
        }
        for (let i = 0; i < n; i++) {
            if (col[i] !== max) break;
            resultY ++;
        }

        return resultX * resultY;
    };

    var maxCount = function(m, n, ops) {

        let rowMax = m;
        let colMax = n;

        for (let i = 0; i < ops.length; i++) {
            let r = ops[i][0];
            let c = ops[i][1];
            rowMax = Math.min(r, rowMax);
            colMax = Math.min(c, colMax);
        }

        return rowMax * colMax;
    };
     */
}
