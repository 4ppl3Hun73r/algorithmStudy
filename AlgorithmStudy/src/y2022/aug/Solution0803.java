package y2022.aug;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

// https://leetcode.com/problems/my-calendar-i/
public class Solution0803 {

    public static void main(String[] args) throws Exception {
        Solution0803 s = new Solution0803();
        MyCalendar m = new MyCalendar();

        System.out.println(m.book(37, 50));
        System.out.println(m.book(33, 50));
        System.out.println(m.book(4, 17));
    }
}


class MyCalendar {

    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int start, int end) {
        // start <= x < end

        for (int[] book : set) {
            if (book[0] < end && start < book[1]) {
                return false;
            }

            if (end < book[0]) {
                break;
            }
        }

        set.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

class MyCalendar2 {
    TreeMap<Integer, Integer> calendar;

    MyCalendar2() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}