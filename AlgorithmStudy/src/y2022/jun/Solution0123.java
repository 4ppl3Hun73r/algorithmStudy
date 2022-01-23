package y2022.jun;

import java.util.ArrayList;
import java.util.List;

public class Solution0123 {
    public List<Integer> sequentialDigits(int low, int high) {
        /*
        10
        2자리 : 12, 23, 34, 45, 56, 67, 78, 89
        3자리 : 123, 234, 345, 456, 567, 678, 789
        4자리 : 1234, 2345, 3456, 4567, 5678, 6789
        5자리 : 12345, 23456, 34567, 45678, 56789
        6자리 : 123456, 234567, 345678, 456789
        7자리 : 1234567, 2345678, 3456789
        8자리 : 12345678, 23456789
        9자리 : 123456789
        1000000000
         */

        int[] preCalc = new int[]{12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,123456,234567,345678,456789,1234567,2345678,3456789,12345678,23456789,123456789};

        List<Integer> result = new ArrayList<>();
        for (int n : preCalc) {
            if (low <= n && n <= high) {
                result.add(n);
            }
        }

        return result;
    }
}
