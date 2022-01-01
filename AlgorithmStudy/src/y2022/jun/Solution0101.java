package y2022.jun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// https://leetcode.com/problems/burst-balloons/
public class Solution0101 {

    /*
     * 답보고 품.
     */
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        int len = 1;
        for (int num : nums) {
            newNums[len++] = num;
        }
        // 양쪽에 1 채우기
        newNums[0] = 1;
        newNums[len++] = 1;
        System.out.println(Arrays.toString(newNums));
        int[][] dp = new int[len][len];
        for (int i = 2; i < len; i++) {
            for (int left = 0; left < len - i; left++) {
                // [3,1,5,8]-> [1,3,1,5,8,1]
                //              l       ^
                int right = left + i;
                // [1,3,1,5,8,1]
                //  l   r
                for (int j = left + 1; j < right; j++) {
                    // j 번째가 가장 먼저 터지는게 아니라, j번째가 가장 마지막에 터지는 걸로(역으로) 접근
                    dp[left][right] = Math.max(dp[left][right],
                            newNums[left] * newNums[j] * newNums[right] + dp[left][j] + dp[j][right]
                            );
                }
            }
        }

        return dp[0][len - 1];
    }


    /*
      계산이 너무 복잡하고 예외 케이스가 많아져서
      모든 걸 코딩할수 없기에 실패
     */
    public int maxCoinsFail(int[] nums) {
        /*
         3,1,5,8
         [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
         coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

         1, 5 : 10
         [1, 5] -->
         1  * 5  + 1 * 5 * 1 = 10

         n == 500
         0 <= nums[i] <= 100

         먼저 계산을 해 놓기?
         [3,15,40,40]
         [3/1*5, 40 / 1 * 3, 40]
          [15, 120, 40]
         [15/5*8, 40/5*3]
          [24,24]
         [24/3]
          [8]

         DP문제군...
         [a, b, c, d, e, f, g]
         dp[0] = a * b
         dp[1] = a * b * c
         dp[2] = b * c * d
         dp[3] = c * d * e
         dp[4] = d * e * f
         dp[5] = e * f * g
         dp[6] = f * g


         [3,1,5,8]
         [3,15,40,40]
          3, [5, 40, 40]
          15 [15, 120, 40]
          40 [3, 3, 8]
          40 [3, 15, 5]

         특정 값을 제거 했을때 왼쪽 * 오른쪽 값이 제일 큰 지점을 제거하면 된다.
         dp[n] => 양쪽 곱한 값 dp[n - 1] * dp [n + 1]
         dp[0] => 이걸 최대 500 * 500 반복?

         dp[0]a = 1 * b
         dp[1]b = a * c => a * d
         dp[2]c = b * d
         dp[3]d = c * e => b * e
         dp[4]e = d * f
         dp[5]f = e * g
         dp[6]g = f * 1

         dp[0]3 = 3 => 15
         dp[1]1 = 15 =>
         dp[2]5 = 8 => 24
         dp[3]8 = 5

         dp[0]3 = 0 => 15
         dp[1]0 = 15
         dp[2]5 = 0 => 15
         dp[3]8 = 5

         */
        List<Integer> dp = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1;
            int right = i + 1;
            if (left < 0) left = 1;
            else left = nums[left];

            if (right == nums.length) right = 1;
            else right = nums[right];

            dp.add(left * right);
            numList.add(nums[i]);
        }

        int result = 0;
        while(dp.size() != 0) {
            int max = 0;
            int maxPos = 0;
            for (int i = 0; i < dp.size(); i++) {
                int val = dp.get(i);
                if (val > max) {
                    max = val;
                    maxPos = i;
                } else if (val == max) {
                    // 같으면 조건에 따라서 변경해야함.
                    // 주변 값이 더 큰걸로 가야함.
                }
            }
            int val = numList.get(maxPos);
            int prevPos = maxPos - 1;
            int nextPos = maxPos + 1;
            int prev = 1;
            int next = 1;
            if (prevPos >= 0) {
                prev = numList.get(prevPos);
            }
            if (nextPos != numList.size()) {
                next = numList.get(nextPos);
            }

            if (val != 0) {
                if (prevPos >= 0) {
                    dp.set(prevPos, dp.get(prevPos) / val * next);
                }
                if (nextPos != numList.size()) {
                    dp.set(nextPos, dp.get(nextPos) / val * prev);
                }
            } else {
                if (prevPos >= 0) {
                    dp.set(prevPos, numList.get(prevPos) * next);
                }
                if (nextPos != numList.size()) {
                    dp.set(nextPos, numList.get(nextPos) * prev);
                }
            }
            result += numList.remove(maxPos) * dp.remove(maxPos);
        }

        return result;
    }
    public static void main(String[] args) {
        Solution0101 s = new Solution0101();

        System.out.println(s.maxCoins(new int[]{3,1,5,8}));
        System.out.println(s.maxCoins(new int[]{3,0,5,8}));

        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            System.out.print(random.nextInt(100));
            System.out.print(",");
        }
    }
}
