package y2022.oct;

import model.GridCodec;

// https://leetcode.com/problems/image-overlap/
public class Solution1027 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        /*
        30 X 30

        [ ][ ][ ]
        [ ][ ][ ]
        [ ][ ][ ]

        n * n * n * (n * (n-1....)) =>
         */
        int n = img1.length;
//   img2
//   [ ][ ][ ]
//   [ ][ ][ ]
//   [ ][ ][V][ ][ ]
//         [ ][ ][ ]
//         [ ][ ][ ] img1

        int result = 0;
        for(int r = -n; r < n; r++) {
            for(int c = -n ; c < n; c++) {
                result = Math.max(result, count(img1,img2, r, c));
            }
        }

        return result;
    }

    private int count(int[][] img1, int[][] img2, int img2StartI, int img2StartJ) {

        int n = img1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + img2StartI < 0 || j + img2StartJ < 0 || i + img2StartI >= n || j + img2StartJ >= n) {
                    continue;
                }
                if (img1[i][j] == 1 && img2[img2StartI + i][img2StartJ + j] == 1) {
                    count++;
                }
            }
        }
        /*
        img1[0][0] == img2[1][1]
        img1[0][4] == img2[4][0]
         */

        return count;
    }

    public static void main(String[] args) throws Exception {
        Solution1027 s = new Solution1027();

        GridCodec g = new GridCodec();

        System.out.println(s.largestOverlap(g.getIntGrid("[[0,0,0,0,1],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]"),
                g.getIntGrid("[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[1,0,0,0,0]]")));
    }
}
/*
[[0,0,0,0,1],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[1,0,0,0,0]]

[0,0,0,0,1]
[0,0,0,0,0]
[0,0,0,0,0]
[0,0,0,0,0]
[0,0,0,0,0]

[0,0,0,0,0]
[0,0,0,0,0]
[0,0,0,0,0]
[0,0,0,0,0]
[1,0,0,0,0]
 */