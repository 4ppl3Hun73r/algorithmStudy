package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/maximal-network-rank/
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        /*
        n개의 도시가 존재

        2개의 도시를 묶었을때 연결된 다른 도시들의 수 == 네크워크 랭크
        2개의 돟시가 연결되었으면 1개로 친다.

        2<= n <= 100
         */

        Map<Integer, Set<Integer>> connectMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            connectMap.put(i, new HashSet<>());
        }

        for (int[] road : roads) {
            connectMap.get(road[0]).add(road[1]);
            connectMap.get(road[1]).add(road[0]);
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int aSize = connectMap.get(i).size();
                int bSize = connectMap.get(j).size();
                boolean connectEachOther = connectMap.get(i).contains(j);

                max = Math.max(max, aSize + bSize - (connectEachOther ? 1 : 0));
            }
        }

        System.out.println(connectMap);

        return max;
    }

    public static void main(String[] args) {
        MaximalNetworkRank m = new MaximalNetworkRank();

        System.out.println(m.maximalNetworkRank(5, new int[][]{
                {0,1},
                {0,3},
                {1,2},
                {1,3},
                {2,3},
                {2,4}
        }));
    }
}
