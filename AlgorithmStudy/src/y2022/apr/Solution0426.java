package y2022.apr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
public class Solution0426 {

    class Group {
        List<int[]> points = new ArrayList<>();
        int costs = 0;

        public Group(int[] point) {
            this.points.add(point);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        /*
         각 points 를 선으로 연결할때 Min Cost
         cost = |x1 - x2| + |y1 - y2|
         1 <= points.length <= 1000

        Node1 -w- Node2

        (1 2 3 4 5
          2 3 4 5

         1 - 2 - 3 - 4 - 5
         1 - 5 - 2 - 3 - 4

         A   B

         C   D   E

         */
        int len = points.length;
        LinkedList<Group> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.add(new Group(points[i]));
        }

        while (queue.size() != 1) {
            Group group1 = queue.poll();

            int size = queue.size();
            List<int[]> group1Points = group1.points;
            int cost = Integer.MAX_VALUE;
            int idx = 0;
            for (int k = 0; k < size; k++) {
                Group group2 = queue.get(k);

                // group 비교
                List<int[]> group2Points = group2.points;
                for (int i = 0; i < group1Points.size(); i++) {
                    int[] point1 = group1Points.get(i);
                    for (int j = 0; j < group2Points.size(); j++) {
                        int[] point2 = group2Points.get(j);
                        int weight = Math.abs(point1[0] - point2[0]) +
                                Math.abs(point1[1] - point2[1]);
                        if (weight < cost) {
                            cost = weight;
                            idx = k;
                        }
                    }
                }
            }
            Group group2 = queue.remove(idx);
            group1.points.addAll(group2.points);
            group1.costs += (cost + group2.costs);

            queue.add(group1);
        }

        return queue.poll().costs;
    }

    public static void main(String[] args) throws Exception {
        Solution0426 s = new Solution0426();

        System.out.println(s.minCostConnectPoints(new int[][]{
                {0,0}, {2,2},{3,3}
        }));
    }
}
