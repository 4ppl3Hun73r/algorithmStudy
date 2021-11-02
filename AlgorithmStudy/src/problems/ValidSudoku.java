package problems;

import model.GridCodec;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
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
                    if (!removeNum(subBoxes, rows, cols, num, i, j)) {
                        return false;
                    }
                }
            }
        }

        /*
        이번 문제에서는 완전히 풀수 있는지는 확인할 필요 없음
        이거 확인하다가 한번 틀렸네 ㅠ
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    Set<Integer> candidate = new HashSet<>(oneNine);
                    candidate.retainAll(subBoxes[i / 3][j / 3]);
                    candidate.retainAll(cols[j]);
                    candidate.retainAll(rows[i]);

                    if (candidate.isEmpty()) {
                        return false;
                    }
                    if (candidate.size() == 1) {
                        if (!removeNum(subBoxes, rows, cols, candidate.iterator().next(), i, j)) {
                            return false;
                        }
                    }
                }
            }
        }
        */

        return true;
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

    public static void main(String[] args) throws Exception {
        ValidSudoku v = new ValidSudoku();
        GridCodec c = new GridCodec();
        System.out.println(v.isValidSudoku(c.getCharGrid("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]")));
        System.out.println(v.isValidSudoku(c.getCharGrid("[[\".\",\"8\",\"7\",\"6\",\"5\",\"4\",\"3\",\"2\",\"1\"],[\"2\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"3\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"4\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"5\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"7\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"8\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\"9\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]")));
    }
}
