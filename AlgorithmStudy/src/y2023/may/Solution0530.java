package y2023.may;

import java.util.LinkedList;

// https://leetcode.com/problems/design-hashset/
public class Solution0530 {
}

class MyHashSet {
    // Array
    // linked
    private final int BUCKET_SIZE = 10000;
    LinkedList<Integer>[] array;

    public MyHashSet() {
        array = new LinkedList[BUCKET_SIZE];
    }

    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void add(int key) {
        int hash = getHash(key);
        if (array[hash] == null) {
            array[hash] = new LinkedList<>();
        }
        if (!contains(key)) {
            array[hash].add(key);
        }
    }

    public void remove(int key) {
        int hash = getHash(key);
        if (array[hash] != null) {
            array[hash].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int hash = getHash(key);

        if (array[hash] == null) {
            return false;
        }
        return array[hash].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */