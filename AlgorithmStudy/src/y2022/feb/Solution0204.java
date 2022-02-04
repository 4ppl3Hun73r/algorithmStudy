package y2022.feb;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/
public class Solution0204 {
    public int findMaxLength(int[] nums) {
        /*
        0,1 -> 2
        0,1,0 -> 2
        0,0,0,0,0 -> 0

        1,0,1,0,0,1,0,1,0,1,0,1,0,1,0 -> 14
        1,0,0,0,1,0,0,1 -> 4

        [0,[0,[0, [0,1] ,1],1],1] -> 8

        i ~ j 안에 0과 1의 숫자가 (j - i) / 2 이면 subarray
        subarray 중 가장 긴거를 찾아라.

          1,0,0,0,1,0,0,1 -> 4
        0 0 1 2 3 3 4 5 5
        1 1 1 1 1 2 2 2 3
          5 5 4 3 2 2 1 0
          3 2 2 2 2 1 1 1

        [0, 1, 2, 3,  4,  5]
        [0, 1, 3, 6, 10, 15]

        [0-5] 합 -> p[5]
        [4-5] 합 -> p[5] - p[3]
        [2-4] 합 -> p[4] - p[1]

        0 1 2 3 4 5 6 7(idx)
        1,0,0,0,1,0,0,1
        1,1,1,1,2,2,2,3

        0 1  2  3  4  5  6  7
        1,0,-1,-2,-1,-2,-3,-2

        1,1,1,0,0,0
     -1 1,2,3,2,1,0

        -1,1,1,-1,1,1,1

        a ~ g = -1 or 1
        [a,b,c,d,e,f,g]
        a + b + c + d = 0 -> subarray // bb 연속된 수의 합이 0이라는 건데
        0이 나온다는 거는 N번 상승하고 N번 하강하는 거
        어느 위치에서든 N번 상승, N번 하강하면 동일한 Y축에 위치하게 되는거
        동일 Y 축에 모인 애들은 a + b + c + d ... n 까지의 조건을 만족시킬수 있고 그렇기 때문에
        n - a => 최장 길이의 subarray 된다.
        -> 그래프로 나타 냈을떄
         */

        // countValue, index
        Map<Integer, Integer> graphIndexMap = new HashMap<>();
        graphIndexMap.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + ((nums[i] == 1) ? 1 : -1);

            if (graphIndexMap.containsKey(count)) {
                maxLen = Math.max(maxLen, i - graphIndexMap.get(count));
            } else {
                graphIndexMap.put(count, i);
            }
        }

        return maxLen;
    }
}
