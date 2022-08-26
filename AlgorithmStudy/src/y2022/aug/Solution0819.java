package y2022.aug;

import java.util.*;

// https://leetcode.com/problems/split-array-into-consecutive-subsequences/
public class Solution0819 {
    public boolean isPossible(int[] nums) {
        /*
        nums : 정렬된 배열
        조건에 맞게 분해가 가능한가?
        - 정렬된 배열이어야함 (증가)
        - 길이가 3 이상이어야함
        [1,2,3,3,4,5]
         ^ ^ ^
               ^ ^ ^

         <1,1>,<2,1>,<3,2>,<4,1>,<5,1>
         <1,0>,<2,0>,<3,1>,
                     <3,1><4,1><5,1>
                     <3,0><4,0><5,0>

        [1,2,3,3,4,4,5,5]
         ^ ^ ^   ^   ^
               ^   ^   ^
        <1,1>,<2,1>,<3,2>,<4,2>,<5,2>
        <1,0><2,0><3,1>,<4,1><5,1>

        <3,1>,<4,1><5,1>
        <3,0><4,0><5,0>

         [1,2,3,4,4,5]
          ^ ^ ^ ^
                  ^ ^ -> false
         <1,1>,<2,1>,<3,1>,<4,2>,<5,1>
         <1,0><2,0><3,0><4,1>

         <4,1><5,1>
         <4,0><5,0>


        1 <= nums.length <= 10000
        -1000 <= nums[i] <= 1000
         */
        Map<Integer, Integer> numCntMap = new HashMap<>();
        for (int num : nums) {
            numCntMap.put(num, numCntMap.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        for (Map.Entry<Integer, Integer> entry : numCntMap.entrySet()) {
            pq.offer(entry);
        }

        while (!pq.isEmpty()) {

            List<Map.Entry<Integer, Integer>> subsequences = new ArrayList<>();
            Map.Entry<Integer, Integer> entry = pq.poll();
            entry.setValue(entry.getValue() - 1);
            subsequences.add(entry);

            while (!pq.isEmpty() && pq.peek().getKey() - entry.getKey() == 1
             && pq.peek().getValue() > entry.getValue()) {
                Map.Entry<Integer, Integer> entry2 = pq.poll();
                entry2.setValue(entry2.getValue() - 1);
                subsequences.add(entry2);
                entry = entry2;
            }

            if (subsequences.size() < 3) {
                return false;
            }

            for (Map.Entry<Integer, Integer> subsequence : subsequences) {
                if (subsequence.getValue() > 0) {
                    pq.offer(subsequence);
                }
            }
        }

        // 1번째 큐 데이터 들이있고 숫자가 연속이면 계속 뽑아냄, 연속되지 않은 숫자면 대기 큐에 넣는다.
        // 대기 큐가 데이터 큐로 바뀌고 , 데이터 큐가 대기큐로 바꾸면서 다시 1번 루프 진행

        return true;
    }
}
