package y2021.aug;

import java.util.Stack;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3920/
public class Solution0827 {

    public boolean isValidSerialization(String preorder) {
        // binary tree 가 맞는지 확인
        // original : "9, 3, 4,#,#, 1,#,#, 2,#, 6,#,#"
        // string "9,3,4,#,#,1,#,#,2,1,#,#,6,#,#" - preorder 로 탐색된 결과라고 하고
        // "9,3,4,#,#,1,2,1,#,#,#,#,#,#,#"
        // string "9,3,4,#,#,1,#,#,2,#,#" - preorder 로 탐색된 결과라고 하고
        // # 은 null node 표현

        // 부모1 -> 자식2 꼭 있어야해서.
        // "[][[[]]]" -> stack 에 넣어서. 마지막에 stack.isEmpty()  bbbbb
        // [ ]
        // 9, 3, #, #, 2, #, #
        // 9, #, #
        // #
        // "#" -> true

        // 1 -> 숫자면 2개 더 들어와야함
        //   -> # 이면 추가되는거 없음
        //

        // 9
        String[] parse = preorder.split(",");
        Stack<String> stack = new Stack<>();
        stack.push(parse[0]);
        for(int i = 1; i < parse.length; i++) {
            if (stack.empty()) {
                return false;
            }
            String prev = stack.peek();
            if ("#".equals(prev) && "#".equals(parse[i])) {
                while (!stack.isEmpty() && "#".equals(stack.peek())) {
                    stack.pop(); // "#"
                    if (stack.empty()) {
                        return false;
                    }
                    stack.pop(); // "숫자"
                }
                stack.push("#");
            }
            else {
                stack.push(parse[i]);
            }
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public boolean isValidSerialization2(String preorder) {
        String[] array = preorder.split(",");
        int degree = 1; // tree level
        for(String val: array) {
            degree--;
            if(degree < 0) return false;
            if(!val.equals("#")) degree += 2; // number 가 오면 증가
        }
        return degree == 0;

    }

    // original : "9,3,#,4,#,1,#,#,2,#,6,#,#"
    // "9,3"
    // "9,3"

    // original : "9,3,4,#,#,1,#,#,2,#,6,#,#"
    // original : "9,3,4,#,#,1,#,#,2,#,#"
    // original : "9,3,4,#,#,1,#,#,#"
    // original : "9,3,4,#,#,1,#,#"

    // original : "9,3,4,#,#,1,#,#,2,#,6,#,#"
    // original : "9,3,#,1,#,#,2,#,6,#,#"
    // original : "9,3,#,#,2,#,#"
    // original : "9,#,#"
    // original : "#"

    public static void main(String[] args) {
        Solution0827 s = new Solution0827();
        System.out.println(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
