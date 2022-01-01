package y2021.dec;

// https://leetcode.com/problems/power-of-two/
public class Solution1221 {
    public boolean isPowerOfTwo(int n) {

        if (n < 1) {
            return false;
        }

        return (n & n - 1) == 0;
    }
}
