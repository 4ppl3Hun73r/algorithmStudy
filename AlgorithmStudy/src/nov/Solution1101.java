package nov;

import model.GridCodec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/surrounded-regions/
public class Solution1101 {
    public void solve(char[][] board) {
        // Array, DFS, BFS, Union Find, Matrix
        // 1 <= board.length <= 200

        // [["X","X","X","X"],
        //  ["X","O","O","X"],
        //  ["X","X","O","X"],
        //  ["X","O","X","X"]]/

        /*
        [["O","X","X","O","X"]
        ,["X","X","X","X","O"]
        ,["X","X","X","O","X"]
        ,["O","X","O","O","O"]
        ,["X","X","O","X","O"]]
         */

        /*
          [[O, X, X, O, X
           [X, X, X, X, O
           [X, X, X, X, X
           [O, X, O, O, O
           [X, X, O, X, O]]
         */

        // DFS - (2, 2) -> (2, 3) true / false -> (3, 3) (?)회색지대면 ture
        System.out.println(Arrays.deepToString(board).replaceAll("],", "\n"));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    List<int[]> step = new ArrayList<>();
                    step.add(new int[]{i, j});
                    boolean result = dfs(board, i, j, step);
                    if (!result) {
                        // 원복
                        for(int[] pos : step) {
                            board[pos[0]][pos[1]] = 'O';
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(board).replaceAll("],", "\n"));

    }

    private boolean dfs(char[][] board, int r, int c, List<int[]> step) {
        if (r < 0 || c < 0 || r == board.length || c == board[0].length) {
            return false;
        }
        if (board[r][c] == 'O') {
            board[r][c] = 'X';
            step.add(new int[]{r, c});
            boolean result = dfs(board, r - 1, c, step) && dfs(board, r + 1, c, step)
                    && dfs(board, r, c - 1, step) && dfs(board, r, c + 1, step);

            return result;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        GridCodec c = new GridCodec();
        Solution1101 s = new Solution1101();

        //s.solve(c.getCharGrid("[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]"));
        //s.solve(c.getCharGrid("[[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]"));
        s.solve(c.getCharGrid("[[\"O\",\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"O\"],[\"X\",\"O\",\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\",\"O\",\"O\"],[\"X\",\"X\",\"O\",\"X\",\"O\"]]"));
    }
}

// (좌 -> 우)
// [ 0, 0, 0, 0 ]
// [ 0, 1, 2, 0 ]
// [ 0, 0, 1, 0 ]
// [ 0, 1, 0, 0 ]

// (우 -> 좌)
// [ 0, 0, 0, 0 ]
// [ 0, 2, 1, 0 ]
// [ 0, 0, 1, 0 ]
// [ 0, 1, 0, 0 ]

// (상-> 하)
// [ 0, 0, 0, 0 ]
// [ 0, 1, 1, 0 ]
// [ 0, 0, 2, 0 ]
// [ 0, 1, 0, 0 ]

// (하-> 상)
// [ 0, 0, 0, 0 ]
// [ 0, 1, 2, 0 ]
// [ 0, 0, 1, 0 ]
// [ 0, 1, 0, 0 ]

// min -> ??
// [ 0, 0, 0, 0 ]
// [ 0, 1, 1, 0 ]
// [ 0, 0, 1, 0 ]
// [ 0, 1, 0, 0 ]