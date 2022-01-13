package y2022.jun;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class Solution0113 {
    public int findMinArrowShots(int[][] points) {
        /*
        |---------|
         |--|
              |--|
                  |-----------------|
                   |-----|
                       |------|
         */
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(points));
        int shots = 0;
        for (int i = 0; i < points.length; i++) {
            int shotPoint = points[i][1];
            for (int j = i + 1; j < points.length; j++, i++) {
                if (points[j][0] > shotPoint) {
                    break;
                }
                shotPoint = Math.min(shotPoint, points[j][1]);
            }
            shots++;
        }
        return shots;
    }

    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

         /*
    API 응답 속도,     |--|
    API 응답 속도,          |--|
    API 응답 속도,    |---------|
    API 응답 속도,               |-----|
    API 응답 속도,                   |------|
    API 응답 속도,              |-----------------|
    정렬 안한걸 -> 정렬 해서 -> 동시에 호출 했을 최적에 효율?
         */

        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Solution0113 s = new Solution0113();

        System.out.println(s.findMinArrowShots(new int[][]{
                {-207,57},
                {19,144},
                {-15,170},
                {-485,143},
                {-102,-68}
        })); // 2

        // [[-2072225236,579576003],[197910035,1440811157],[-157427747,1703248476],[-485705905,1432308137],[-1022885640,-684242724]] // 2
        /*
        System.out.println(s.findMinArrowShots(new int[][]{
                {10,16}, {2,8},{1,6},{7,12}
        })); // 2

        System.out.println(s.findMinArrowShots(new int[][]{
                {1,2}, {3,4},{5,6},{7,8}
        })); // 4

        System.out.println(s.findMinArrowShots(new int[][]{
                {1,2}, {2,3},{3,4},{4,5}
        })); // 2

        Random random = new Random();
        System.out.print("[");
        for (int i = 0; i < 100000; i++) {
            int rand = random.nextInt();
            int rand2 = random.nextInt();
            while (rand2 > rand) {
                rand2 = random.nextInt();
            }
            System.out.printf("[%d,%d],", rand2, rand);
        }
        System.out.print("]");*/
    }
}
