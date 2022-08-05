package y2022.aug;

import java.util.Arrays;

// https://leetcode.com/problems/combination-sum-iv/
public class Solution0805 {
    int ans;
    int[] dp;

    public int combinationSum4(int[] nums, int target) {
        /*
        중복 허용.
        nums 는 uniq
        nums = [1,2,3], target = 4
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)

        3 -> num(3)

        [2,1,3]
        35


        4 - 1 => 3 ( 111,12,21,3)

        dp ->
        [ 1][ 1][ 1][  ]

        dp[값] = 계산값;


         */
        ans = 0;
        dp = new int[2000];
        Arrays.sort(nums);
        Arrays.fill(dp, -1);

        // { -1,-2,-3,-4,5} target 1

        /*
        dp[n] -> n까지 조합 수

        dp[1] => 1
        dp[2] => 2, 1 + 1
        */

        //combination(nums, target);

        return calc(nums, target);
    }

    private void combination(int[] nums, int target) {
        if (target == 0) {
            ans++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int newTarget = target - num;

            if (newTarget < 0) {
                break;
            }

            combination(nums, newTarget);
        }
    }
    private int calc(int[] nums, int target) {
        System.out.println("target" + target);
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int value = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int newTarget = target - num;

            if (newTarget < 0) {
                break;
            }
            value += calc(nums, newTarget);
        }

        dp[target] = value;
        System.out.println(Arrays.toString(dp));
        /*
        1,2,3

        4 ->  3, -> 2
                 -> 1
                 -> 0
              2,
              1,

         target 를 nums 에서 찾는거니까.
         */

        return value;
    }

    public static void main(String[] args) throws Exception {
        Solution0805 s = new Solution0805();

        System.out.println(s.combinationSum4(new int[]{-1, 1,2,3}, 4));
    }
}
