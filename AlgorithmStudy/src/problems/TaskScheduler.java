package problems;

import java.util.*;

// https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
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
        //System.out.println(ts.leastInterval(new char[]{'A','E','E','B','B','B', 'C', 'C', 'C', 'D', 'D', 'E'}, 2));

        /*System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(ts.leastInterval(new char[]{'A','A','A','A','A','A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2)); // "A","A","A","A","A","A","B","C","D","E","F","G"

*/
    }
}
