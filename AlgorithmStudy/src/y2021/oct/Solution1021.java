package y2021.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Solution1021 {

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        int val = 10;
        r.insert(1);
        r.insert(2);
        r.remove(2);
        r.remove(1);
        r.insert(2);
        int p = r.getRandom();
        System.out.println(p);
    }
}

class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int listIndex = map.remove(val);

            if (listIndex < list.size() - 1) {
                int v = list.get(list.size() - 1);
                list.set(listIndex, v);
                map.put(v, listIndex);
            }
            list.remove(list.size() - 1);

            return true;
        }
        return false;
    }

    public int getRandom() {
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