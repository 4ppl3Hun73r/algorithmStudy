package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        result.add("()");

        for (int i = 0; i < n - 1; i++) {
            String s = result.get(i);



        }

        return result;
    }

}

// n : 3, "((()))","(()())","(())()","()(())","()()()"
// n : 2, "()()", "(())"
// n : 1, "()"
