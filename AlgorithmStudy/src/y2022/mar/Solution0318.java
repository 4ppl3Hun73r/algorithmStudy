package y2022.mar;


import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/
public class Solution0318 {
    public String removeDuplicateLetters(String s) {

        // smallest lexicographical 로 중복 단어 제거


        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        boolean[] map =  new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphabet[c - 'a']--;
            if (map[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && alphabet[stack.peek() - 'a'] != 0 && c < stack.peek() ) {
                char top = stack.pop();
                map[top - 'a'] = false;
            }

            stack.push(c);
            map[c - 'a'] = true;
        }

        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution0318 s = new Solution0318();

        System.out.println(s.removeDuplicateLetters("bcabc"));
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));

    }
}
