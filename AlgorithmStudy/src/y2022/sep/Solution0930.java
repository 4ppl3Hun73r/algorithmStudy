package y2022.sep;

import java.util.*;

// https://leetcode.com/problems/the-skyline-problem/
public class Solution0930 {
    public List<List<Integer>> getSkylinef(int[][] buildings) {
        /*
        buildings 정보를 가지고
        skyline을 만들어라


        |    #
        |    #$
        |   @#$
        |   @#$
        |--------------
         */
//[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]


        /*
          2 - 10
          3 - 15
          5 - 15
          7 - 15
          9 - 10
         12 - 12
         15 - 10
         19 - 10
         20 - 10
         24 - 8
         */
//[2 ,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]
return null;
    }



    class Point {
        int x;
        int y;
        boolean start;

        public Point(int x, int y, boolean start) {
            this.x = x;
            this.y = y;
            this.start = start;
        }
    }

    // https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space)
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]});
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for(int[] h:height) {
            if(h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and
            // previous max height if necessary
            if(prev != cur) {
                result.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution0930 s = new Solution0930();

        System.out.println(s.getSkyline(new int[][]{{2,9,10}, {3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}
