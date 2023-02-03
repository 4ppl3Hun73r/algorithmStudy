package y2023.jan;

import model.GridCodec;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class Solution0126 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //src, dest, price
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // k(stop) = 1 -> 2 step
        // k = 2 -> 2step, 3step 안에서 가장 작은 값이 return value
        // 0 -> 1 -> 2 -> 3 = 400

        // src, price, step
        pq.offer(new int[] {src, 0, 0});

        int ans = -1;
        while(!pq.isEmpty()) {
            /*for (int[] p : pq) {
                System.out.print(Arrays.toString(p));
            }
            System.out.println();*/
            //System.out.println(Arrays.deepToString(visited));
            int currK = pq.peek()[2];
            int to = pq.peek()[0];
            int price = pq.poll()[1];

            if (currK > visited[to] || currK > k + 1) {
                continue;
            }
            visited[to] = currK;
            if (to == dst) {
                ans = price;
                break;
            }

            for (int[] from : graph.get(to)) {
                pq.offer(new int[]{from[0], price + from[1], currK + 1});
            }
        }

        return ans;
    }

    /*

    1 ->10 3 -> 4
      ->1 2 ->1 3

    1 -> (10) 3 -> 4 ->5
    1 -> (1)6 -> (2)7 -> (11)3 -> 4 -> 5
     */

    public static void main(String[] args) throws Exception {
        Solution0126 s = new Solution0126();
        GridCodec g = new GridCodec();

        /*System.out.println(s.findCheapestPrice(4, g.getIntGrid("[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]")
                ,0, 3, 1));

        System.out.println(s.findCheapestPrice(4, g.getIntGrid("[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]")
                ,0, 3, 2));*/

        /*System.out.println(s.findCheapestPrice(13, g.getIntGrid("[[11,12,74],[1,8,91],[4,6,13],[7,6,39],[5,12,8],[0,12,54],[8,4,32],[0,11,4],[4,0,91],[11,7,64],[6,3,88],[8,5,80],[11,10,91],[10,0,60],[8,7,92],[12,6,78],[6,2,8],[4,3,54],[3,11,76],[3,12,23],[11,6,79],[6,12,36],[2,11,100],[2,5,49],[7,0,17],[5,8,95],[3,9,98],[8,10,61],[2,12,38],[5,7,58],[9,4,37],[8,6,79],[9,0,1],[2,3,12],[7,10,7],[12,10,52],[7,2,68],[12,2,100],[6,9,53],[7,4,90],[0,5,43],[11,2,52],[11,8,50],[12,4,38],[7,9,94],[2,7,38],[3,7,88],[9,12,20],[12,0,26],[10,5,38],[12,8,50],[0,2,77],[11,0,13],[9,10,76],[2,6,67],[5,6,34],[9,7,62],[5,3,67]]")
                , 10, 1 , 10));*/

        System.out.println(s.findCheapestPrice(11, g.getIntGrid("[[0,3,3],[3,4,3],[4,1,3],[0,5,1],[5,1,100],[0,6,2],[6,1,100],[0,7,1],[7,8,1],[8,9,1],[9,1,1],[1,10,1],[10,2,1],[1,2,100]]")
                ,0, 2, 4)); // 11
    }
}
