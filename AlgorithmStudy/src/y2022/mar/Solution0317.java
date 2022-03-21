package y2022.mar;


import java.util.Stack;

// https://leetcode.com/problems/score-of-parentheses/
public class Solution0317 {
    public int scoreOfParentheses(String s) {
        /*
        () -> 1점
        ()() -> 1 + 1 -> 2점
        (()) -> 2 * 1 -> 2점
        (()()) -> 2 * ( 1 + 1) -> 4점

        (()()()()) -> 8

        ((((((((((((((((((((((((()))))))))))))))))))))))))
       0000000000000000000008

         */

        Stack<Integer> stack = new Stack<>();
        int len = s.length();


        stack.push(0);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                int top2 = stack.pop();

                stack.push(top2 + Math.max(2 * top, 1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Solution0317 s = new Solution0317();

        //System.out.println(s.scoreOfParentheses("(()()()())"));
        System.out.println(s.scoreOfParentheses("((((((((((((((((((((((((()))))))))))))))))))))))))"));

    }
}
