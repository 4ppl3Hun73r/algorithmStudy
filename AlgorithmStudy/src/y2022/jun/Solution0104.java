package y2022.jun;

// https://leetcode.com/problems/complement-of-base-10-integer/
public class Solution0104 {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        long xor = 1;
        while (xor <= n) {
            xor *= 2;
        }

        xor = xor - 1;

        return n^(int)xor;

    }
}
