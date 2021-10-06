package oct;

import java.util.Arrays;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3993/
public class Solution1001 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // k 개의 subset 으로 나눠질수 있으면 true 아니면 false
        // 단 모든 subset 은 동일한 sum 을 가져야함.

        // nums 를 모두 더하고 k로 나누면 sum(subset) 의 값이 나옴
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // k 로 나눠 떨어지지 않으면 subset을 만들 수 없음
        if (sum%k != 0) {
            return false;
        }
        int target = sum / k;

        // 흐음....
        // [4,3,2,3,5,2,1], target = 5, k = 4
        // [4, 1], [3, 2] [3, 2] [5]
        // [1,2,5,3,2,3,4]
        // [1, 2, 2] [5] [3, -> false
        // [1, 2, 2] -> [5] ->
        // [1, 4] -> [2, 3] -> [5] -> [2, 3] -> true
        // n.length 16;

        boolean[] visited = new boolean[nums.length];
        return findSubSet(nums, 0, visited, k, 0, target);
    }

    private boolean findSubSet(int[] nums, int start, boolean[] visited, int k, int subSum, int target) {
        //System.out.println(String.format("start : %d, visited : %s, k : %d, subSum : %d", start, Arrays.toString(visited), k, subSum));
        if (k == 0) {
            return true; // visited 가 모두 true 인 경우 ? bb
        }
        if (subSum > target)
            return false;
        if (subSum == target) { // [1, 4] 찾았음
            // [2, 3] 찾으라고 탐색
            return findSubSet(nums, 0, visited, k - 1, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                // 다음 서브셋으로 보내고
                // 찾는거.
                // [1 + 4] [1 + 2 + 2] [1 + 1 + 1 + 1 ..]
                if (findSubSet(nums, i + 1, visited, k, subSum + nums[i], target)) // <--
                    return true;
                visited[i] = false;
            }
        }
        // start를 바꿔서 다음 조합을 찾게 하고/
        return false;
    }
    /*
    nums, start, visited, k, subSum, target
    [4,3,2,3,5,2,1], 0, [f,f,f,f,f,f,f], 4, 0, 5
     [4,3,2,3,5,2,1], 0, [t,f,f,f,f,f,f], 4, 4, 5
      [4,3,2,3,5,2,1], 1, [t,t,f,f,f,f,f], 4, 7, 5
      [4,3,2,3,5,2,1], 2, [t,f,t,f,f,f,f], 4, 2, 5
      [4,3,2,3,5,2,1], 3, [t,f,f,t,f,f,f], 4, 3, 5
      [4,3,2,3,5,2,1], 4, [t,f,f,f,t,f,f], 4, 6, 5
      [4,3,2,3,5,2,1], 5, [t,f,f,f,f,t,f], 4, 5, 5
      [4,3,2,3,5,2,1], 6, [t,f,f,f,f,f,t], 4, 5, 5 => 하나의 서브셋이 완성 되고 bb
       [4,3,2,3,5,2,1], 0, [t,f,f,f,f,f,t], 3, 0, 5
       [4,3,2,3,5,2,1], 1, [t,t,f,f,f,f,t], 3, 3, 5
        [4,3,2,3,5,2,1], 1, [t,t,t,f,f,f,t], 3, 3, 5 => 다른 서브셋 완성
          [4,3,2,3,5,2,1], 0, [t,t,t,t,f,t,t], 1, 3, 5 => 다른 서브셋 완성
          [4,3,2,3,5,2,1], 0, [t,t,t,t,t,t,t], 0, 3, 5 => 다른 서브셋 완성
    */
    public static void main(String[] args) {
        Solution1001 s = new Solution1001();
        // System.out.println(s.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
        System.out.println(s.canPartitionKSubsets(new int[]{1,2,5,3,2,3,4}, 4));
        /*System.out.println(s.canPartitionKSubsets(new int[]{1,2,5,3,2,3,4,4,3,2,3,5,2,1}, 4));
        System.out.println(s.canPartitionKSubsets(new int[]{1,2,5,3,2,3,4}, 4));
        System.out.println(s.canPartitionKSubsets(new int[]{1,2,3,4,5}, 3));*/
    }
}

/*

subset : [1 ~ 4] 까지의 길이
1 <= k <= nums.length <= 16



 */