package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int j = 1; j < triangle.size(); j++) {
            List<Integer> before = triangle.get(j - 1);
            List<Integer> row = triangle.get(j);

            int rowLen = row.size();
            for (int i = 0; i < rowLen; i++) {
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if (i == 0) {
                    a = before.get(0);
                } else if (i == rowLen - 1) {
                    b = before.get(before.size() - 1);
                } else {
                    a = before.get(i - 1);
                    b = before.get(i);
                }
                row.set(i, row.get(i) + Math.min(a, b));
            }
        }

        int result = Integer.MAX_VALUE;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i : lastRow) {
            result = Math.min(result, i);
        }
        //System.out.println(Arrays.deepToString(dp));

        return result;

    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(2));
        arr.add(Arrays.asList(3, 4));
        arr.add(Arrays.asList(6, 5, 7));
        arr.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(t.minimumTotal(arr));
    }

    /*
      2
     3 4
    6 5 7
         0
        0 0
    0 (0, 1) 1
     */



}
