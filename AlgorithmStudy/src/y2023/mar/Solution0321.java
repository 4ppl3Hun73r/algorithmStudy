package y2023.mar;

// https://leetcode.com/problems/number-of-zero-filled-subarrays/
public class Solution0321 {
    public long zeroFilledSubarray(int[] nums) {
        long numSubarray = 0;
        long ans = 0;
        for (int num : nums) {
            if (num == 0) {
                numSubarray++;
            } else {
                numSubarray = 0;
            }
            ans += numSubarray;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0321 s = new Solution0321();

        System.out.println(s.zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
    }
}
