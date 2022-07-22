package y2022.jul;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class Solution0719 {
    public List<List<Integer>> generate(int numRows) {
        /*
        파스칼 삼각형 만들기

           1
          1 1
         1 2 1
        1 3 3 1
       1 4 6 4 1

       1 <= numRows <= 30
         */
        List<List<Integer>> ans = new ArrayList<>();

        //0, N-1 = 1
        //R-1,C-1 + R-1,C = R,C

        // 안들리시나요?
        // 저희는 준연님 말 다 들리고 있었는데요... ㅎㅎ
        // 그래서 저희가 풀었다고 한것도 못 들으셨군요..ㅠㅠㅠ
        //
        List<Integer> row = new ArrayList<>();
        row.add(1);
        ans.add(row);
        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<>();
            List<Integer> prev = ans.get(i - 1);
            for(int j = 0; j <= i; j++) {
                int value = 1;
                if (j != 0 && j != i) {
                    value = prev.get(j - 1) + prev.get(j);
                }
                row.add(value);
            }
            ans.add(row);
        }

        return ans;
    }


    public List<List<Integer>> generate2(int numRows) {
        if (numRows < 1) {
            return List.of();
        }

        final List<List<Integer>> result = new ArrayList();
        List<Integer> row = new ArrayList();

        row.add(1);
        result.add(row);


        for (int i = 1; i < numRows; i++) {
            row = new ArrayList();
            final var prevRow = result.get(i - 1);

            for (int j = 0; j <= i; j++) {
                int val = 0;

                if (j < i) {
                    val += prevRow.get(j);
                }

                if (j - 1 >= 0) {
                    val += prevRow.get(j - 1);
                }

                row.add(val);
            }
            result.add(row);
        }

        return result;
    }
}
