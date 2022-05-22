package problems;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumLinesToRepresentALineChart {

    public int minimumLines(int[][] stockPrices) {

        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        /*
        int ans = 0;
        double degree = 0;
        for (int i = 1; i < stockPrices.length; i++) {
            int[] l = stockPrices[i - 1];
            int[] r = stockPrices[i];
            double dig = (double)(r[0] - l[0]) / (double)(r[1] - l[1]);
            System.out.println(r[0] - l[0]);
            System.out.println(r[1] - l[1]);
            System.out.println(dig);

            if (degree != dig) {
                ans++;
            }
            degree = dig;
        }*/


        /*
            x0    x1    x2

            (x1 - x0) / (y1 - y0) = (x2 - x1) / (y2 - y1)
            (x1 - x0) * (y2 - y1) = (x2 - x1) * (y1 - y0)
         */
        int ans = 1;
        int[] p0 = stockPrices[0];
        for (int i = 2; i < stockPrices.length; i++) {
            int[] p1 = stockPrices[i - 1];
            int[] p2 = stockPrices[i];

            if  ((p1[0] - p0[0]) * (p2[1] - p1[1]) == (p2[0] - p1[0]) * (p1[1] - p0[1])) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumLinesToRepresentALineChart m = new MinimumLinesToRepresentALineChart();

        // double dig = (double)(r[0] - l[0]) / (double)(r[1] - l[1]);
        // if (degree != dig) ... => 아래 케이스에서 오류 발생
        System.out.println(m.minimumLines(new int[][]{
                {1, 1},
                {500000000, 499999999},
                {1000000000, 999999998}
        }));

    }
}
