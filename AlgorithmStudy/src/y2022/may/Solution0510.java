package y2022.may;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class Solution0510 {
    List<List<Integer>> ans =  new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        /*
        1,2,3,4,5,6,7,8,9 중 k개를 사용해서
        n을 만드는 모든 조합을 반환
         */
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        combination(nums, 0, n, k, 0, new ArrayList<>());
        return ans;
    }

    private void combination(int[] nums, int current, int target, int step, int pos, List<Integer> subAnswer) {
        if (current > target || step < 0) {
            return;
        }
        if (current == target && step == 0) {
            ans.add(new ArrayList<>(subAnswer));
            return;
        }
        for(int i = pos; i < 9; i++) {
            subAnswer.add(nums[i]);
            combination(nums, current + nums[i], target, step - 1, i + 1, subAnswer);
            subAnswer.remove(subAnswer.size() - 1);
        }
    }
}
