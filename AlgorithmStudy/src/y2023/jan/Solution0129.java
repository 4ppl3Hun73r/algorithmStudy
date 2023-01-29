package y2023.jan;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/lfu-cache/
public class Solution0129 {

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        /*lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);*/

        /*lfu.put(3, 1);
        lfu.put(2, 1);
        lfu.put(2, 2);
        lfu.put(4, 4);
        System.out.println(lfu.get(2));*/

        lfu.get(2);
        lfu.put(2, 6);
        lfu.get(1);
        lfu.put(1, 5);
        lfu.put(1, 6);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
    }
}


class LFUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    private TreeMap<Integer, LinkedHashSet<Integer>> frequentlyMap;

    // The functions get and put must each run in O(1) average time complexity.
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequentlyMap = new TreeMap<>();
    }

    private void updateFrequently(Node node) {
        LinkedHashSet<Integer> set = frequentlyMap.get(node.cnt);
        if (set != null) {
            set.remove(node.key);
            if (set.size() == 0) {
                frequentlyMap.remove(node.cnt);
            }
        }

        node.cnt++;
        if (!frequentlyMap.containsKey(node.cnt)) {
            frequentlyMap.put(node.cnt, new LinkedHashSet<>());
        }

        frequentlyMap.get(node.cnt).add(node.key);
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        // cache 되어 있으면 해당 값, 없으면 -1
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            updateFrequently(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // put 과 동일하게 동작
        // capacity 가 가득 찼으면, least frequently used 로 제거 하고 신규 키 삽입, tie 이면 least recently used 로 제거
        // counter 는 get / put 할때 마다 +1 씩 증가
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateFrequently(node);
            cache.put(key, node);
            return;
        }

        if (cache.size() == capacity) {
            // 하나 제거
            Map.Entry<Integer, LinkedHashSet<Integer>> entry = frequentlyMap.firstEntry();

            LinkedHashSet<Integer> set = entry.getValue();
            final int first = set.iterator().next();
            set.remove(first);
            if (set.size() == 0) {
                frequentlyMap.remove(entry.getKey());
            }

            cache.remove(first);
        }

        Node node = new Node(key, value);
        updateFrequently(node);
        cache.put(key, node);
    }

    static class Node {
        int key;
        int val;
        int cnt = 0;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */