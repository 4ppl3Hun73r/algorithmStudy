package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3988/
public class Solution0927 {
    public int movesToChessboard(int[][] board) {
        int len = board.length;
        int rowSum = 0;
        int colSum = 0;
        int rowSwap = 0;
        int colSwap = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; ++j) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < len; ++i) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) rowSwap ++;
            if (board[0][i] == i % 2) colSwap ++ ;
        }
        if (rowSum != len / 2 && rowSum != (len + 1) / 2) return -1;
        if (colSum != len / 2 && colSum != (len + 1) / 2) return -1;

        return 0;
    }

    public static void main(String[] args) {
        Solution0927 s = new Solution0927();
        System.out.println(s.movesToChessboard(new int[][]{
                {1, 0},
                {1, 0}
        }));
    }

}

/*
https://leetcode.com/problems/transform-to-chessboard/discuss/114847/C%2B%2BJavaPython-Solution-with-Explanation
유효한 체스판은
 010101 -> 101010 이 쌍으로 존재 해야함 (row / col) 모두
 0011 => valid
 1100
 1100
 0011
 0011 => not valid
 1100
 1100
 1010

 N * N 의 체스판에서
 N = 2K (짝수) 이면 K개의 1과 0이 존재
 N = 2K + 1(홀수) 이면 K개의 1, K + 1개의 0 or K + 1개의 1 or K개의 0 이 존재해야함

교체는
 N이 짝수일때와 N이 홀수 일때로 나눠서 처

 [[1,0],
  [1,0]]


 */