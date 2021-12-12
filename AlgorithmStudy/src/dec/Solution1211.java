package dec;

// https://leetcode.com/problems/nth-magical-number/
public class Solution1211 {
    public int nthMagicalNumber(int n, int a, int b) {
        int m = (int) (1e9) + 7;
        /*
        n = 5;
        a = 2
        b = 4

        2 4 6 8 10
        2 2 * 2 or 4 / 2 * 3 /

        1, 2, 5, 20

        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        ^                                                ^ (5 * 4)
                                ^
        2, 4, 6, 8, 10,

        2 * 1, 2 * 2, 2 * 3, 2 * 4, 2 * 5 .....
        4 * 1, 4 * 2, 4 * 3, 4 * 4, 4 * 5 .....
        2 <= a, b <= 400000

        n = 1, n = 10000000000
         */

        long left = 1;
        long right = (long)(Math.min(a, b)) * n;
        int lcm = a * b / gcd(a, b);

        while (left < right) {
            long mid = left + (right - left) / 2;
            // mid = (left + right) / 2
            long cnt = (mid / a) + (mid / b) - (mid / lcm);
            System.out.printf("left %d, right %d, mid : %d, a : %d, b : %d, lcm : %d, %d, cnt : %d\n", left, right, mid, (mid / a), (mid / b), (mid / lcm), lcm, cnt);
            if (cnt < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // System.out.println(400000L * 10000000000L);

        return (int)(left%m);
    }

    int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) {
        Solution1211 s = new Solution1211();

        //System.out.println(s.nthMagicalNumber(1, 5, 4));
        //System.out.println(s.nthMagicalNumber(5, 2, 4));
        System.out.println(s.nthMagicalNumber(1000000000, 39999, 40000)); // 999860007
    }

}
