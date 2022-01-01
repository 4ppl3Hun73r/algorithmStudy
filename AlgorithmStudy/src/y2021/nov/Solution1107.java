package y2021.nov;

import java.util.Arrays;

// https://leetcode.com/problems/multiply-strings/
public class Solution1107 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len = num1.length() + num2.length();
        int[] mul = new int[len];
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int m = (n1 * n2) + mul[j + i + 1]; // carry 값 더하기
                System.out.println(j + i);
                mul[j + i] += m / 10;
                mul[j + i + 1] = m % 10;
                System.out.println(Arrays.toString(mul));
            }
        }

        for (int i = 0; i < mul.length; i++) {
            if (sb.length() == 0 && mul[i] == 0) {
                continue;
            }
            sb.append(mul[i]);
        }

        /*
        0 - 0 = 0
        0 - 1 = 1
        0 - 2 = 2
        1 - 0 = 1
        1 - 1 = 2
        1 - 2 = 3
        // 56088
         */


        /*
         123 * 456
             456
             123
             ---
              18
             12
             6
             15
            10
           5
            12
            8
           4
         */


        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1107 s = new Solution1107();
        System.out.println(s.multiply("123", "456"));

    }
}
