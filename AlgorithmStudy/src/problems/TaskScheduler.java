package problems;

import java.util.*;

// https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskArr = new int[26];

        // 가장 긴 작업을 찾음
        int maxCount = 0;
        for (char task : tasks) {
            taskArr[task - 'A'] ++;
            maxCount = Math.max(maxCount, taskArr[task - 'A']);
        }

        // (가장 긴 작업의 수 - 1) * (idle 시간 + 1) = 한 사이클 횟수
        int result = (maxCount - 1) * (n + 1);
        // 동일한 가장 긴 작업 수 확인해서 + 1처리
        for (int task : taskArr) {
            if (task == maxCount) result++;
        }
        // 한 사이클에 작은 작업 수가 다 들어감.

        // 전체 길이랑 사이클 횟수 중 큰게 작업에 필요한 CPU 값
        return Math.max(result, tasks.length);
    }
    /*
    AAA BBB 2
    6 -> 8
    A B I A B I A B

    AAA BBB 3
    8 -> 10
    A B I I A B I I A B

    AAA BB 3
    8 -> 9
    A B I I A B I I A

    AAA BB C D E
    8 -> 9
    A B C D A B E I A

     */

    public int leastInterval2(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        int taskLen = tasks.length;
        Map<Character, List<Integer>> taskMap = new HashMap<>();
        for (char task : tasks) {
            List<Integer> taskList = taskMap.getOrDefault(task, new ArrayList<>());
            taskList.add(-1);
            taskMap.put(task, taskList);
        }

        int result = 0;
        Set<Character> keySet = taskMap.keySet();
        while (!keySet.isEmpty()) {
            Character candidateKey = null;
            int maxTaskLen = -1;
            for (Character key : keySet) {
                List<Integer> taskList = taskMap.get(key);
                if (taskList.get(0) == -1) {
                    if (taskList.size() > maxTaskLen) {
                        maxTaskLen = taskList.size();
                        candidateKey = key;
                    }
                }
            }
            if (candidateKey != null) {
                taskMap.get(candidateKey).set(0, n + 1);
            }

            for (Character key : keySet) {
                List<Integer> taskList = taskMap.get(key);
                int t = taskList.get(0);
                if (t == 1) {
                    taskList.remove(0);
                } else if (t > 0) {
                    taskList.set(0, t - 1);
                }
            }

            Set<Character> newKeySeq = new HashSet<>(keySet);
            for (Character key : newKeySeq) {
                List<Integer> taskList = taskMap.get(key);
                if (taskList.size() == 0) {
                    taskMap.remove(key);
                }
                if (taskList.size() == 1 && taskList.get(0) > 0) {
                    taskMap.remove(key);
                }
            }
            result++;
            keySet = taskMap.keySet();
        }

        return result;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B', 'C', 'C', 'C', 'D', 'D', 'E'}, 2));
        System.out.println(ts.leastInterval2(new char[]{'A','A','A','B','B','B', 'C', 'C', 'C', 'D', 'D', 'E'}, 2));

        /*System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(ts.leastInterval(new char[]{'A','A','A','A','A','A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2)); // "A","A","A","A","A","A","B","C","D","E","F","G"

*/
    }
}
