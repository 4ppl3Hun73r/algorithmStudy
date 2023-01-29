package y2022.dec;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class Solution1217 {

    Set<String> operators = new HashSet<>();


    public int evalRPN(String[] tokens) {

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            stack.push(token);
        }

        return evalRPN(stack);
    }

    private int evalRPN(Stack<String> tokens) {
        if (tokens.isEmpty()) {
            return 0;
        }

        String token = tokens.pop();

        if (operators.contains(token)) {
            int right = evalRPN(tokens);
            int left = evalRPN(tokens);

            if (token.equals("+")) {
                return left + right;
            } else if (token.equals("-")) {
                return left - right;

            } else if (token.equals("*")) {
                return left * right;
            } else if (token.equals("/")) {
                return left / right;
            }
        } else {
            return Integer.parseInt(token);
        }

        return 0;
    }
}
