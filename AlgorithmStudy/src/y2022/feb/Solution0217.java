package y2022.feb;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class Solution0217 {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
        정렬? 하면 좀 쉽나??
        [2,3,4,5,6,7] 10
        [2,2,2,2, ]
        [2,7,6,5,4,3]
         */

        result = new ArrayList<>();
        combination(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void combination(int[] candidates, int start, int target, List<Integer> subResult) {
        if (target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) { // bb
            subResult.add(candidates[i]);
            combination(candidates, i, target - candidates[i], subResult);
            subResult.remove(subResult.size() - 1);
        }
        // O(n * n - 1 * n - 2 ... 1) -> O(N!)
        // dirs = {{1, 0}, {-1, 0}}
    }

    public static void main(String[] args) throws Exception {
        Solution0217 s = new Solution0217();

        System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(s.combinationSum(new int[]{7,6,3,2}, 7));
        System.out.println(s.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(s.combinationSum(new int[]{2}, 1));
    }

}
