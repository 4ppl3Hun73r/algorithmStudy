package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);

        combination(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void combination(int[] candidates, int start, int target, List<Integer> subResult) {
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
        }
        if (target < 0) {
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            subResult.add(candidates[i]);
            combination(candidates, i + 1, target - candidates[i], subResult);
            subResult.remove(subResult.size() - 1);
        }
    }

}
