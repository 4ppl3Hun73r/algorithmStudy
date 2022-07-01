package y2022.jul;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-units-on-a-truck/
public class Solution0701 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        /*
        boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]

        트럭에 넣을 수 있는 최대의 박스 수

        가장 많은 무게를 싫을 수 있게 박스를 트럭에 싣어야함.
         */

        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });

        int maxUnit = 0;

        for (int[] boxType : boxTypes) {
            int box = boxType[0];
            int unit = boxType[1];

            if (box <= truckSize) {
                truckSize -= box;
                maxUnit += (unit * box);
            } else {
                maxUnit += (truckSize * unit);
                break;
            }
        }

        return maxUnit;
    }
}
