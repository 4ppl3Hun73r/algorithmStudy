package nov;

import model.GridCodec;

// https://leetcode.com/problems/unique-paths-iii/
public class Solution1102 {
    int result;
    boolean[][] visited;

    public int uniquePathsIII(int[][] grid) {
        // -1 장애물, 0 빈칸, 1 시작 지점, 2 종료 지점
        // 1에서 시작해서 2까지, 모든 0을 다 지나가는 유니크한 경로의 수
        // Array, Backtracking, Bit Manipulation, Matrix
        // S -> E
        // 1 <= m, n <=20
        // 1 <= m * n <= 20
        int r = grid.length;
        int c = grid[0].length;
        int[] startPos = new int[2];
        int zeroCount = 0; // 남은 칸수
        // S -> E -> S -> E 갔는데 zeroCount--;
        result = 0;
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
                if (grid[i][j] == 1) {
                    startPos[0] = i;
                    startPos[1] = j;
                }
            }
        }

        findPath(grid, startPos[0], startPos[1], zeroCount + 1);
        return result;
    }

    private void findPath(int[][] grid, int r, int c, int zeroCount) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || visited[r][c] || grid[r][c] == -1) {
            return ;
        }

        if(grid[r][c] == 2) {
            if (zeroCount == 0) {
                result++;
            }
            return ;
        }

        visited[r][c] = true;
        findPath(grid, r - 1, c, zeroCount - 1);
        findPath(grid, r + 1, c, zeroCount - 1);
        findPath(grid, r, c - 1, zeroCount - 1);
        findPath(grid, r, c + 1, zeroCount - 1);
        visited[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        Solution1102 s = new Solution1102();
        GridCodec g = new GridCodec();
        System.out.println(s.uniquePathsIII(g.getIntGrid("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]"))); // 2
        System.out.println(s.uniquePathsIII(g.getIntGrid("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]"))); // 4
        System.out.println(s.uniquePathsIII(g.getIntGrid("[[0,1],[2,0]]"))); // 0
        System.out.println(s.uniquePathsIII(g.getIntGrid("[[1,0,0,0,0],[0,-1,0,0,0],[0,0,0,2,-1]]"))); // 0
        System.out.println(s.uniquePathsIII(g.getIntGrid("[[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,2]]"))); // 20
        System.out.println(s.uniquePathsIII(g.getIntGrid("[[1,0,0,0,0],[0,0,-1,0,0],[0,0,-1,0,0],[0,0,0,0,2]]"))); // 20
    }
}
