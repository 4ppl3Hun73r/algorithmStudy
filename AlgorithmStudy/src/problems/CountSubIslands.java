package problems;

import model.GridCodec;

// https://leetcode.com/problems/count-sub-islands/
public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        /*
        grid2 에서 섬 수를 세는데
        해당 섬 영역에 grid1 의 물이 포함되어 있으면 안된다.
         */

        int result = 0;

        for(int i = 0; i < grid2.length; i++) {
            for(int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    //System.out.println(i + " - " + j);
                    if (switchLands(grid2, i, j, grid1)) {
                        result++;
                    }
                }
            }
        }

        //System.out.println(Arrays.deepToString(grid2).replaceAll("],", "\n"));

        return result;


    }

    private boolean switchLands(int[][] grid2, int i, int j, int[][] grid1) {
        if (i < 0 || j < 0 || i == grid2.length || j == grid2[i].length || grid2[i][j] != 1) {
            return true;
        }

        grid2[i][j] = 2;
        // System.out.println(i + " : " + j);

        boolean result = switchLands(grid2, i - 1, j, grid1);
        result &= switchLands(grid2, i + 1, j, grid1);
        result &= switchLands(grid2, i, j - 1, grid1);
        result &= switchLands(grid2, i, j + 1, grid1);

        return result && grid1[i][j] == 1;
    }

    public static void main(String[] args) throws Exception {
        GridCodec codec = new GridCodec();
        CountSubIslands c = new CountSubIslands();

        /*System.out.println(c.countSubIslands(
                codec.getIntGrid("[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]"),
                codec.getIntGrid("[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]"))
        );*/

        System.out.println(c.countSubIslands(
                codec.getIntGrid("[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]"),
                codec.getIntGrid("[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]"))
        );
    }
}
