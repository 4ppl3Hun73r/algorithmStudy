package y2021.sep;

import java.util.*;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3970/
public class Solution0911 {

    public int numberOfArithmeticSlices(int[] nums) {
        // [2, 4, 6, 8, 10]
        // 2 -> 2, 4, 6
        // 2 -> 2, 4, 6, 8
        // 2 -> 2, 4, 6, 8, 10
        // 2 -> 2, 6, 10
        // 4 -> 4, 6, 8
        // 4 -> 4, 6, 8, 10
        // 6 -> 6, 8, 10

        // 2 ->

        /*
        dp[i][diff] += if (arr[i] - arr[i - 1] == diff) dp[i - 1][diff]
         */
        Map<Integer, Integer[]> diffMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = nums[i] - nums[j]; // numsi+2 - numsi+1 = numsi+1 - numsi
                // diffMap.getOrDefault(diff, 0);
                // 0 index -> diffMap.put(d, ??
                // 1 index -> diffMap
                // 2 index -> diffMap
                // diffMap.get(d)

                // [2, 4, 8, 6, 4, 10]
                // [2, 4, 8, 6, 4, 10]
                // 2 -> (0,2), (1,4) , (1,4), (3,6) , (2,8), (5,10)
                //   -> (0,2), (1,4) , (2,8), (3,6), (5,10) ->
            }
        }

        // map<nums[i], index[]>
        // nums[i] -nums[j] -> nums[j] + diff
        // j < index[] -> 답 하나 완성, 답 하나 더 완성 => [i, j, k, k + diff, k + 2diif ] -> [j, k, m] => 2
        // dp[i][k] = 1, dp[j][m] = dp[i][j] + 1
        // dp[i][m] = 2
        // [i, j, k] -> [j, k, m] => 2
        // 2, 4, 6, 8, 10]
        // dp[i, j] = dp[j, k] + dp[i][j] + 1;
        // dp[2][4] = 2 + 0 + 1;
        // dp[4, 6] = 1 + 0 + 1;
        // dp[6, 8] = 1;
        // 3개?


        int result = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = i + 1; j < len; j++) {
                int diff = nums[i] - nums[j];
                for (int k = j + 1; k < len - 1; k++) {
                    if (nums[j] - nums[k] == diff) {
                        cnt ++;
                        if (cnt >= 3 ) {
                            result++;
                        }
                    }
                }
            }
        }



        return 0;
    }

    public int jiho(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int result = 0;

        Map<Long, List<Integer>> numsIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = (long)nums[i];
            List<Integer> l = numsIndexMap.computeIfAbsent(num, t -> new ArrayList<>());
            l.add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                reDp(nums, numsIndexMap, dp, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return result;
    }

    private void reDp(int[] nums, Map<Long, List<Integer>> numsIndexMap, int[][] dp, int i, int j) {
        long diff = (long)nums[j] - (long)nums[i];
        long target = nums[j] + diff;

        if (numsIndexMap.containsKey(target)) {
            for (int k : numsIndexMap.get(target)) {
                if (k < j) {
                    reDp(nums, numsIndexMap, dp, j, k);
                    dp[i][j] += dp[j][k] + 1;
                }
                /*if (k > j) {
                    reDp(nums, numsIndexMap, dp, j, k);
                    dp[i][j] += dp[k][j] + 1;
                }*/
            }
        }
    }

    public int jiho2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int result = 0;

        Map<Long, List<Integer>> numsIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = (long)nums[i];
            List<Integer> l = numsIndexMap.computeIfAbsent(num, t -> new ArrayList<>());
            l.add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2 * (long)nums[j] - nums[i]; // i 가 더 큰값
                // dp[i][j] => dp[i][j] + dp[j][k] + 1;
                if (numsIndexMap.containsKey(target)) {
                    for (int k : numsIndexMap.get(target)) {
                        if (k < j) {
                            dp[i][j] += (dp[j][k] + 1);
                        }
                    }
                }
                //result += dp[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return result;
    }

    public static void main(String[] args) {
        Solution0911 s = new Solution0911();

        System.out.println(s.jiho2(new int[]{2, 4, 6, 8, 10}));
        System.out.println(s.jiho2(new int[]{1, 1, 2, 3, 4, 5}));
        System.out.println(s.jiho2(new int[]{7, 7, 7, 7, 7}));
        System.out.println(s.jiho2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }


    public int sb(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                find(nums, diff, j, 2);
            }
        }
        return 0;
    }

    public int find(int[] nums, int diff, int start, int count) {
        for (int k = start; k < nums.length; k++) {
            int kDiff = nums[k] - nums[start];
            if (kDiff == diff) {
                find(nums, diff, k, count + 1);
            }
        }
        return 0;
    }


    // dp[i][diff] += if (arr[i] - arr[i - 1] == diff) dp[i - 1][diff]
    //
    // dp[i][diff]
    //
    // solution
    public int solution(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)nums[i] - (long)nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                System.out.println(String.format("diff : %d, sum : %d, origin: %d", diff, sum, origin));
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
            System.out.println(cnt[i]);
        }
        // gg..... T.T
        // 오늘은 패배했다.
        // [2, 4, 6, 8, 10]
        // cnt[0] =
        // cnt[1] = {-2, 1}
        // cnt[2] = {-2, 2}, {-4, 1}
        // cnt[3] = {-2, 3}
        // sum = 0
        // origin = 0


        return (int)ans;
    }

}
