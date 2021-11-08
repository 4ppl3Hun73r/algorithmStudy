package nov;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/unique-binary-search-trees/submissions/
public class Solution1108 {
    public int numTrees(int n) {
        // n 개로 만들수 있는 모든 조합의 수
        // 1 -> 2 -> 3
        // DP 문제
        // 1, 2, 3, 4, 5
        // 2, 3, 4, 5
        // dp[1] = 1
        // dp[2] = dp[1] + dp[1] 가 루트 노드인 것들 아니?
        // dp[3] = dp[2] + 3가 루트 노드인 것들 아니? - 3 -2
        /*
        dp[1]
        dp[2]
        dp[3] => 1이 루트인 노드 + 2가 루트인 노드 + 3이 루트인 노드
        2가 루트인 노드 = 1이 루트인 노드 * 3이 루트인 노드 + dp[2]

            0  - 1  -> null도 노드?
            1  - 1
            2  - 2    root 가 n 개
            3  - 5    dp[2] * 2 + 1             dp[1]*dp[1]      + dp[3]                        dp[2]       dp[2]       dp[3]
            4  - 14   dp[3] * 2 + 4             dp[0]dp[3] + dp[1]*dp[2] + dp[2]*dp[1] + dp[3]dp[0]                 1234 1243 (1324) 1423 1432 | 2134 2143 | 3124 3214 | 4123 4132 (4213) 4321 4312
            5  - 42   dp[4] * 2 + 14            dp[0]dp[4] + dp[1]*dp[3] + dp[2]*dp[2] + dp[3]dp[1] + dp[4]dp[0]
            6  - 132  dp[5] * 2 + 48            14 + 5 + 4 + 5 + 14 => 42
            7  - 429
            8  - 1430
            9  - 4862
            10  - 16796
            11  - 58786
            12  - 208012
            13  - 742900
            14  - 2674440
            15  - 9694845
            16  - 35357670
            17  - 129644790
            18  - 477638700
            19  - 1767263190
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // i = 3
                // j = 1, 2, 3
                // j = 1 2*0
                // j = 2 1*1
                // j = 3 0*2
                // 0*2, 1*1, 2*0
                dp[i] += dp[i - j]*dp[j - 1];
            }
        }

        return dp[n];
    }

    Map<String, Integer> cache = new HashMap<>();
    // sep.Solution0903.generateTrees
    public int numTreesJiho(int n) {
        return tree(1, n);
    }

    private int tree(int start, int end) {
        String key = start + "," + end;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int cnt = 0;

        if (start > end) {
            cnt ++;
            cache.put(key, cnt);
            return cnt;
        }

        if (start == end) {
            cnt ++;
            cache.put(key, cnt);
            return cnt;
        }

        for (int i = start; i <= end; i++) {
            // 1,2,3,4,5,6
            // 1
            int left = tree(start, i - 1);
            int right = tree(i + 1, end);
            cnt += left * right;
        }
        cache.put(key, cnt);

        return cnt;
    }

}
