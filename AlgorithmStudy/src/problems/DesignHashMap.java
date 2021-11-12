package problems;

import java.util.Arrays;

public class DesignHashMap {
}

class MyHashMap {
    int[] map = new int[10000001];

    public MyHashMap() {
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}