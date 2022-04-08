package y2022.apr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class Solution0408 {
}

class KthLargest {

    private int k;
    private List<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        this.list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list);
    }

    public int add(int val) {
        int pos = Collections.binarySearch(list, val);

        if (pos < 0) {
            pos = -pos - 1;
        }


        list.add(pos, val);
        //System.out.println(list);

        return list.get(list.size() - k);
    }
}