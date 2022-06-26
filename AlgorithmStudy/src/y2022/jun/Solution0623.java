package y2022.jun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/course-schedule-iii/
public class Solution0623 {

    public int scheduleCourse(int[][] courses) {
        /*
        courses[i] = [duration, lastDay]
        강좌는 duration 동안 연속으로 들어야 하며, lastDay 이전에 완료 해야함
        강좌는 1일차에서 시작해서 동시에 1개 이상은 들을 수 없음

        lastDay - duration -> 시작할 수 있는 한계

        1. lastDay가 가까운 순으로 정렬
        2. 뽑아서 우선순위 큐로 정리해서
        3. 하나씩 뽑아서 보기?

        [ 수업시간1, 수업시간2, 수업시간3, .... ]


        A ------                    |
        B --------------- |
        C ---------                                     |
        D -----------------------------                 |
        E ---------------------              |
        |-----------------------------------------------|
        A ------                    |
        B --------------- |
        E ---------------------              |
        C ---------                                     |
        D -----------------------------                 |
        |-----------------------------------------------|
        A는 들을 수 있음
        A ------                    |
        B는 들을 수 없음

        - A 를 B로 교체
        B --------------- |
        E는 들을 수 없음
        C 는 들을 수 있음
        B --------------- |
        C                ---------                      |
        D 는 들을 수 없음 / C를 D 로 교체 가능

        - A 를 유지
        A ------                    |
        E는 들을 수 있음
        A ------                    |
        E       ---------------------        |
        C는 들을 수 있음
        A ------                    |
        E       ---------------------        |
        C                            ---------          |
        D는 못들음
         */

        // 수업 종료 시간 기준으로 정렬
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        // 역순 정렬 ( 가장 긴 시간이 앞으로 옴)
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                // 내가 수업을 들을 수 있으면?
                queue.offer(course[0]);
                time += course[0];
            } else {
                // 수업을 못 들으면 최근 들었던 수업을 제거하고
                // 가장 큰 시간을 가진 수업과 현재 수업을 비교해서 현재 수업이 더 짧으면 교체
                if ( !queue.isEmpty() && queue.peek() > course[0]) {
                    time -= queue.poll();
                    time += course[0];
                    queue.offer(course[0]);
                }
            }

        }

        // queue에 남아 있는 수가 최대 수업 수
        return queue.size();

    }
}
