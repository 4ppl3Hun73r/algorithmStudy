package y2022.jul;


import java.util.Arrays;

// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
public class Solution0702 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        /*
        h * w 크기의 케이크가 있을때

        주어진 horizontalCuts, verticalCuts 을 가지고 최대의 크기로 잘라진 조각을 구하라

        가장 긴걸 찾아서 계산 하면 안되나?
         */
        int mod = 1000000007;

        long ans = 0L;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hMax = 0;
        int before = 0;
        for (int horizontalCut : horizontalCuts) {
            hMax = Math.max(hMax, horizontalCut - before);
            before = horizontalCut;
        }
        hMax = Math.max(hMax, h - before);

        int vMax = 0;
        before = 0;
        for (int verticalCut : verticalCuts) {
            vMax = Math.max(vMax, verticalCut - before);
            before = verticalCut;
        }
        vMax = Math.max(vMax, w - before);

        ans = (long)hMax * (long)vMax;


        return (int)(ans % mod);
    }
}
