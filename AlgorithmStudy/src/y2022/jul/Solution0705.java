package y2022.jul;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class Solution0705 {
    public int longestConsecutive(int[] nums) {
        /*
        정렬 안된 배열이 제공됨
        가장 긴 연속된 값들의 길이를 구하라
        [100,4,200,1,3,2] -> 1,2,3,4 -> 4

        O(n) time 으로 처리해야함 (정렬 X)

        0 <= nums.length <= 100000
        -1000000000 <= nums[i] <= 1000000000

        오늘 오디오가 별로군요.네 ㅠㅠ

        100

        200

        1 - 2 - 3 - 4

        Union Find
         */
        int ans = 0;

        Map<Integer, Integer> numPosMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numPosMap.put(nums[i], i);
        }

        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[numPosMap.get(nums[i])] = true;
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            int length = 1;
            while (numPosMap.containsKey(left) && !visited[numPosMap.get(left)]) {
                visited[numPosMap.get(left)] = true;
                left--;
                length++;
            }
            while (numPosMap.containsKey(right) && !visited[numPosMap.get(right)]) {
                visited[numPosMap.get(right)] = true;
                right++;
                length++;

            }
            ans = Math.max(ans, length);
        }


        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0705 s = new Solution0705();

        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
