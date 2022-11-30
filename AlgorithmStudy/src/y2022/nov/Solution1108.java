package y2022.nov;

import java.util.Stack;

// https://leetcode.com/problems/make-the-string-great/
public class Solution1108 {
    public String makeGood(String s) {
        // abcdefFEDCBA
        // cC
        // baBA

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char cha = stack.peek();
                if (Character.isUpperCase(c) && Character.isLowerCase(cha)) {
                    if (c == Character.toUpperCase(cha)) {
                        stack.pop();
                        continue;
                    }
                } else if (Character.isLowerCase(c) && Character.isUpperCase(cha)) {
                    if (c == Character.toLowerCase(cha)) {
                        stack.pop();
                        continue;
                    }
                }
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        Solution1108 s = new Solution1108();

        System.out.println(s.makeGood("leEeetcode"));
        System.out.println(s.makeGood("abBAcC"));
        System.out.println(s.makeGood("s"));
        System.out.println(s.makeGood("abcdefFEDCBA"));
        System.out.println(s.makeGood("abddebDBFUEdsbjkafDBf"));
        System.out.println(s.makeGood("aCAaaaaabBbbCccBbbbb"));
    }
}
