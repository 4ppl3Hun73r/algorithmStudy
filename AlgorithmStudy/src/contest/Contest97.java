package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Contest97 {


    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] num : nums) {
            for (int i : num) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        int cnt = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> numCnt : map.entrySet()) {
            if (numCnt.getValue() == cnt) {
                ans.add(numCnt.getKey());
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Contest97 c = new Contest97();

    }
}
