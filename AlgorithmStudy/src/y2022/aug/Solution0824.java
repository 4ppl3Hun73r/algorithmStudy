package y2022.aug;

import java.util.HashSet;
import java.util.Set;

public class Solution0824 {
    public boolean isPowerOfThree(int n) {
        if ( n < 1 ) {
            return false;
        }

        Set<Long> powerOfFourSet = new HashSet<>();

        long pow = 0;
        for (int i = 0; pow < n; i++) {
            pow = (long)Math.pow(3, i);
            //System.out.println(pow);
            powerOfFourSet.add(pow);
        }

        return powerOfFourSet.contains((long)n);
    }
}
