package y2022.feb;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class Solution0209 {
    public int findPairs(int[] nums, int k) {
        /*
         0 <= i < j < nums.length
         |nums[i] - nums[j]| == k
         pair의 수

         이거 조건이 좀 이상한게, i < j 인데
         3,1,4,1,5
         example 보면 (1, 3) 이 답으로 나옴
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairCnt = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) {
                    pairCnt++;
                }
            } else {
                if (map.containsKey(k + num)) {
                    pairCnt++;
                }
            }
        }


        return pairCnt;
    }

    public static void main(String[] args) {
        Solution0209 s = new Solution0209();
        System.out.println(s.findPairs(new int[]{3,1,4,1,5}, 2));
        System.out.println(s.findPairs(new int[]{1,2,3,4,5}, 1));
        System.out.println(s.findPairs(new int[]{1,3,1,5,4}, 0));

    }
}
