package problems;

import java.util.TreeSet;

public class SmallestNumberInInfiniteSet {
}

class SmallestInfiniteSet {

    TreeSet<Integer> set;
    int pos;
    public SmallestInfiniteSet() {
        pos = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (!set.isEmpty()) {
            return set.pollFirst();
        }
        return pos++;
    }

    public void addBack(int num) {
        if (num < pos) {
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */