package y2021.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class Solution1028 {

    public List<List<Integer>> threeSum(int[] nums) {
        // Two Sum, Two Point, Sorting
        // [-1,0,1,2,-1,-4]
        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (0 < i && nums[i] == nums[i - 1]) continue;
            // 정렬이 O(nlogn) < O(n^2) 니까 정렬 해도 된다.
            int low = i + 1;
            int hi = nums.length - 1;
            int target = -nums[i];
            while (low < hi) { // O(n^2) 보다 작은 시간 복잡도
                // nums[i] + nums[low] + nums[hi]
                int sum = nums[low] + nums[hi];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[hi]));
                    low++;
                    hi--;
                    // 중복 제거를 원하는데
                    // [-4,-1,-1,-1,0,1,1,1,1,1,1,2]
                    //      i
                    //              lh
                    while (low < hi && nums[low - 1] == nums[low]) low++;
                    while (low < hi && nums[hi + 1] == nums[hi]) hi--;
                } else if (sum < target) {
                    low++;
                } else {
                    hi--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution1028 s = new Solution1028();
        System.out.println(s.threeSum(new int[]{}));
        System.out.println(s.threeSum(new int[]{0}));
        System.out.println(s.threeSum(new int[]{0, 1}));
        System.out.println(s.threeSum(new int[]{0, 1, 2}));
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(s.threeSum(new int[]{-4, -1, -1, -1, 0, 1, 1, 1, 1, 1, 1, 2}));
    }
}
