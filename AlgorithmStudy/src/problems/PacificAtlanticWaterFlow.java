package problems;

import model.GridCodec;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visitedPacific = new boolean[row][col];
        boolean[][] visitedAtlantic = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(heights, visitedPacific, 0, i);
            dfs(heights, visitedAtlantic, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, visitedPacific, i, 0);
            dfs(heights, visitedAtlantic, i, col - 1);
        }

        //System.out.println(Arrays.deepToString(grid).replaceAll("],", "\n"));

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i == heights.length || j == heights[0].length || visited[i][j]) {
            return ;
        }

        visited[i][j] = true;
        int height = heights[i][j];

        if (i != 0 && height <= heights[i - 1][j]) {
            dfs(heights, visited, i - 1, j);
        }
        if (i != heights.length - 1 && height <= heights[i + 1][j]) {
            dfs(heights, visited, i + 1, j);
        }
        if (j != 0 && height <= heights[i][j - 1]) {
            dfs(heights, visited, i, j - 1);
        }
        if (j != heights[0].length - 1 && height <= heights[i][j + 1]) {
            dfs(heights, visited, i, j + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        GridCodec g = new GridCodec();
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();

        // System.out.println(p.pacificAtlantic(g.getIntGrid("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]")));
        System.out.println(p.pacificAtlantic(g.getIntGrid("[[3,3,3,3,3,3],[3,0,3,3,0,3],[3,3,3,3,3,3]]")));
        // [[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[1,0],[1,2],[1,3],[1,5],[2,0],[2,1],[2,2],[2,3],[2,4],[2,5]]
        /*
        [[3,3,3,3,3,3],
         [3,0,3,3,0,3],
         [3,3,3,3,3,3]]
         */

    }
}
