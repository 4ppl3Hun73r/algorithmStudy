package contest;

import java.util.*;

public class Contest7 {

    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        Map<Integer, List<Integer>> bombMap = new HashMap<>();

        // bombs의 폭발 범위 안에 있는거 찾
        for (int i = 0; i < bombs.length; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            double r1 = bombs[i][2];
            bombMap.put(i, new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {
                if (i ==j) {
                    continue;
                }
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

                if (dist <= r1) {
                    bombMap.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[len];
        int max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max, dfs(i, visited, bombMap));
            Arrays.fill(visited, false);
        }
        // System.out.println(Arrays.toString(parent));

        return max;
    }

    private int dfs(int i, boolean[] visited, Map<Integer, List<Integer>> bombMap) {
        if(visited[i]) {
            return 0;
        }
        visited[i] = true;
        int ans = 1;
        for(int j : bombMap.get(i)){
            ans += dfs(j, visited, bombMap);
        }
        return ans;
    }

    public static void main(String[] args) {
        Contest7 c = new Contest7();

        System.out.println(c.maximumDetonation(new int[][]{
                {855,82,158},
                {17,719,430},
                {90,756,164},
                {376,17,340}

        }));

        /*System.out.println(c.maximumDetonation(new int[][]{
                {1,1,5},
                {10,10,5}
        }));*/

    }
}
