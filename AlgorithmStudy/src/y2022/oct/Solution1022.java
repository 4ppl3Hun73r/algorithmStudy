package y2022.oct;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/
public class Solution1022 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();

        // sliding
        for (int i = 0; i < nums.length; i++) {
            //  * * * (i - k) * * *
            //System.out.println(set);

            int j = i - k - 1;
            if (j >= 0) {
                set.remove(nums[j]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        //abs(i - j) <= k. 0, 1, 2 (k == 2)

        return false;
    }

    public static void main(String[] args) throws Exception {
        Solution1022 s = new Solution1022();

        //System.out.println(s.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
