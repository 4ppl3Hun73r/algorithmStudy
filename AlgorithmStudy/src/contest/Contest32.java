package contest;

public class Contest32 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int r = grid.length;
        int c = grid[0].length;

        int rowMin = Integer.MAX_VALUE;
        int colMin = Integer.MAX_VALUE;


        for (int i = 0; i < r; i++) {
            int width = 0;
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    width++;
                } else {
                    if (width != 0) {
                        rowMin = Math.min(rowMin, width);
                    }
                    width = 0;
                }
            }
            if (width != 0) {
                rowMin = Math.min(rowMin, width);
            }
        }

        for (int i = 0; i < c; i++) {
            int height = 0;
            for (int j = 0; j < r; j++) {
                if (grid[j][i] == 0) {
                    height++;
                } else {
                    if (height != 0) {
                        colMin = Math.min(colMin, height);
                    }
                    height = 0;
                }
            }
            if (height != 0) {
                colMin = Math.min(colMin, height);
            }
        }

        if (stampHeight > colMin || stampWidth > rowMin) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Contest32 c = new Contest32();

        /*System.out.println(c.possibleToStamp(new int[][]{
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
        }, 4, 3));*/

        System.out.println(c.possibleToStamp(new int[][]{
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,1}
        }, 2, 2));

        /*
        [[0,0,0,0,0],[0,0,0,0,0],[0,0,1,0,0],[0,0,0,0,1],[0,0,0,1,1]]
2
2
         */
    }
}
