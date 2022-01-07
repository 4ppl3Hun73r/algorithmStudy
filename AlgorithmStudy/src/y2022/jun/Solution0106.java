package y2022.jun;

import java.util.TreeMap;

// https://leetcode.com/problems/car-pooling/
public class Solution0106 {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
        trips = [[2,1,5],[3,3,7]], capacity = 4 , false
        trips = [[2,1,5],[3,5,7],[2,1,5]], capacity = 5, true
        trips[0] -> 타는 사람
        trips[1] -> 타는 정거장
        trips[2] -> 내리는 정거장

        1 <= trips.length <= 1000
        0 <= fromi < toi <= 1000
        trips[numP, from, to]
         */
        int[] station = new int[1001];
        for (int[] trip : trips) {
            station[trip[1]] += trip[0];
            station[trip[2]] -= trip[0]; //
        }
        int c = 0;
        // O(1000) -> O(1)
        for (int s : station) {
            c += s; // 음수도 될수 있어서

            if (c > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        // O(N) ->
        TreeMap<Integer, Integer> stationPa = new TreeMap<>(); // insert -> logN
        for (int[] trip : trips) { // N
            int station = trip[1];
            stationPa.put(station, stationPa.getOrDefault(station, 0) + trip[0]);

            station = trip[2];
            stationPa.put(station, stationPa.getOrDefault(station, 0) - trip[0]);
        }

        int c = 0;
        for (Integer key : stationPa.keySet()) {
            c += stationPa.get(key); // 음수도 될수 있어서
            if (c > capacity) {
                return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/car-pooling/discuss/317869/Java-5ms-solution-with-sorted-array-and-PriorityQueue
    /*
    0
    1   2
    2   3
    3   4
    4      -1
    5
    6
     */
    public static void main(String[] args) throws Exception {
        Solution0106 s = new Solution0106();

        System.out.println(
                s.carPooling2(new int[][]{
                        {2,1,5}, {3,3,7}
                }, 4));

        System.out.println(
            s.carPooling2(new int[][]{
                {2,1,5}, {3,3,7}
            }, 5));
    }
}
