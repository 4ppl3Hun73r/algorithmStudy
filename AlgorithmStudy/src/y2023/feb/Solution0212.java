package y2023.feb;

import java.util.ArrayList;

// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
public class Solution0212 {

    long minFuel = 0;

    public long minimumFuelCost(int[][] roads, int seats) {

        int n = roads.length + 1;

        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            tree[road[0]].add(road[1]);
            tree[road[1]].add(road[0]);
        }

        dfs(tree, seats, 0, 0);


        return minFuel;

    }

    private int dfs(ArrayList<Integer>[] tree, int seats, int current, int parent) {

        int person = 1; // 자기

        for (Integer child : tree[current]) {
            if (child == parent) {
                continue;
            }
            person+= dfs(tree, seats, child, current); // 자식들의 수
        }

        // 자식의 수 == 차량의 수
        // 차량의 수 += 연료
        // 차량의 수랑 seats 를 보고 합침
        // 합친 차량의 수 반환

        if (current != 0) {
            minFuel += (long)Math.ceil((double)person / (double)seats);
        }

        return person;
    }

    public static void main(String[] args) {

        Solution0212 s = new Solution0212();

        System.out.println(s.minimumFuelCost(new int[][]{
                {3,1}, {3,2}, {1,0}, {0,4}, {0,5}, {4,6}
        }, 2));

    }
}
