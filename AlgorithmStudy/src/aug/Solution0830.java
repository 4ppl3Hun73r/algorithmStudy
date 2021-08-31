package aug;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3956/
public class Solution0830 {
    public int minPatches(int[] nums, int n) {
        /*
          [1, 3]  -> 6
          n -> 1, n -> 배열이라던지, arraylist 하나 만들어 놓고
          [1, 2, 3] -> 1, 3,

          1, 2, (1 + 2), (1 + 3), (2 + 3), (2 + 4) ....

          [1] -> 1
          [2] -> 2
          [1, 2] -> 3
          [1, 2, 3] -> 6
          [1, 2, 3, 4] -> 10

          [1, 5, 10] < 20


         */
        // nums -> 정렬 되어 있다.

        // {1,5,10}
        // 1~20
        // 1, 5, 10, 6, 15, 11, 16
        // 1, 5, 10, 6, 15, 11, 16, 4, 5, 9, 14, 10, 19, 15, 20
        // 1,2,4,5,13,26,52,103,205,
        // 1,2,4,8,16,32,64,128,256,512,1024
        // sum(2^n) =  (2^(n-1) - 1) + 1
        // 2^n(2^(n-1) - 1)/ 2 = ^
        int count = 0; // [1,1]
        // [1, 5, 10], n = 20
        // sum = []

        long sum = 0;
        int i = 0;
        long 기대값 = 1;
        while (sum < n) { //
            if (i < nums.length && nums[i] <= 기대값) { // bb
                sum += nums[i]; // 21
                // x = sum + 1;
                i++;
            } else {
                // System.out.println("x: " + 기대값);
                sum += 기대값; // 3
                count++; // 1
            }
            기대값 = sum + 1; // 11
        } // bbb....

        return count;
    }

    public int dp(int[] nums, int n) {
        boolean[] dp = new boolean[10001];
        dp[0] = true;
        long totalSum = 0L;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 10000; j >= 0; j--) {
                if (j - nums[i] >= 0 && dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
            totalSum += nums[i];
        }
        int patch = 0;
        for (int i = 1; i < 10001 && i <= n; i++) {
            if (!dp[i]) {
                patch++;
                for (int j = Math.min(10000, n); j > i; j--) {
                    if (dp[j - i]) {
                        dp[j] = true;
                    }
                }
                dp[i] = true;
                totalSum += i;
            }
        }

        while (n>10000 && totalSum < n) {
            patch++;
            totalSum += (totalSum + 1);
        }
        return patch;
    }

    public static void main(String[] args) {
        Solution0830 s = new Solution0830();

        /*System.out.println(s.minPatches(new int[]{1, 3}, 6)); // 1
        System.out.println(s.minPatches(new int[]{1,5,10}, 20)); // 2
        System.out.println(s.minPatches(new int[]{1,2,2}, 5)); // 0*/
        System.out.println(s.minPatches(new int[]{1,2,31,32}, 2147483647)); // expect 28: we: 29
    }
}

/*
map <int, int> -> key = sum, value = m?

 * nums = [1, 3], n = 6
 * [1,2] -> [1], [2], [1,2]  -> map
 * [1,2,3] -> [1], [2], [1,2], [1,3], [2,3], [1,2,3] + [3]
 * [1,2,3,4] -> [1], [2], [1,2], [1,3], [2,3], [1,2,3], [3], [1,4], [2,4], [1,2,4], [1,3,4], [2,3,4], [1,2,3,4], [3,4] + [4],
 * [1], [2], [3], [1,3], [2,3], [1,2,3].
 *
 *
 * if add "1" => [1], [3], [1, 3], [1,1,3]
 *                 1, 3, 4, 5
 * if add "2" => [1], [3], [1, 3], [2], [2,3], [2,1,3]
 *                 1, 3, 4, 2, 5, 6
 * if add "3" => [1], [3], [1, 3], [3,3], [1,3,3]
 *                 1, 3, 4, 6, 7
 *
 *
 */

/*
n = 1 => [1]
n = 2 => [1,1]
n = 3 => [1,2] [3]
n = 4 => [1,1,2]
 */