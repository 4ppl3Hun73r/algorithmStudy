package problems;

import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    continue;
                }
                stack.pop();
            }
            sb.append(c);
        }

        s = sb.toString();
        sb = new StringBuilder();
        stack.clear();
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                if (stack.empty()) {
                    continue;
                }
                stack.pop();
            }
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        MinimumRemoveToMakeValidParentheses m = new MinimumRemoveToMakeValidParentheses();

        System.out.println(m.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}

