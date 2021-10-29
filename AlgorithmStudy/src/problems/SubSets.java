package problems;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            subSet(i, 0, new ArrayList<>(), nums);
        }


        return result;
    }

    private void subSet(int len, int index, List<Integer> subSet, int[] nums) {
        if (len == subSet.size()) {
            result.add(new ArrayList<>(subSet));
            return ;
        }

        for (int i = index; i < nums.length; i++) {
            subSet.add(nums[i]);
            subSet(len, i + 1, subSet, nums);
            subSet.remove(subSet.size() - 1);
        }
    }

}
