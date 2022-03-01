package problems;

import model.GridCodec;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-closed-islands/
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        /*
        0 -> island
        1 -> water

        closed Island : 완벽하게 물로 감싸져야함 : 외곽의1은 섬이 아님
         */

        int closedIslandCnt = 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    // 탐색 시작
                    if (checkClosedIsland(grid, i, j, visited)) {
                        closedIslandCnt++;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(grid).replaceAll("],", "\n"));

        return closedIslandCnt;

    }

    private boolean checkClosedIsland(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        // 경계에 위치한 칸은 바로 싪패 처리
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
            grid[i][j] = 3;
            return false;
        }
        if (grid[i - 1][j] == 3 || grid[i + 1][j] == 3 || grid[i][j - 1] == 3 || grid[i][j + 1] == 3) {
            grid[i][j] = 3;
            return false;
        }

        // 자기 자신 주위로 4칸 확인
        boolean isClosed = true;
        if (grid[i - 1][j] == 0 && !visited[i - 1][j]) {
            isClosed = isClosed && checkClosedIsland(grid, i - 1, j, visited);
        }
        if (grid[i + 1][j] == 0 && !visited[i + 1][j]) {
            isClosed = isClosed && checkClosedIsland(grid, i + 1, j, visited);
        }
        if (grid[i][j - 1] == 0 && !visited[i][j - 1]) {
            isClosed = isClosed && checkClosedIsland(grid, i, j - 1, visited);
        }
        if (grid[i][j + 1] == 0 && !visited[i][j + 1]) {
            isClosed = isClosed && checkClosedIsland(grid, i, j + 1, visited);
        }

        if (!isClosed) {
            grid[i][j] = 3;
        }

        return isClosed;
    }

    public static void main(String[] args) {
        GridCodec codec = new GridCodec();
        NumberOfClosedIslands n = new NumberOfClosedIslands();

        System.out.println(n.closedIsland(codec.getIntGrid("[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]")));
        System.out.println(n.closedIsland(codec.getIntGrid("[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]")));
        System.out.println(n.closedIsland(codec.getIntGrid("[[1,1,1,1,1,1,0,0],[1,0,0,0,0,1,0,1],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]")));

    }
}

