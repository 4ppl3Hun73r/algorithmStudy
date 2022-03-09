package problems;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        /*
        0부터 n까지 노드가 있을때

        connections 로 연결되어 있음 connections[i][0] -> connections[i][1] 방향성이 있음

        최소한으로 connection의 방향을 바꿔서 모든 노드가 0으로 도달할수 있게 만들어야 함
        노드끼리는 하나의 연결만 가짐.

        0 으로 들어오는걸 방향을 바꿈.
        0 오르 들어오는 애들로 한번더 반복
         */

        List<List<Integer>> connectionList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            connectionList.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            connectionList.get(connection[0]).add(connection[1]);
            connectionList.get(connection[1]).add(-connection[0]); // 역방향은 음수로 처리
        }

        boolean[] visited = new boolean[n];

        return dfs(connectionList, visited, 0);
    }

    private int dfs(List<List<Integer>> connectionList, boolean[] visited, int from) {
        int changeCnt = 0;
        visited[from] = true;

        List<Integer> connection = connectionList.get(from);
        for (Integer to : connection) {
            if (!visited[Math.abs(to)]) {
                changeCnt += dfs(connectionList, visited, Math.abs(to))
                        + (to > 0 ? 1 : 0);
            }
        }

        return changeCnt;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero r = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();

        System.out.println(r.minReorder(6, new int[][]{
                {0,1},{1,3},{2,3},{4,0},{4,5}
        }));
    }
}
