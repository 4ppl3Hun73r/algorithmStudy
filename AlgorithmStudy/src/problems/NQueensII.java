package problems;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    int result = 0;
    Set<Integer> col = new HashSet<>();
    Set<Integer> diagonal1 = new HashSet<>(); // 대각선 \
    Set<Integer> diagonal2 = new HashSet<>(); // 대각선 /


    public int totalNQueens(int n) {
        backtracking(0, n);
        return result;
    }

    void backtracking(int row, int n) {
        if (row == n) {
            result++;
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diagonal1.contains(row + i) || diagonal2.contains(row - i)) {
                continue;
            }

            col.add(i);
            diagonal1.add(row + i);
            diagonal2.add(row - i);
            backtracking(row + 1, n);
            col.remove(i);
            diagonal1.remove(row + i);
            diagonal2.remove(row - i);
        }
    }
}
