package y2022.mar;

import java.util.Random;

// https://leetcode.com/problems/split-array-largest-sum/
public class Solution0331 {
    public int splitArray(int[] nums, int m) {
        // Greedy, DP, Binary Search?????????
        /*
         7, 2 5 10 8
         7 2, 5 10 8
         7 2 5, 10 8
         7 2 5 10, 8

         1 <= nums.length <= 1000
         5P2
         5C2

         nums => i ~ j ~ k -> 2
         dp[i][j] = i + j
         dp[j+1][k] = j + 1 + k
         prefix sum -> 배열은 빠르게 만들 수 있지 않을까?

         길이가 k -> 9 , 3, k - 2 , m = 3
        */
        int left = 0;
        int right = 0; // 합 더한거.
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        while (left < right) {
            // return target;
            int mid = left + (right - left) / 2;
            System.out.println("left : " + left + ", right : " + right + ", mid : " + mid);

            // 1,2,3,4,5,6,7,8,9, 10 -> 0 ~ 55 -> mid -> 27정도?
            // mid 값으로 배열을 쪼개서 찾기. 배송되는 일자를 찾기
            int d = 1; // days = 5, 2 < 5
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (cnt + nums[i] > mid ) {
                    d++;
                    cnt = 0;
                }
                cnt += nums[i];
            }

            boolean check = d <= m; // days로 검증? 찾는?
            if (check) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    public int shipWithinDays(int[] weights, int days) {
        // 1,2,3,4,5,6,7,8,9,10, days 5
        // 15
        /*
        binary search 는
        정렬 되어 있는 배열에서 left ~ right 에서 target을 찾는데, mid 기준으로 찾아 나가는 알고리듬
            days에 모든 물건이 선적될수 있도록 하는데
            모든 날을 다 써야 되고 최소 용적량 = (담을 수 있는 무게의 최대값)
         */

        int left = 0;
        int right = 0; // 합 더한거.
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left < right) {
            // return target;
            int mid = left + (right - left) / 2;
            System.out.println("left : " + left + ", right : " + right + ", mid : " + mid);

            // 1,2,3,4,5,6,7,8,9, 10 -> 0 ~ 55 -> mid -> 27정도?
            // mid 값으로 배열을 쪼개서 찾기. 배송되는 일자를 찾기
            int d = 1; // days = 5, 2 < 5
            int cnt = 0;
            for (int i = 0; i < weights.length; i++) {
                if (cnt + weights[i] > mid ) {
                    d++;
                    cnt = 0;
                }
                cnt += weights[i];
            }

            boolean check = d <= days; // days로 검증? 찾는?
            if (check) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left; // return right;
    }

    public static void main(String[] args) throws Exception {
        Solution0331 s = new Solution0331();

        System.out.println(s.shipWithinDays(new int[]{1,2,3,4,5,6 ,7,8,9, 10}, 5)); // 15
        System.out.println(s.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(s.shipWithinDays(new int[]{1,2,3,1,1}, 4)); // 3 ????
        //System.out.println(s.splitArray(new int[]{7,2,5,10,8}, 2));

        Random r = new Random();
    }


    Integer[][] memo = new Integer[1001][51];
    private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount) {
        int n = prefixSum.length - 1;

        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][subarrayCount] != null) {
            return memo[currIndex][subarrayCount];
        }

        // Base Case: If there is only one subarray left, then all of the remaining numbers
        // must go in the current subarray. So return the sum of the remaining numbers.
        if (subarrayCount == 1) {
            return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
        }

        // Otherwise, use the recurrence relation to determine the minimum largest subarray
        // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currIndex; i <= n - subarrayCount; i++) {
            // Store the sum of the first subarray.
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

            // Find the maximum subarray sum for the current first split.
            int largestSplitSum = Math.max(firstSplitSum,
                    getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1));

            // Find the minimum among all possible combinations.
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);

            if (firstSplitSum >= minimumLargestSplitSum) {
                break;
            }
        }

        return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
    }

    public int splitArrayDP(int[] nums, int m) {
        // Store the prefix sum of nums array.
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return getMinimumLargestSplitSum(prefixSum, 0, m);
    }
}
