package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpsToReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        /*
        forbidden으로는 갈수 없음
        a는 +
        b는 -
        0 미만으로 갈수 없음
        x까지 도달하는 최소한의 수
         */
        int jump = 0;

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 0 -> 앞 뒤 어디로든 뛸수 있음, 1 -> 앞으로만 뛸 수 있음
        visited.add(0);

        for (int f : forbidden) {
            visited.add(f);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean reachX = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                //System.out.print(Arrays.toString(pos));
                if (pos[0] == x) {
                    reachX = true;
                    break;
                }

                boolean backward = pos[1] == 0;

                int left = pos[0] - b;
                int right = pos[0] + a;

                if (backward && !(left < 0 || visited.contains(left))) {
                    queue.add(new int[]{left, 1});
                    visited.add(left);
                }

                if (!(right >= 6000 || visited.contains(right))) {
                    queue.add(new int[]{right, 0});
                    visited.add(right);
                }
            }
            //System.out.println();

            if (reachX) {
                return jump;
            }
            jump++;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        MinimumJumpsToReachHome m = new MinimumJumpsToReachHome();

        //System.out.println(m.minimumJumps(new int[]{8,3,16,6,12,20}, 15, 13, 11));

        System.out.println(m.minimumJumps(new int[]{1998}, 1999, 2000, 2000));
    }
}
