package y2022.oct;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/my-calendar-iii/
public class Solution1007 {
}


class MyCalendarThree {

    private TreeMap<Integer, Integer> starts; // 시작 시간, 겹치는 수
    private int res;

    public MyCalendarThree() {
        starts = new TreeMap<>();
        starts.put(0, 0);
        res = 0;
    }

    public void mergeStart(int x) {
        Integer prev = starts.floorKey(x); // 시간 기준으로 이전 일정 가져오기
        Integer next = starts.ceilingKey(x); // 시간 기준으로 이후 일정 가져오기

        if (next != null && next == x) {
            return;
        }
        starts.put(x, starts.get(prev)); // 이전 일정의 겹치는 수 넣기
    }

    /*
      start ~ end 까지 예약
      해당 시간대의 일정 수를 반환
     */
    public int book(int start, int end) {
        mergeStart(start);
        mergeStart(end);
        // 겹치는 일정 다 가져와서 최대로 겹치는거 구하면서 +1 하기
        for (Map.Entry<Integer, Integer> interval :
                starts.subMap(start, true, end, false).entrySet()) {
            res = Math.max(res, interval.setValue(interval.getValue() + 1) + 1);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */