package problems;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || c < 0 || r == image.length || c == image[0].length) {
            return ;
        }

        if (image[r][c] == color) {
            image[r][c] = newColor;

            dfs(image, r - 1, c, color, newColor);
            dfs(image, r + 1, c, color, newColor);
            dfs(image, r, c - 1, color, newColor);
            dfs(image, r, c + 1, color, newColor);
        }
    }


    public static void main(String[] args) {


    }
}
