package y2022.aug;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/power-of-four/
public class Solution0822 {
    public boolean isPowerOfFour(int n) {
        /*
            n == 4^x 인지 확인
            follow up : loop / resursion 을 쓰지 않고 풀기


            1, 4, 16, 32, ....
         */
        if ( n < 1 ) {
            return false;
        }

        Set<Long> powerOfFourSet = new HashSet<>();

        long pow = 0;
        for (int i = 0; pow < n; i++) {
            pow = (long)Math.pow(4, i);
            System.out.println(pow);
            powerOfFourSet.add(pow);
        }

        return powerOfFourSet.contains((long)n);
    }

    public static void main(String[] args) throws Exception {
        Solution0822 s = new Solution0822();

        System.out.println(s.isPowerOfFour(2147483647));
    }
}
