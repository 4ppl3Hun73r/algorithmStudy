package y2022.apr;

import java.util.Stack;

// https://leetcode.com/problems/baseball-game/
public class Solution0410 {
    public int calPoints(String[] ops) {
        /*
        + -> 두개의 값을 더함
        D -> 바로 앞 값을 * 2
        C -> 바로 앞 값을 제거
         */

        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                int prev = stack.pop();
                int pprev = stack.peek();

                stack.push(prev);
                stack.push(prev + pprev);
            } else if ("D".equals(op)) {
                int prev = stack.peek();
                stack.push(prev * 2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op, 10));
            }
        }

        int cal = 0;
        while (!stack.isEmpty()) {
            cal += stack.pop();
        }

        return cal;
    }
}
