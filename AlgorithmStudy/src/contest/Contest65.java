package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Contest65 {
    public int countPairs(int[] nums, int k) {
        HashMap<Integer, List<Integer>> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numIndexMap.containsKey(nums[i])) {
                numIndexMap.put(nums[i], new ArrayList<>());
            }
            numIndexMap.get(nums[i]).add(i);
        }

        int res = 0;
        for (List<Integer> indexList : numIndexMap.values()) {
            for (int i = 0; i < indexList.size(); i++) {
                int leftIdx = indexList.get(i);
                for (int j = i + 1; j < indexList.size(); j++) {
                    if (leftIdx * indexList.get(j)%2 == 0) {
                        res++;
                    }
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Contest65 c = new Contest65();

        System.out.println(c.countPairs(new int[]{5,5,9,2,5,5,9,2,2,5,5,6,2,2,5,2,5,4,3}, 7)); // 18

    }
}
