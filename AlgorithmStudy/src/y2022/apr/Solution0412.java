package y2022.apr;

import java.util.Arrays;

// https://leetcode.com/problems/game-of-life/
public class Solution0412 {
    public void gameOfLife(int[][] board) {
        /*
        board[i][j] == 1 -> live
        board[i][j] == 0 -> dead

        8명의 이웃
        live 이웃 < 2 => 삶 -> 죽음
        2 <= live 이웃 <= 3 => 삶 -> 삶
        live 이웃 > 3 => 삶 -> 죽음
        live 이웃 == 3 => 죽음 -> 살아남
         */
        int[][] dirs = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0,1},
                {1,-1}, {1, 0}, {1,1}
        };

        int row = board.length;
        int col = board[0].length;
        int[][] newBoard = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int live = 0;
                int dead = 0;
                for(int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x == row || y == col) {
                        continue;
                    }
                    if (board[x][y] == 1) {
                        live ++;
                    } else {
                        dead ++;
                    }
                }
                if (live < 2) {
                    newBoard[i][j] = 0;
                } else if (board[i][j] == 1 && (live >= 2 && live <= 3)) {
                    newBoard[i][j] = 1;
                } else if (live > 3) {
                    newBoard[i][j] = 0;
                } else if (board[i][j] == 0 && live == 3) {
                    newBoard[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
    public void gameOfLifeJaehyuk(int[][] board) {
        int[][] dir = new int[][]{
            {-1,0},{1,0},{0,-1},{0,1},
            {1,1},{1,-1},{-1,1},{1,1}
        };

        int y = board.length;
        int x = board[0].length;

        int temp[][] = new int[y][x];

        for(int i = 0; i < y; i++) {
            for(int j = 0 ; j < x; j++) {
                int state = 0;
                int count = 0;
                for(int d = 0; d<8; d++) {
                    int ny = i + dir[d][0];
                    int nx = j + dir[d][1];

                    if( ny < 0 || nx < 0 || ny>=y || nx>=x)
                        continue;

                    if(board[ny][nx] == 1)
                        count++;
                }

                if( board[i][j] == 0 && count == 3) {
                    state = 1;
                } else if (count > 3) {
                    state = 0;
                } else if(board[i][j] == 1 && (count == 2 || count==3)) {
                    state = 1;
                }  else {
                    state = 0;
                }

                temp[i][j] = state;
            }
        }
        System.out.println(Arrays.deepToString(temp).replaceAll("],", "\n"));

        for(int i = 0 ; i < y; i++) {
            for(int j = 0 ; j < x; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    public void gameOfLifeJymoon(int[][] board) {
        int[][] dir = new int[][]{
                {-1,0},{1,0},
                {0,-1},{0,1},
                {1,1},{1,-1},
                {-1,1},{1,1}
        };

        int y = board.length;
        int x = board[0].length;

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                int neighbors = 0;

                for (int[] d : dir) {
                    int nXPos = i + d[0];
                    int nYPos = j + d[1];

                    if(nXPos >= 0 && nXPos < x && nYPos < y && nYPos >= 0) {
                        if (dir[nXPos][nYPos] == 1) {
                            neighbors++;
                        }
                    }
                }

                /*
        board[i][j] == 1 -> live
        board[i][j] == 0 -> dead

        8명의 이웃
        live 이웃 < 2 => 삶 -> 죽음
        2 <= live 이웃 <= 3 => 삶 -> 삶
        live 이웃 > 3 => 삶 -> 죽음
        live 이웃 == 3 => 죽음 -> 살아남
         */
                int status = board[i][j];

                if(neighbors > 2) {
                    board[i][j] = 0;
                } else if(neighbors >= 2 && neighbors <= 3 && status == 1) {
                    board[i][j] = 1;
                } else if(neighbors > 3) {
                    board[i][j] = 0;
                } else if(neighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}