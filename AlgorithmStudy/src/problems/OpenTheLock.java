package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/open-the-lock/
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        /*
        0000 -> target 으로 이동
        0 -> 9 -> 0 순서대로 변경
        deadends 로 갈수는 없음
         */

        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        deadendSet.add("0000");

        char[] targetArr = target.toCharArray();

        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);
            for (int i = 0; i < size; i++) {
                String lock = queue.poll();

                if (target.equals(lock)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    char[] arr = lock.toCharArray();

                    if (arr[j] != '9') {
                        arr[j] = (char) (arr[j] + 1);
                    } else {
                        arr[j] = '0';
                    }
                    String nextLock = new String(arr);
                    if (!deadendSet.contains(nextLock)) {
                        queue.add(nextLock);
                        deadendSet.add(nextLock); // 다시 못 돌아가게
                    }

                    arr = lock.toCharArray();
                    if (arr[j] != '0') {
                        arr[j] = (char) (arr[j] - 1);
                    } else {
                        arr[j] = '9';
                    }
                    nextLock = new String(arr);
                    if (!deadendSet.contains(nextLock)) {
                        queue.add(nextLock);
                        deadendSet.add(nextLock); // 다시 못 돌아가게
                    }
                }
            }

            step++;
        }


        return -1;
    }

    public static void main(String[] args) throws Exception {
        OpenTheLock o = new OpenTheLock();
        System.out.println(o.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(o.openLock(new String[]{"8888"}, "0009"));
        System.out.println(o.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}
