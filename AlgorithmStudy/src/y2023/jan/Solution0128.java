package y2023.jan;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/data-stream-as-disjoint-intervals/
public class Solution0128 {
    /*

    num 을 추가 하고 get intervals 를 호출 하면 disjoint intervals 로 반환

    1 -> [1, 1]
    3 -> [1, 1], [3, 3]
    7 -> [1, 1], [3, 3], [7, 7]
    2 -> [1, 3], [7, 7]
    6 -> [1, 3], [6, 7]


    같은 값이 여러번 호출 될 수 있음

    머지를 한다면
    set -> +1, -1 을 찾음 있으면 합침, 없으면 독립으로 존재
    set 으로 합치고 반환 시점에 생성?

    Treemap floorEntry 로 검색 지원?

     */
}

class SummaryRanges {

    TreeMap<Integer, Integer> interValMap = new TreeMap<>();

    public SummaryRanges() {
        interValMap = new TreeMap<>();

    }

    public void addNum(int value) {
        int left = value;
        int right = value;
        Map.Entry<Integer, Integer> leftEntry = interValMap.floorEntry(value);
        if (leftEntry != null) {
            int prv = leftEntry.getValue();
            if (prv >= value) {
                return; // 이미 범위에 추가되어 있음
            }
            if (prv == value - 1) { /// 바로 앞에 값이면 머지 실행
                left = leftEntry.getKey();
            }
        }

        Map.Entry<Integer, Integer> rightEntry = interValMap.higherEntry(value);
        if (rightEntry != null && rightEntry.getKey() == value + 1) { // 바로 앞 값이면 머지
            right = rightEntry.getValue();
            interValMap.remove(value + 1); // 기존건 제거
        }
        interValMap.put(left, right);
    }

    public int[][] getIntervals() {
        int[][] answer = new int[interValMap.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : interValMap.entrySet()) {
            answer[idx][0] = entry.getKey();
            answer[idx][1] = entry.getValue();
            idx++;
        }
        return answer;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */