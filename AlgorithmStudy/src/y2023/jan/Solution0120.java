package y2023.jan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/non-decreasing-subsequences/
public class Solution0120 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<String> cache = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> numList = new ArrayList<>();
            numList.add(nums[i]);
            find(i + 1, nums, numList, cache);
        }

        return result;
    }

    private void find(int idx, int[] nums, List<Integer> numList, Set<String> cache) {
        for (int i = idx; i < nums.length; i++) {
            if (numList.get(numList.size() - 1) <= nums[i]) {
                numList.add(nums[i]);
                String key = numList.toString();
                if (!cache.contains(key)) {
                    result.add(new ArrayList<>(numList));
                    cache.add(key);
                    find(i + 1, nums, numList, cache);
                }
                numList.remove(numList.size() - 1);
            }
        }
    } // bit?
    // arraylist -> StringBuffer -> arraylist

    // 4 6 7 -> 4 6 7 7 -> 7 pop -> 2번쨰 7 pop -> push 7 (3개)
/*


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    private void backtrack(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((path.size() >= 1 && nums[i] < path.get(path.size() - 1)) || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }*/

    public static void main(String[] args) throws Exception {
        Solution0120 s = new Solution0120();

        System.out.println(s.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
