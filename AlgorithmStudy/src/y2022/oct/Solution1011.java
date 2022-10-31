package y2022.oct;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class Solution1011 {

    public boolean increasingTriplet(int[] nums) {
        // i < j < k 가 존재하면 true, 아니면 false
        /*

        [2,1,5,0,4,6] MAX_VALUE
                      i j k
         i            j k
           i          j k
             j        k
               i      k
                 j    k
                   k
         */

        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= i) {
                i = num;
            } else if (num <= j) {
                j = num;
            } else if (num > j) { // j < k
                return true;
            }
        }

        return false;
    }
}
