package y2021.aug;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3918/
public class Solution0826 {

    public boolean judgeSquareSum(int c) {
        //  1 <= root(c + 1) <= Math.sqrt(2^31)
        // a^2 + b^2 = c

        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b - ((int) b) == 0) { // b
                return true;
            }
        }

        // 2147483646

        return false;
    }

    // fermat
    public boolean judgeSquareSumWithFermat(int c) {
        // a^2 + b^2 = c 할때
        // c의 소인수는 (4k + 3) 의 수가 양수이다.
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
/*
    public static double sqrt(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0 || !(x < Double.POSITIVE_INFINITY))
            return x;

        // Normalize x.
        long bits = Double.doubleToLongBits(x);
        int exp = (int) (bits >> 52);
        if (exp == 0) // Subnormal x.
        {
            x *= TWO_54;
            bits = Double.doubleToLongBits(x);
            exp = (int) (bits >> 52) - 54;
        }
        exp -= 1023; // Unbias exponent.
        bits = (bits & 0x000fffffffffffffL) | 0x0010000000000000L;
        if ((exp & 1) == 1) // Odd exp, double x to make it even.
            bits <<= 1;
        exp >>= 1;

        // Generate sqrt(x) bit by bit.
        bits <<= 1;
        long q = 0;
        long s = 0;
        long r = 0x0020000000000000L; // Move r right to left.
        while (r != 0) {
            long t = s + r;
            if (t <= bits) {
                s = t + r;
                bits -= t;
                q += r;
            }
            bits <<= 1;
            r >>= 1;
        }

        // Use floating add to round correctly.
        if (bits != 0)
            q += q & 1;
        return Double.longBitsToDouble((q >> 1) + ((exp + 1022L) << 52));
    }*/

}


/**
 * 1 = 1^2 + 0^2
 * 2 = 1^2 + 1^2
 * 3 = false
 * 4 = 2^2 + 2^2
 */