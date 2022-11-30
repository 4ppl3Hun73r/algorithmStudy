package y2022.nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Solution1129 {
}


class RandomizedSet {

    HashMap<Integer, Integer> valueIndexMap = new HashMap();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) {
            return false;
        }
        valueIndexMap.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (valueIndexMap.containsKey(val)) {
            int removeIdx = valueIndexMap.get(val);

            int val2 = list.get(list.size() - 1);
            list.set(removeIdx, val2);
            list.remove(list.size() - 1);
            valueIndexMap.put(val2, removeIdx);

            valueIndexMap.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        // List<Integer> l = new ArrayList<>(set); // O(N)

        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */