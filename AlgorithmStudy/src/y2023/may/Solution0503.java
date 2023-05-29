package y2023.may;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/
public class Solution0503 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();

        for (int i : nums1) {
            n1.add(i);
        }

        for (int i : nums2) {
            n2.add(i);
            n1.remove(i);
        }

        for (int i : nums1) {
            n2.remove(i);
        }

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>(n1));
        res.add(new ArrayList<>(n2));

        return res;
    }
}
