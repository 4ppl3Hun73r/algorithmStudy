package problems;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num < min2) {
                min2 = num;
            } else if (num > min2) {
                return true;
            }
        }

        return false;
    }
}
