package y2022.feb;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class Solution0210 {
    public int subarraySum(int[] nums, int k) {
        /*
        dp[0] = n[0]
        dp[1] = dp[0] + n[0]
        dp[2] = dp[1] + n[1]
        dp[3] = dp[2] + n[2]
        ..
        dp[i] = dp[i - 1] + n [i - 1]


        dp[0] = n[0]
        dp[1] = n[0] + n[0]
        dp[2] = n[0] + n[0] + n[1]
        dp[3] = n[0] + n[0] + n[1] + n[2]
        ..
        dp[i] = n[0] + n[0] + n[1] + n[2] + ... + n[i - 1]

        x < y
        dp[1] - dp[0] = (n[0] + n[0]) - (n[0]) => n[0]
        dp[2] - dp[0] = (n[0] + n[0] + n[1]) - (n[0]) => n[0] + n[1]
        dp[3] - dp[0] = (n[0] + n[0] + n[1] + n[2]) - (n[0]) => n[0] + n[1] + n[2]
        dp[3] - dp[1] = (n[0] + n[0] + n[1] + n[2]) - (n[0] + n[0]) => n[1] + n[2]
        dp[3] - dp[2] = (n[0] + n[0] + n[1] + n[2]) - (n[0] + n[0] + n[1]) => n[2]

        dp[y] - dp[x] = y ~ x 까지의 연속된 subarray의 합
         */

        int len = nums.length;
        // 계산의 편의를 위해서 0번째 인덱스의 값을 포함시켜놓음
        int[] prefixSum = new int[len + 1];
        prefixSum[0] = nums[0];
        for (int i = 1; i <= len ; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int cnt = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (k == (prefixSum[j] - prefixSum[i])) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    /*
        문제 푼게 속도가 너무 많이 나와서
        빠르게 푼 답을 보니 map으로 처리
     */
    public int subarraySumUsingMap(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        /*
        Map => {0, 1}
         {n[0], 1}
         {n[0] + n[1], 1}
         {n[0] + n[1] + n[2], 1}
         {...}
         {n[0] + n[1] + n[2] + ... + n[n], 1}

         (n[0] + n[1] + n[2]) - k 가 containsKey라면
         (n[0] + n[1] + n[2]) - k = (n[0] + n[1]) 처럼 연속된 sum 값일 수 밖에 없음
         (n[0] + n[1] + n[2]) - (n[0] + n[1]) = k 가 되게 된다.
         즉 n[2] == k 가 되게 됨 이를 좀더 위에 처럼 풀면

         x < y
        (n[0] + n[1] + ... + n[y]) - k = (n[0] + n[1] + ... + n[x])
        k = (n[0] + n[1] + ... + n[y]) - (n[0] + n[1] + ... + n[x])
        k = n[y] + ... + n[x - 1] 이 된다.
        이는 x-1 < y 까지의 subarray 임을 알 수 있다.
         */

        return result;
    }
}
