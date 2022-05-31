package y2022.may;

// https://leetcode.com/problems/number-of-1-bits/
public class Solution0526 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //return Integer.bitCount(n);
        String s = Integer.toBinaryString(n);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('1' == s.charAt(i)) {
                ans++;
            }
        }

        int count = 0;
        while(n != 0) {
            //This expression will make the least significant bit (LSB) as 0.
            //For eg -> 13 = 1101
            //          12 = 1100
            // will give ->  1000
            // Hence the Time complexity would also be optimized because it will
            // only check the number of 1's rather than going to every index.
            n = n & (n-1);
            /*
            111
            110

            110
            101

            100
            011

            000
             */
            count++;
        }

        return ans;
    }
}
