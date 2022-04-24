package contest;

import java.util.*;

public class Contest99 {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        /*
        1 <= li, xj <= 1000000000
        1 <= hi, yj <= 100
         */

        int max = Integer.MIN_VALUE;
        TreeMap<Integer, List<Integer>> rects = new TreeMap<>();
        for(int[] rect : rectangles) {
            // y가 수가 작으니 y 기준으로 정리 작업 진행
            if (!rects.containsKey(rect[1])) {
                rects.put(rect[1], new ArrayList<>());
            }
            rects.get(rect[1]).add(rect[0]);
            max = Math.max(max, rect[1]); // 최대 y 높이 구해 놓기
        }

        for(int key : rects.keySet()) {
            Collections.sort(rects.get(key)); // x 정렬
        }

        int[] ans = new int[points.length];
        for(int i = 0; i < points.length; i++) {
            if (points[i][1] > max) {
                continue;
            }
            int count = 0;

            // y 축 기준으로 사각형을 가져옴
            for(int key : rects.subMap(points[i][1], max + 1).keySet()) {
                List<Integer> xLists = rects.get(key);

                int pos = Collections.binarySearch(xLists, points[i][0]);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                count += (xLists.size() - pos);

            }

            ans[i] = count;
        }

        return ans;
    }


    public int[] countRectanglesFail(int[][] rectangles, int[][] points) {
        int[] ans = new int[points.length];


        // points 가 몇개의 사각형에 포함되어 있는지?

        // 0 ~ x 사이는 +1개
        // 0 ~ y 사이는 +1개씩 해서 x, y 단위로 계산해놓기

        List<Integer> xLists = new ArrayList<>();
        List<Integer> yLists = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            int l = rectangle[0];
            int h = rectangle[1];

            xLists.add(l);
            yLists.add(h);
        }

        Collections.sort(xLists);
        Collections.sort(yLists);

        int xLen = xLists.size();
        int yLen = yLists.size();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int posX = Collections.binarySearch(xLists, x);
            if (posX < 0) {
                posX = -posX - 1;
            }

            int posY = Collections.binarySearch(yLists, y);
            if (posY < 0) {
                posY = -posY - 1;
            }

            ans[i] = Math.min((xLen - posX) + 1, (yLen - posY) + 1);
        }

        return ans;
    }


    public static void main(String[] args) {
        Contest99 c = new Contest99();
        /*
        [[4,7],[4,9],[8,5],[6,2],[6,4]]
        [[4,2],[5,6]]
        [5,0]
         */

        System.out.println(Arrays.toString(c.countRectangles(new int[][]{{4, 7}, {4, 9}, {8, 5}, {6, 2}, {6, 4}}, new int[][]{{4, 2}, {5, 6}})));

    }
}
