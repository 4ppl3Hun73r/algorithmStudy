package y2021.nov;

// https://leetcode.com/problems/arranging-coins/
public class Solution1105 {

    public int arrangeCoins(int n) {
        // 1  1
        // 2  3
        // 3  6
        // 4  10
        // 5  15
        // 6  21
        // 7  28 = c(c+1) / 2
        // 8  36
        // 9  45
        //10  55 = r * (r + 1) / 2

        // n = 1, r = 1
        // n = 3, r = 2
        // n = 6, r = 3

        // n = r * (r + 1) / 2
        // 2n = r

        // start, end
        // r = 1, r = 2^15
        // 1 <= n <= 2^31 - 1
        // r의 최대값?
        // start <= n <= end, end - 1 2147483647
        // r = 65535

        int start = 1;
        int end = 65535;
        while (start <= end) {
            int mid = (start + end) / 2;
            long m = ((long) mid * ((long)mid + 1)) / 2;
            if (m == n) {
                return mid;
            }
            if (m < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end; // ?????
    }

    int math(int n) {
        int del =(int) Math.floor( Math.sqrt(1 + 8*(long)n));

        // return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);

        return (-1 + del)/2;
    }

    int bruteForce(int n) {
        long sum = 0L;
        int count = 0;
        for (int i=1; i < 65536; i++) {
            sum = sum + i;
            if (sum > n) { // n <= m < n + 1
                break;
            } // 최대 65535
            count = i;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Solution1105 s = new Solution1105();

        System.out.println(s.arrangeCoins(1804289383)); //60070
        // 65535
    }

}
