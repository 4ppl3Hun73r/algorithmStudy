package y2023.jan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
public class Solution0111 {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Set<Integer>> map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int min = 0;
        for (Integer child : map.get(0)) {
            min += dfs(child, 0, map, hasApple);
        }

        return min;

    }

    private int dfs(int n, int parent, List<Set<Integer>> map, List<Boolean> hasApple) {

        int subCnt = 0;
        if (hasApple.get(n)) {
            // 사과가 있으면
            subCnt = 2;
        }

        int childCnt = 0;
        for (Integer child : map.get(n)) {
            if (child != parent) {
                childCnt += dfs(child, n, map, hasApple);
            }
        }

        if (childCnt != 0) {
            subCnt = childCnt + 2;
        }

        return subCnt;
    }

    public static void main(String[] args) throws Exception {
        Solution0111 s = new Solution0111();

        System.out.println(s.minTime(7, new int[][]{
                {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        }, List.of(false,false,true,false,true,true,false)));
    }

}
