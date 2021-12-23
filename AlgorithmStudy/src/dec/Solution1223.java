package dec;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
public class Solution1223 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        // [a, b] - b를 이수해야 a 를 들을수 있음
        // 시작점은 아무것도 이수할 필요 없는 것 부터 시작 ->
        // 해당 지점들로 travel 을 진행, 모두 이수가 되면 ok
        List<Set<Integer>> courseList = new ArrayList<>();
        List<Set<Integer>> reverseCourseList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseList.add(new TreeSet<>());
            reverseCourseList.add(new TreeSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            // b를 들으면 a... 를 들을수 있음
            courseList.get(prerequisite[1]).add(prerequisite[0]);
            // a를 듣기 위해서는 b... 를 들어야 함.
            reverseCourseList.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < reverseCourseList.size(); i++) {
            if (reverseCourseList.get(i).isEmpty()) {
                queue.add(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            // C -> 이수 완료 된것만 있음
            int c = queue.poll();
            result[idx++] = c;

            // 완료 했기 때문에 다음 코스를 진행 시킬 수 있음
            Set<Integer> nextCourse = courseList.get(c);
            for (Integer course : nextCourse) {
                reverseCourseList.get(course).remove(c);
                if (reverseCourseList.get(course).isEmpty()) {
                    queue.add(course);
                }
            }
        }

        if (idx != numCourses) {
            return new int[0];
        }

        return result;
    }
}
