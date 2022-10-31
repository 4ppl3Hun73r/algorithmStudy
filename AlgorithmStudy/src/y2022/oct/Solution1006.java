package y2022.oct;

import java.util.*;

// https://leetcode.com/problems/time-based-key-value-store/
public class Solution1006 {
    /*
    [a, [b,1],[c,2],[d,3]]

    get(a, 0) -> ""
    get(a, 1) -> b
    get(a, 4) -> d


    insert -> binary search
    |----------------| -> binary search
     */

    public static void main(String[] args) throws Exception {
        Solution1006 s = new Solution1006();

        TimeMap map = new TimeMap();

        map.set("a", "b", 1);
        map.set("a", "c", 2);
        map.set("a", "d", 3);

        System.out.println(map.get("a", 0));
        System.out.println(map.get("a", 1));
        System.out.println(map.get("a", 2));
        System.out.println(map.get("a", 3));
        System.out.println(map.get("a", 4));
    }
}

class TimeMap {

    static class Node implements Comparable<Node> {
        Integer timestamp;
        String value;

        @Override
        public int compareTo(Node o) {
            return this.timestamp - o.timestamp;
        }
    }

    Map<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        List<Node> list = map.get(key);
        Node node = new Node();
        node.timestamp = timestamp;
        node.value = value;
        list.add(node);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Node node = new Node();
        node.timestamp = timestamp;
        List<Node> list = map.get(key);
        int idx = Collections.binarySearch(list, node);

        //System.out.println(idx);
        if (idx == -1) {
            return "";
        }

        if (idx < 0) {
            // 넣을 자리 -1 ->  0번째 idx 넣어야 된다. -> 배열 비어 있거나, 진짜 첫번째 값이거나
            // timestamp_prev <= timestamp(parameter)
            // -1 -> ""
            // -4 -> "d"
            idx = -idx;
            idx -= 2;
        }

        return list.get(idx).value;
    }
}

class TimeMapTreeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMapTreeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> subMap = map.get(key);
        Integer time = subMap.floorKey(timestamp);

        if (time == null) {
            return "";
        }
        return subMap.get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */