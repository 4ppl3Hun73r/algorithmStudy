package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        /*
        boxes "110"

        1은 박스안에 볼이 있음
        0은 비었음

        공은 옆에 있을떄 옮길 수 있음

        answer[i] = 모든 공을 i로 옮기기 위한 최소 작업
        110
        answer[0] = boxes[1] 을 옮기면 됨
        answer[1] = boxes[0] 을 옮기면 됨
        answer[2] = boxes[0] 을 옮기고, boxes[1]을 옮기고, boxes[1]을 또 옮기고

        answer[0] = abs(0, 1)
        answer[1] = abs(1, 0)
        answer[2] = abs(0, 2) + abs(1, 2)
         */
        int len = boxes.length();
        int[] answer = new int[len];

        List<Integer> ballPos = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                ballPos.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            for (Integer pos : ballPos) {
                answer[i] += Math.abs(pos - i);
            }
        }

        return answer;
    }
}
