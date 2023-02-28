package y2023.feb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0215 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int n = num[i];

            int lk = k % 10;
            k = k / 10;

            int sum = n + lk + carry;

            carry = sum / 10;
            result.add(sum % 10);
        }

        while (k != 0) {
            int lk = k % 10;
            k = k / 10;

            int sum = lk + carry;

            carry = sum / 10;
            result.add(sum % 10);
        }

        if (carry != 0) {
            result.add(carry);
        }

        Collections.reverse(result);

        return result;
    }
}
