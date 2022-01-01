package y2021.aug;


import java.util.*;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3907/
public class Solution0823 {
    int mod = (int) (1e9) + 7;
    // [[0,0,2,2],[1,0,2,3],[1,0,3,1], [4,0,5,6]]
    // x => 0, 1, 2, 3, 4 =>
    // y => 0, 1, 2, 3 => 3
    // 3 + 3 = 6
    // ㅡㅁㅁ
    // ㅇㅂㅁ     min(ㅇx2, ㅁx1), max(ㅇx1, ㅁx2)
    // ㅡㅁㅁ
    public int rectangleArea(int[][] rectangles) {
        long result = 0;

        List<int[]> recList = new ArrayList<>();
        for (int[] rec : rectangles) {
            addRectangle(recList, rec, 0);
        }

        for (int[] r : recList) {
            result += ((long)(r[2]- r[0]) * (long)(r[3] - r[1]));
        }

        return (int) (result % mod);
    }

    private void addRectangle(List<int[]> recList, int[] curRec, int start) {
        if (start >= recList.size()) {
            recList.add(curRec);
            return;
        }

        int[] r = recList.get(start);

        if (curRec[2] <= r[0] || curRec[3] <= r[1]
            || curRec[0] >= r[2] || curRec[1] >= r[3]) {
            addRectangle(recList, curRec, start + 1);
            return ;
        }

        if (curRec[0] < r[0]) {
            addRectangle(recList, new int[] { curRec[0], curRec[1], r[0], curRec[3]}, start + 1);
        }
        if (curRec[2] > r[2]) {
            addRectangle(recList, new int[] { r[2], curRec[1], curRec[2], curRec[3]}, start + 1);
        }
        if (curRec[1] < r[1]) {
            addRectangle(recList, new int[] { Math.max(r[0], curRec[0]), curRec[1], Math.min(r[2], curRec[2]), r[1]}, start + 1);
        }
        if (curRec[3] > r[3]) {
            addRectangle(recList, new int[] { Math.max(r[0], curRec[0]), r[3], Math.min(r[2], curRec[2]), curRec[3]}, start + 1);
        }

    }

    private int[] getDupArea(int[] r1, int[] r2) {
        int x0 = Math.max(r1[0], r2[0]);
        int x1 = Math.min(r1[2], r2[2]);
        int y0 = Math.max(r1[1], r2[1]);
        int y1 = Math.min(r1[3], r2[3]);
        long x = x1 - x0;
        long y = y1 - y0;

        long area = 0;
        if ( x > 0 && y > 0) {
            return new int[] {x0, y0, x1, y1};
        }

        return null;
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


    public int rectangleArea2(int[][] rectangles) {

        Map<Integer, List<int[]>> rectByX = new HashMap<>();

        // 첫번째 인자가 우선이면 1, 같으면 0, 첫번째 인자가 나중이면 -1
        Arrays.sort(rectangles, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[2] < o2[2]) {
                return -1;
            } else if (o1[3] < o2[3]) {
                return -1;
            }
            return 1;
        });

        for (int[] rect : rectangles) {

            int leftX = rect[0];
            int rightX = rect[2];

            for (int i = leftX; i < rightX; i++) {

                if (!rectByX.containsKey(i)) {
                    rectByX.put(i, new ArrayList<>());
                }
                rectByX.get(i).add(rect);
            }
        }

        long count = 0;

        for (Integer k : rectByX.keySet()) {

            List<int[]> vals = rectByX.get(k);

            int maxY = 0;

            for (int[] rect : vals) {
                int topY = rect[3];

                if (topY > maxY) {
                    count += topY - maxY;
                    maxY = topY;
                }
            }

        }

        return (int)(count % mod);
    }


}
