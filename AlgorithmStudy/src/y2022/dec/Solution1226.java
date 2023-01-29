package y2022.dec;

// https://leetcode.com/problems/jump-game/
public class Solution1226 {
    public boolean canJump(int[] nums) {
        // dp[i][]
        if (nums.length == 1) {
            return true;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            // 0만 찾아서 건너 뛰면 됨
            if (nums[i] == 0) {
                // 0으로밖에 올수 없는지 확인하면 됨
                int check = 1;
                while (check > nums[i]) {
                    check++;
                    i--;
                    if(i < 0) return false;
                }
            }
        }

        return true;
    }
}
