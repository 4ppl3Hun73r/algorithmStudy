package y2023.feb;

import java.util.Arrays;

// https://leetcode.com/problems/zigzag-conversion/description/
public class Solution0203 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        Character[][] array = new Character[numRows][s.length()];


        int dirs[][] = {{1, 0},{-1,1}};
        int row = 0, col = 0;
        int dir = 0;
        for (char c : s.toCharArray()) {
            array[row][col] = c;

            row = dirs[dir][0] + row;
            col = dirs[dir][1] + col;
            if(row == numRows - 1) {
                dir = 1;
            } else if (row == 0) {
                dir = 0;
            }
        }
        System.out.println(Arrays.deepToString(array).replaceAll("],", "\n"));

        StringBuilder sb = new StringBuilder();
        for (Character[] characters : array) {
            for (Character character : characters) {
                if (character == null) {
                    continue;
                }
                sb.append(character);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Solution0203 s = new Solution0203();

        //System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 1));
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1 || numRows >= s.length()) {
                return s;
            }

            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }

            int index = 0, step = 1;
            for (char c : s.toCharArray()) {
                rows[index].append(c);
                if (index == 0) {
                    step = 1;
                } else if (index == numRows - 1) {
                    step = -1;
                }
                index += step;
            }

            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) {
                res.append(row);
            }

            return res.toString();
        }
    }
}
