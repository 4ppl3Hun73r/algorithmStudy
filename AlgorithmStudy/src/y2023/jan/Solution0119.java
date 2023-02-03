package y2023.jan;

import java.util.Arrays;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class Solution0119 {
    public int subarraysDivByKTimeLimit(int[] nums, int k) {
        // [4,5,0,-2,-3,1]
        // [4][..]
        // [4,5][..]
        // [4,5,0][..]
        // [5][...]
        // [0][...]
        // ... [4, 0, 1] -> X

        /*
            [4,5,0]
            [4][5][0]
            [4,5],[5,0]
            [4,5,0]

            k 를 5라고 했을 때
            [4] -> 4%5 -> 4
            [9] -> 9%5 -> 4
            [9] -> 9%5 -> 4

            4,5,0,-2,-3,1

            (0 + 4) % 5


         */

        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        prefixSum[0] = nums[0];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            // p[j] - p[i] -> (i ~ j sum)
            // (0, 1] -> 8 - 4;
            // (0, 2] -> 13 - 4; => 9
        }
        //System.out.println(Arrays.toString(prefixSum));

        // 2 % k == 1
        // 0 1 2 3 4 5 6 7 8 9
        // ^     ^


        int result = 0;
        // 0 ~ N
        // 0 ~ N
        for (int i = 0; i < len; i++) { // inclusive
            for (int j = i + 1; j <= len; j++) { // exclusive
                int subArraySum = prefixSum[j] - prefixSum[i];
                if (subArraySum % k == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixMod = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;
//[4,4] => 1
        for (int num: nums) {
            // Take modulo twice to avoid negative remainders.
            prefixMod = (prefixMod + num % k + k) % k; // 0 + 4 + 5 % 5 = 4, 4 + 5 % 5 = 4 ,
            // Add the count of subarrays that have the same remainder as the current
            // one to cancel out the remainders.
            result += modGroups[prefixMod]; //mod[4] = 0, 1
            modGroups[prefixMod]++; //mod[4] = 1, 2,
            System.out.println(prefixMod);
            System.out.println(Arrays.toString(modGroups));
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution0119 s = new Solution0119();

        System.out.println(s.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));

        /*Random r = new Random();

        System.out.print("[");
        for (int i = 0; i < 30000; i++) {
            System.out.print(r.nextInt(10000));
            System.out.print(",");
        }
        System.out.print("]");*/


    }
}
