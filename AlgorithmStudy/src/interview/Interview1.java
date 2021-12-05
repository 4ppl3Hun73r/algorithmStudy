package interview;

public class Interview1 {
    public int[][] flipAndInvertImage(int[][] image) {
        /*
        Input: image = [[1,1,0],[1,0,1],[0,0,0]]
        Output: [[1,0,0],[0,1,0],[1,1,1]]
        Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
        Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

        [[1,1,0],
         [1,0,1],
         [0,0,0]]

        [[0,1,1],
         [1,0,1],
         [0,0,0]].

        [[1,0,0],
         [0,1,0],
         [1,1,1]]
         */

        for (int i = 0; i < image.length; i++) {
            int left = 0;
            int right = image[i].length - 1;

            while (left < right) {
                swap(image[i], left, right);
                if (image[i][left] == 0) image[i][left] = 1;
                else image[i][left] = 0;
                if (image[i][right] == 0) image[i][right] = 1;
                else image[i][right] = 0;
                left++;
                right--;
            }
            if (left == right) {
                if (image[i][left] == 0) image[i][left] = 1;
                else image[i][left] = 0;
            }
        }

        return image;
    }

    private void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;
    }

}
