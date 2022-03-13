package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Contest85 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        Set<Integer> ans = new TreeSet<>();

        List<Integer> kIndex = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                kIndex.add(i);
            }
        }

        for (Integer index : kIndex) {
            for (int i = index - k; i <= index + k; i++) {
                if (i >= 0 && i < nums.length) {
                    ans.add(i);
                }
            }
        }

        return new ArrayList<>(ans);

    }

    public static void main(String[] args) {
        Contest85 c = new Contest85();

    }
}
