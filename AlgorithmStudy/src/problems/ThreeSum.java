package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // 정렬 해줘야함. 정렬시 O(NlogN)
        // 탐색 O(N^2) => 정렬해도 크게 상관없음
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    List<Integer> threeSum = new ArrayList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[lo]);
                    threeSum.add(nums[hi]);
                    result.add(threeSum);
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (sum < target){
                    lo++;
                } else {
                    hi--;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) throws Exception {
        ThreeSum t = new ThreeSum();
        System.out.println(t.threeSum(new int[]{1,-1,-1,0}));
    }
}
