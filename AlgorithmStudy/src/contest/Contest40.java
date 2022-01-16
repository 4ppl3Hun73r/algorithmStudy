package contest;

import java.util.PriorityQueue;

public class Contest40 {
    public long maxRunTime(int n, int[] batteries) {

        long min = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 -o1);
        for (int battery : batteries) {
            queue.add(battery);
        }
        while (!(queue.size() < n)) {
            min++;
            /*
            가장 큰거 하나 뽑아 먹고
            작은거 뽑고
            ...
             */
            for (int i = 0; i < n; i++) {
                int use = queue.poll() - 1;
                if (use != 0) {
                    queue.add(use);
                }
            }
        }

        // 시뮬레이션 하면 time 걸림...

        return min;
    }

    public static void main(String[] args) {
        Contest40 c = new Contest40();

        System.out.println(c.maxRunTime(2, new int[]{3,3,3}));
    }
}
