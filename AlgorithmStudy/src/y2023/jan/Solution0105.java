package y2023.jan;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class Solution0105 {

    public int findMinArrowShots(int[][] points) {
        /*
         |-----------|
                        |--------|
                  |--------|
              |--------------------|
                              |--------|
------------------------------------------------
         |-----------|
            |---|
              |--------------------|
                 |--|
                  |--------|
                        |--------|
                              |--------|
------------------------------------------------

         |-----------|
                  |--------|
                        |--------|
              |--------------------|
                              |--------|
         */

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int shots = 0;

        for (int i = 0; i < points.length; i++) {
            int right = points[i][1];
            for (int j = i + 1; j < points.length; j++, i++) {
                int[] point = points[j];
                if (right < point[0]) {
                    break;
                }
                right = Math.min(right, point[1]);

            }
            shots++;
        }


        return shots;
    }
}
