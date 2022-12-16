package problems;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
public class RandomizedCollection {

    HashMap<Integer, Set<Integer>> valueIndexMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    public RandomizedCollection() {
    }

    public boolean insert(int val) {
        if (!valueIndexMap.containsKey(val)) {
            valueIndexMap.put(val, new HashSet<>());
        }
        valueIndexMap.get(val).add(list.size());
        list.add(val);

        return valueIndexMap.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (valueIndexMap.containsKey(val) && valueIndexMap.get(val).size() > 0) {
            Set<Integer> indexSet = valueIndexMap.get(val);

            int updateIdx = indexSet.iterator().next();
            indexSet.remove(updateIdx);
            int removeIdx = list.size() -1;
            int val2 = list.get(removeIdx);

            list.set(updateIdx, val2);
            list.remove(removeIdx);

            valueIndexMap.get(val2).add(updateIdx);
            valueIndexMap.get(val2).remove(removeIdx);

            return true;
        }

        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) throws Exception {
        RandomizedCollection s = new RandomizedCollection();

        /*System.out.println(s.insert(1));
        System.out.println(s.remove(1));
        System.out.println(s.insert(1));*/

        /*System.out.println(s.insert(0));
        System.out.println(s.insert(1));
        System.out.println(s.remove(0));
        System.out.println(s.insert(2));
        System.out.println(s.remove(1));
        System.out.println(s.getRandom());*/

        /*System.out.println(s.insert(0));
        System.out.println(s.remove(0));
        System.out.println(s.remove(0));
        System.out.println(s.insert(1));
        System.out.println(s.getRandom());*/

        System.out.println(s.insert(4));
        System.out.println(s.insert(3));
        System.out.println(s.insert(4));
        System.out.println(s.insert(2));
        System.out.println(s.insert(4));
        System.out.println(s.remove(4));
        System.out.println(s.remove(3));
        System.out.println(s.remove(4));
        System.out.println(s.remove(4));
    }
}