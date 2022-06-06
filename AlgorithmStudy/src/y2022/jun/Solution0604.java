package y2022.jun;

import java.util.*;

// https://leetcode.com/problems/n-queens/
public class Solution0604 {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> diagonal1 = new HashSet<>(); // 대각선 \
    Set<Integer> diagonal2 = new HashSet<>(); // 대각선 /


    public List<List<String>> solveNQueens(int n) {


        backtracking(0, n, new ArrayList<>());

        return result;
    }

    void backtracking(int row, int n, List<String> rows) {
        if (row == n) {
            result.add(new ArrayList<>(rows));
            return ;
        }

        char[] r = new char[n];
        Arrays.fill(r, '.');
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || diagonal1.contains(row + i) || diagonal2.contains(row - i)) {
                continue;
            }

            r[i] = 'Q';
            rows.add(new String(r));

            col.add(i);
            diagonal1.add(row + i);
            diagonal2.add(row - i);


            backtracking(row + 1, n, rows);
            rows.remove(rows.size() - 1);
            col.remove(i);
            diagonal1.remove(row + i);
            diagonal2.remove(row - i);
            r[i] = '.';
        }
    }


}
