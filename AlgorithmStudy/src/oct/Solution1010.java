package oct;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/
public class Solution1010 {

    public int rangeBitwiseAnd(int left, int right) {
        int result = right;

        while (right > left) {
            result = right & (right - 1);
            // left : 1 , right 7
            // 0001
            // 0010
            // 0011
            // 0100
            // 0101
            // 0110
            // 0111
            // 7 ^ 6 => 0110 -> 6
            // 6 ^ 5 => 0100 -> 4
            // 4 ^ 3 => 0000 -> 0

            right = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution1010 s = new Solution1010();

        System.out.println(s.rangeBitwiseAnd(5, 7));
        System.out.println(s.rangeBitwiseAnd(1, 7));

    }
}

/*
 [5, 7]
 101
 110
 111

 1111111111111111111111111111111
 0000000000000000000000000000001
 0000000000000000000000000000010
 0

 */
