package y2023.jan;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/max-points-on-a-line/
public class Solution0108 {
    public int maxPoints(int[][] points) {
        /*
        한 선에 올라가는 최대 point 를 구하라
         */

        // 선을 그은 다음에 해당 선에 대표 point 를 두고 신규 point 는 대표 point 와 비교 처리

        /*List<List<int[]>> lines = new ArrayList<>();
        List<int[]> group = new ArrayList<>();
        group.add(points[0]);
        lines.add(group);

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            for (List<int[]> line : lines) {
                int[] representPoint = line.get(0);




            }
        }*/

        /*if (points.length == 1) {
            return 1;
        }

        Map<Double, Set<int[]>> inclineCntMap = new HashMap<>();
        Map<Double, Set<int[]>> xCntMap = new HashMap<>();
        Map<Double, Set<int[]>> yCntMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                Double incline = 0d;
                Map<Double, Set<int[]>> temp = null;
                if (point1[1] == point2[1]) {
                    incline = (double)point1[0];
                    temp = xCntMap;
                } else if (point1[0] == point2[0]) {
                    incline = (double)point1[1];
                    temp = yCntMap;
                } else {
                    incline = ((double)(point1[0] - point2[0]) / (double)(point1[1] - point2[1]));
                    temp = inclineCntMap;
                }

                if (!temp.containsKey(incline)) {
                    temp.put(incline, new HashSet<>());
                }
                temp.get(incline).add(point1);
                temp.get(incline).add(point2);
            }
        }

        System.out.println(inclineCntMap);
        System.out.println(yCntMap);
        System.out.println(xCntMap);

        int max = 0;
        for (Set<int[]> cntSet : inclineCntMap.values()) {
            max = Math.max(max, cntSet.size());
        }
        for (Set<int[]> cntSet : yCntMap.values()) {
            max = Math.max(max, cntSet.size());
        }
        for (Set<int[]> cntSet : xCntMap.values()) {
            max = Math.max(max, cntSet.size());
        }

        return max;*/

        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> inclineCntMap = new HashMap<>();
            int[] point1 = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] point2 = points[j];
                Double incline = 0d;
                if (point1[1] == point2[1]) {
                    incline = Double.POSITIVE_INFINITY;
                } else {
                    incline = ((double)(point1[0] - point2[0]) / (double)(point1[1] - point2[1]));
                }
                inclineCntMap.put(incline, inclineCntMap.getOrDefault(incline, 0) + 1);
                max = Math.max(max, inclineCntMap.get(incline));
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution0108 s = new Solution0108();

        /*System.out.println(s.maxPoints(new int[][]{
                {1,1},{3,2},{5,3},{4,1},{2,3},{1,4}
        }));*/

        System.out.println(s.maxPoints(new int[][]{
                {0,0},{1,1},{1,-1}
        }));
    }
}
