package problems;

// https://leetcode.com/problems/concatenation-of-array/
public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len * 2];

        int idx = 0;
        for (int num : nums) {
            ans[idx++] = num;
        }
        for (int num : nums) {
            ans[idx++] = num;
        }

        return ans;
    }
}
