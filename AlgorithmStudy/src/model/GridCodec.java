package model;

public class GridCodec {

    public int[][] getIntGrid(String grid) {
        String[] p = grid.substring(2).substring(0, grid.length() - 4)
                .split("],\\[");

        int row = p.length;
        int col = p[0].split(",").length;

        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] c = p[i].split(",");
            for (int j = 0; j < col; j++) {
                result[i][j] = Integer.parseInt(c[j], 10);
            }

        }

        return result;
    }

    public char[][] getCharGrid(String grid) {
        String[] p = grid.substring(2).substring(0, grid.length() - 4)
                .split("],\\[");

        int row = p.length;
        int col = p[0].split(",").length;

        char[][] result = new char[row][col];

        for (int i = 0; i < row; i++) {
            String[] c = p[i].split(",");
            for (int j = 0; j < col; j++) {
                result[i][j] = c[j].charAt(0);
            }
        }

        return result;
    }


}
