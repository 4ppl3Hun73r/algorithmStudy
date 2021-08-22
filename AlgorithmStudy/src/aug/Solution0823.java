package aug;


// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3907/
public class Solution0823 {
    int mod = (int) (1e9) + 7;

    public int rectangleArea(int[][] rectangles) {
        long result = 0;

        for (int[] rect : rectangles) {
            result += getArea(rect);
        }

        int len = rectangles.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                result -= getDupArea(rectangles[i], rectangles[j]);
            }
        }

        return (int) (result % mod);
    }


    private long getDupArea(int[] r1, int[] r2) {
        long x = Math.min(r1[2], r2[2]) - Math.max(r1[0], r2[0]);
        long y = Math.min(r1[3], r2[3]) - Math.max(r1[1], r2[1]);

        long area = 0;
        if ( x > 0 && y > 0) {
            area = x * y;
        }

        return area;
    }

    private long getArea(int[] r) {
        long x = r[2] - r[0];
        long y = r[3] - r[1];

        return x * y;
    }

    public static void main(String[] args) {
        Solution0823 s = new Solution0823();

        int[][] rectangles = new int[][] {
                {0,0,2,2},
                {1,0,2,3},
                {1,0,3,1}
        };

        System.out.println(s.rectangleArea(rectangles)); // 6
/*
        rectangles = new int[][] {
                {0,0,1000000000,1000000000}
        };
        System.out.println(s.rectangleArea(rectangles));*/
    }


}
