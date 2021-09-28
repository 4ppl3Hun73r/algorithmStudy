package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3988/
public class Solution0927 {
    // Array, Math, Bit Manipulation, Matrix
    // 실패 ㅠㅠ
    public int movesToChessboard(int[][] board) {
        int len = board.length;
        boolean even = (len % 2) == 0;
        int start = board[0][0];

        // 유효한가는
        // len 가 짝수면 1, 0의 개숫가 len / 2
        // len 가 홀수면 1, 0의 개숫가 len / 2, len / 2 + 1
        /*
        [1,0,1,0]
        [0,1,0,1]
        [1,0,1,0]
        [0,1,0,1]
         */
        int[] rowCount = new int[len];
        int[] colCount = new int[len];
        for (int i = 0; i < len; i++) { // row
            for (int j = 0; j < len; j++) { // col
                rowCount[i] += board[i][j];
                colCount[i] += board[j][i];
                // colCount[i] += board[i][j];
            }
        }
        int half = len / 2;
        if (even) {
            for (int i = 0; i < len; i++) {
                if (rowCount[i] != half || colCount[i] != half) {
                    return -1;
                }
            }
        } else {
            int cnt1 = half;
            int cnt2 = len - half;
            // 5
            // colcount = (3, 3, 3, 2, 2) => cnt1 = 0, cnt2 = 0
            // colcount = (2, 2, 2, 3, 3) => cnt1 = -1, cnt2 = 1
            // cnt1 = 2, cnt2 = 3
            for (int i = 0; i < len; i++) {
                if (colCount[i] == half) cnt1--;
                if (colCount[i] == (len-half)) cnt2--;
            }
            if (!((cnt1 == 0 && cnt2 == 0) || (cnt1 == -1 && cnt2 == 1))) {
                return -1;
            }
            cnt1 = half;
            cnt2 = len - half;
            for (int i = 0; i < len; i++) {
                if (rowCount[i] == half) cnt1--;
                if (rowCount[i] == (len-half)) cnt2--;
            }
            if (!((cnt1 == 0 && cnt2 == 0) || (cnt1 == -1 && cnt2 == 1))) {
                return -1;
            }
            if (cnt1 == 0 && cnt2 == 0) {
                start = 1;//board[0][0] // or 1
            } else {
                start = 0;
            }
        }
        int swap = 0;
        for (int i = 0; i < len; i++) {
            if (board[i][0] != start) {
                // swap 해야함
                int j = i + 1;
                boolean needSwap = false;
                for (; j < len; j+=2) {
                    if (board[j][0] == start) {
                        needSwap = true;
                        break;
                    }
                }
                if (needSwap) {
                    // i < - > j 번째 row를 변경 board[i] board[j]
                    int[] temp = board[i];
                    board[i] = board[j];
                    board[j] = temp;
                    /*for (int k = 0; k < len; k++) {
                        int temp = borad[i][k];
                        borad[i][k] = board[j][k];
                        borad[j][k] = temp;
                    }*/
                    swap++;
                }
            }
            start = (start + 1) % 2;
        }
        start = board[0][0];
        for (int i = 0; i < len; i++) {
            if (board[0][i] != start) {
                // swap 해야함
                int j = i + 1;
                boolean needSwap = false;
                for (; j < len; j+=2) {
                    if (board[0][j] == start) {
                        needSwap = true;
                        break;
                    }
                }
                if (needSwap) {
                    for (int k = 0; k < len; k++) {
                        int temp = board[k][j];
                        board[k][j] = board[k][i];
                        board[k][i] = temp;
                    }
                    swap++;
                }
            }
            start = (start + 1) % 2;
        }

        start = board[0][0];
        for (int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if (board[i][j] != start) {
                    return -1;
                }
                start = (start + 1) % 2;
            }
            if (even) {
                start = (start + 1) % 2;
            }
        }

        return swap;
    }

    // https://leetcode.com/problems/transform-to-chessboard/discuss/114847/C%2B%2BJavaPython-Solution-with-Explanation
    public int movesToChessboardSolution(int[][] b) {
        int N = b.length, rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if ((b[0][0] ^ b[i][0] ^ b[0][j] ^ b[i][j]) == 1) return -1;

        for (int i = 0; i < N; ++i) {
            rowSum += b[0][i];
            colSum += b[i][0];
            if (b[i][0] == i % 2) rowSwap ++;
            if (b[0][i] == i % 2) colSwap ++ ;
        }

        if (rowSum != N / 2 && rowSum != (N + 1) / 2) return -1;
        if (colSum != N / 2 && colSum != (N + 1) / 2) return -1;

        if (N % 2 == 1) { // 홀수판이면
            if (colSwap % 2 == 1) colSwap = N - colSwap;
            if (rowSwap % 2 == 1) rowSwap = N - rowSwap;
        } else {
            colSwap = Math.min(N - colSwap, colSwap);
            rowSwap = Math.min(N - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }

    public static void main(String[] args) {
        Solution0927 s = new Solution0927();
        /*System.out.println(s.movesToChessboard(new int[][]{
                {1,0,1,0},
                {1,0,1,0},
                {0,1,0,1},
                {0,1,0,1}
        }));
        System.out.println(s.movesToChessboard(new int[][]{
                {0,0,0,1,1},
                {0,0,0,1,1},
                {0,0,0,1,1},
                {1,1,1,0,0},
                {1,1,1,0,0}
        }));
        System.out.println(s.movesToChessboard(new int[][]{ // -1
                {1,0,0,1,1},
                {0,1,0,1,0},
                {0,0,0,0,1},
                {1,1,1,0,0},
                {1,1,1,0,0}
        }));

        System.out.println(s.movesToChessboard(new int[][]{ // 답 2
                {1,1,0},
                {0,0,1},
                {0,0,1}
        }));*/

        System.out.println(s.movesToChessboard(new int[][]{ // 답 1, 우리꺼는 -1
                {1,0,0},
                {0,1,1},
                {1,0,0}
        }));
    }

}

/*
교체는
 N이 짝수일때와 N이 홀수 일때로 나눠서 처
 [[1,0],
  [1,0]]

[1,0,1]
[0,1,0]
[0,1,0]

[1,0,1,0]
[1,0,1,0]
[1,0,1,0]
[1,0,1,0]


[1,0,1,0]
[0,1,0,1]
[1,0,1,0]
[0,1,0,1]
---------
[0,1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1,0]

[0,1,0,1]
[0,1,0,1]
[1,0,1,0]
[1,0,1,0]

[0,0,1,1] => not valid
[1,0,1,0]
[0,1,0,1]
[1,1,0,0]

 */