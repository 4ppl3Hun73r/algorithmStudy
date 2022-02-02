package contest;

import java.util.HashSet;

// https://leetcode.com/contest/weekly-contest-278/problems/keep-multiplying-found-values-by-two
public class Contest49 {

    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) {
            original = 2 * original;
        }

        return original;
    }


    public static void main(String[] args) {
        Contest49 c = new Contest49();

    }
}
