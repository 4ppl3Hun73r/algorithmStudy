package problems;

import model.GridCodec;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {
    // TODO 푸는중
    public void solveSudoku(char[][] board) {
        List<Integer> oneNine = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Set<Integer>[][] subBoxes = new Set[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                subBoxes[i][j] = new HashSet<>(oneNine);
            }
        }
        Set<Integer>[] cols = new Set[9];
        Set<Integer>[] rows = new Set[9];
        for (int i = 0; i < 9; i++) {
            cols[i] = new HashSet<>(oneNine);
            rows[i] = new HashSet<>(oneNine);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    removeNum(subBoxes, rows, cols, num, i, j);
                }
            }
        }

        boolean all = false;
        while (!all) {
            all = true;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        all = false;
                        Set<Integer> candidate = new HashSet<>(oneNine);
                        candidate.retainAll(subBoxes[i / 3][j / 3]);
                        candidate.retainAll(cols[j]);
                        candidate.retainAll(rows[i]);

                        if (candidate.size() == 1) {
                            int num = candidate.iterator().next();
                            board[i][j] = (char)('0' + num);
                            removeNum(subBoxes, rows, cols, num, i, j);
                        } // 여기 좀.. 이상하긴 한데, 하나만 찍고 탐색해야함.
                    }
                }
            }
            System.out.println(Arrays.deepToString(board).replaceAll("],", "\n"));
        }
    }

    private boolean removeNum(Set<Integer>[][] subBoxes, Set<Integer>[] rows, Set<Integer>[] cols, int num, int i, int j) {
        if (!subBoxes[i / 3][j / 3].remove(num)) {
            return false;
        }
        if (!rows[i].remove(num)) {
            return false;
        }
        if (!cols[j].remove(num)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        GridCodec g = new GridCodec();

        char[][] board = g.getCharGrid("[[\".\",\".\",\"9\",\"7\",\"4\",\"8\",\".\",\".\",\".\"],[\"7\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"1\",\".\",\"9\",\".\",\".\",\".\"],[\".\",\".\",\"7\",\".\",\".\",\".\",\"2\",\"4\",\".\"],[\".\",\"6\",\"4\",\".\",\"1\",\".\",\"5\",\"9\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\"3\",\".\",\".\"],[\".\",\".\",\".\",\"8\",\".\",\"3\",\".\",\"2\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"6\"],[\".\",\".\",\".\",\"2\",\"7\",\"5\",\"9\",\".\",\".\"]]");
        s.solveSudoku(board);
        System.out.println(Arrays.deepToString(board).replaceAll("],", "\n"));
/*
        char[][] board = g.getCharGrid("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        s.solveSudoku(board);
        System.out.println(Arrays.deepToString(board).replaceAll("],", "\n"));*/
    }
}
