package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

// https://leetcode.com/problems/water-and-jug-problem/
public class WaterAndJugProblem {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }

        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity ||
            jug1Capacity + jug2Capacity == targetCapacity) {
            return true;
        }

        return targetCapacity%gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int a, int b){
        if(b == 0) {
            return a;
        } else{
            return gcd(b, a%b);
        }
    }

    // 그렇게 안 느린것 같은데 시간 초과 남.
    public boolean canMeasureWaterTimeLimit(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        /*
        2 개의 jug를 이용해서 targetCapacity를 만들기
        die hard 문제
        jug1 = 3
        jug2 = 5
        target = 4

        jug2 를 가득 채운다     (0, 5)
        jug2 -> jug1 로 옮긴다 (3, 2)
        jug1 을 버린다         (0, 2)
        jug2 -> jug1         (2, 0)
        jug2 를 가득 채운다     (2, 5)
        jug2 -> jug1         (3, 4)
        jug1 을 버린다         (0, 4)
         */

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        Set<int[]> visited = new TreeSet<>((a, b)->(a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]));
        while (!queue.isEmpty()) {
            int[] jugs = queue.poll();
            int jug1 = jugs[0];
            int jug2 = jugs[1];
            if (jug1 + jug2 == targetCapacity) {
                return true;
            }
            // String key = jug1 + "," + jug2;
            if (visited.contains(jugs)) {
                // 이미 왔던 길
                continue;
            }
            visited.add(jugs);

            System.out.println(jug1 + jug2);


            /*
            1. jug1을 가득채운다
            2. jug1을 버린다
            3. jug1을 jug2로 옮긴다

            4. jug2을 가득채운다
            5. jug2를 버린다
            6. jug2를 jug1로 옮긴다
             */

            if (jug1 != jug1Capacity) {
                queue.add(new int[]{jug1Capacity, jug2});
            }
            if (jug1 != 0) {
                queue.add(new int[]{0, jug2});
            }
            if (jug2 != jug2Capacity) {
                int jug1LeftCapacity = jug1 - (jug2Capacity - jug2);

                queue.add(new int[]{Math.max(jug1LeftCapacity, 0), Math.min(jug2Capacity, jug2 + jug1)});
            }

            if (jug2 != jug2Capacity) {
                queue.add(new int[]{jug1, jug2Capacity});
            }
            if (jug2 != 0) {
                queue.add(new int[]{jug1, 0});
            }
            if (jug1 != jug1Capacity) {
                int jug2LeftCapacity = jug2 - (jug1Capacity - jug1);

                queue.add(new int[]{Math.min(jug1Capacity, jug1 + jug2), Math.max(jug2LeftCapacity, 0)});
            }

        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        WaterAndJugProblem w = new WaterAndJugProblem();
        System.out.println(w.canMeasureWater(104693,104701,324244));
        //104693
        //104701
        //324244
    }
}
