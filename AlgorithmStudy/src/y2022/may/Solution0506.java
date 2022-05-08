package y2022.may;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class Solution0506 {

    class Node {
        char c;
        int cnt;

        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }


    public String removeDuplicates(String s, int k) {
        char[] arr  = s.toCharArray();
        Stack<Node> stack = new Stack<>();

        for ( char c : arr ) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                stack.peek().cnt++;
            } else {
                stack.push(new Node(c, 1));
            }
            if (stack.peek().cnt == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (int i = 0; i < node.cnt; i++) {
                sb.append(node.c);
            }
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution0506 s = new Solution0506();

        System.out.println(s.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(s.removeDuplicates("nnwssswwnvbnnnbbqhhbbbhmmmlllm", 3));  // "vqm"
    }
}
