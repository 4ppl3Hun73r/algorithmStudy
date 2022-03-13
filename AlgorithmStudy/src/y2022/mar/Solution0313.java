package y2022.mar;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class Solution0313 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (map.get(c) != top) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
