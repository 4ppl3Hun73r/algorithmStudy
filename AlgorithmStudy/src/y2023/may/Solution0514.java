package y2023.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximize-score-after-n-operations/
public class Solution0514 {
    // https://leetcode.com/problems/maximize-score-after-n-operations/solutions/1118875/java-bitmask-dp-explaination/
    public int maxScore(int[] nums) {
        /*

        n * 2 크기의 nums 에서

        1base의 i 번 oper
        두개를 골라서 i * gcd(x, y)


        (1 * gcd(x, y)) + (2 * gcd(x, y)) + ...

        최소 gcd => 최대 gcd 순을 가면 되는데..
        모든 gcd를 다 구한다?


        1 < n < 7
        배열 크기가 크지 않음 == 전체 탐색 해야 함.

        dp[i][x][y] = i * gcd(x, y) 일때 최대 값

        bitmasking 으로 정리 -> 연산 편의를 위헤
         */
        // gcd 구하기
        Map<Integer, Integer> gcdMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                gcdMap.put((1 << i) + (1 << j), gcd(nums[i], nums[j]));
            }
        }

        int[] dp = new int[1 << nums.length]; // 엄청 큰 dp 배열 만들기
        for (int i = 0; i < dp.length; i++) {
            int bits = Integer.bitCount(i);
            if (bits % 2 != 0) {
                continue;
            }

            for (Integer key : gcdMap.keySet()) {
                if ((key & i) != 0) {
                    continue;
                }
                dp[key ^ i] = Math.max(dp[key ^ i], dp[i] + gcdMap.get(key) * (bits / 2 + 1));
            }
        }

        System.out.println(gcdMap);
        System.out.println(Arrays.toString(dp));
        /*
        [3,4,6,8]
        [0011, 1] (3,4)
        [0101, 3] (3,6)
        [1001, 1] (3,8)
        [0110, 2] (4,6)
        [1010, 4] (4,8)
        [1100, 2] (6,8)
        dp[16]
        dp[0000] -> skip
        dp[0001] -> skip
        dp[0010] -> skip
        dp[0011]    1 * 2
        dp[0100] -> skip
        dp[0101]
        dp[0110]
        dp[0111] -> skip
        dp[1000] -> skip
        dp[1001]
        dp[1010]
        dp[1011] -> skip
        dp[1100]
        dp[1101] -> skip
        dp[1110] -> skip
        dp[1111]


         */


        return dp[dp.length - 1];
    }

    private int gcd(int a, int b){
        if(b == 0) {
            return a;
        } else{
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) {
        Solution0514 s = new Solution0514();

        System.out.println(s.maxScore(new int[]{3,4,6,8}));
    }
}
