package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        find(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void find(int[] candidates, int start, int target, List<Integer> subResult) {
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
        }
        if (target < 0) {
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            subResult.add(candidates[i]);
            find(candidates, i, target - candidates[i], subResult);
            subResult.remove(subResult.size() - 1);
        }
    }
}
