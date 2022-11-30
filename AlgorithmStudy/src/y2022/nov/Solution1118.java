package y2022.nov;

// https://leetcode.com/problems/ugly-number/
public class Solution1118 {
    public boolean isUgly(int n) {
        /*
        An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
        Given an integer n, return true if n is an ugly number.
         */
        if (n <= 0) {
            return false;
        }

        int[] factors = new int[]{2, 3, 5};
        int i = 0;
        while (i < 3) {
            if (n % factors[i] == 0) {
                n /= factors[i];
            } else {
                i++;
            }
        }

        return n == 1;
    }
}
