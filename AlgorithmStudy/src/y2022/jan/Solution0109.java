package y2022.jan;

// https://leetcode.com/problems/robot-bounded-in-circle/
public class Solution0109 {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;

        int xd = 0;
        int yd = 1;

        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);

            if (instruction == 'G') {
                x += xd;
                y += yd;
            } else if (instruction == 'L') {
                if (yd == 1) {
                    xd = -1;
                    yd = 0;
                } else if (xd == -1) {
                    xd = 0;
                    yd = -1;
                } else if (yd == -1) {
                    xd = 1;
                    yd = 0;
                } else {
                    xd = 0;
                    yd = 1;
                }
            } else if (instruction == 'R') {
                if (yd == 1) {
                    xd = 1;
                    yd = 0;
                } else if (xd == 1) {
                    xd = 0;
                    yd = -1;
                } else if (yd == -1) {
                    xd = -1;
                    yd = 0;
                } else {
                    xd = 0;
                    yd = 1;
                }
            }
        }

        if (xd == 0 && yd == 1) {
            if (!(x == 0 && y == 0)) {
                return false;
            }
        }

        // System.out.println(String.format("%d - %d, %d - %d", x, y, xd, yd));

        return true;
    }
}
