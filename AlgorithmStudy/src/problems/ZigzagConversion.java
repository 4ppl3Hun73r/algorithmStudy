package problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        /*
        PAYPALISHIRING, 3

        P   A   H   N
        A P L S I I G
        Y   I   R

        PAY  -> rows 만큼
         P   -> (rows - 2) ~ 0 까지
        ALI  -> rows 만큼
         S
        HIR
         I
        NG

        rows = > 4
        P     I     G
        A   L S   N
        Y A   H I
        P     R

        0     6       12   -> 0, (rows + 2), (rows + rows + 2 + 2)
        1   5 7    11      -> 1, rows + 1, rows + 2, rows + 1 + rows
        2 4   8 10
        3     9
         */
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character>[] queues = new Queue[numRows];
        for (int i = 0; i < numRows; i++) {
            queues[i] = new LinkedList<>();
        }

        int len = s.length();
        int rowInc = 1;
        int rowIdx = 0;
        for (int i = 0; i < len; i++, rowIdx += rowInc) {
            if (rowIdx == numRows) {
                rowIdx = numRows - 2;
                rowInc = -1;
            }
            if (rowIdx == -1) {
                rowIdx = 1;
                rowInc = 1;
            }
            queues[rowIdx].add(s.charAt(i));
        }

        for (int i = 0; i < numRows; i++) {
            while (!queues[i].isEmpty()) {
                sb.append(queues[i].poll());
            }
        }

        return sb.toString();
    }
}
