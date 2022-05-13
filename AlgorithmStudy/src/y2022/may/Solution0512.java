package y2022.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class Solution0512 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[8];

        Arrays.sort(nums);
        permute(nums, visited, new ArrayList<>(), result);

        return result;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> subList, List<List<Integer>> result) {
        if (subList.size() == nums.length) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ( i > 0 && visited[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                subList.add(nums[i]);

                permute(nums, visited, subList, result);

                subList.remove(subList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
