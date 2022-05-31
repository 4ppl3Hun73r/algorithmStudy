package y2022.jan;

import java.util.*;

// https://leetcode.com/problems/jump-game-iv/
public class Solution0115 {
    public int minJumps(int[] arr) {
        int len = arr.length;
        int lastIndex = len - 1;
        int jump = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len];
        Map<Integer, Set<Integer>> valuePosMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!valuePosMap.containsKey(arr[i])) {
                valuePosMap.put(arr[i], new HashSet<>());
            }
            valuePosMap.get(arr[i]).add(i);
        }
        visited[0] = true;
        queue.add(0);
        valuePosMap.get(arr[0]).remove(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean findLast = false;

            for (int i = 0; i < size; i++) {
                int currentPos = queue.poll();
                if (currentPos == lastIndex) {
                    findLast = true;
                    break;
                }
                Set<Integer> posSet = valuePosMap.get(arr[currentPos]);
                for (Integer pos : posSet) {
                    if (!visited[pos]) {
                        queue.add(pos);
                        visited[pos] = true;
                    }
                }
                posSet.clear();

                int stepForward = currentPos + 1;
                if (stepForward < len) {
                    if (!visited[stepForward]) {
                        queue.add(stepForward);
                        visited[stepForward] = true;
                    }
                }

                int stepBack = currentPos - 1;
                if (stepBack > 0) {
                    if (!visited[stepBack]) {
                        queue.add(stepBack);
                        visited[stepBack] = true;
                    }
                }
            }
            if (findLast) {
                break;
            }
            jump++;

        }


        return jump;
    }

    public static void main(String[] args) {
        Solution0115 s = new Solution0115();

        // System.out.println(s.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));

        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 7;
        }
        arr[49999] = 11;
        System.out.println(s.minJumps(arr));


        /*
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            boolean sign = random.nextBoolean();
            if (sign) {
                System.out.print(random.nextInt(100000000));
            } else {
                System.out.print(-1 * random.nextInt(100000000));
            }
            System.out.print(",");
        }*/

    }
}
