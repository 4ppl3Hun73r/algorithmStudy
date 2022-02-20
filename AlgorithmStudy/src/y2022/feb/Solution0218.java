package y2022.feb;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class Solution0218 {
    public String removeKdigitsFail(String num, int k) {
        /*
        k 개를 제거해서 가장 작은 수 만들기

        k = 3
        1999111
         ^^^
        1988983912
         ^  ^^
        1888312
        1883912

        1 -> 1
        9 -> 1 , k = 2
        8 -> 1 , k = 1
        8 ->

        k == 10 -> 0
        1988983912

        k = 9  -> 1
        9988983912

        123456789
        987654321

        k = 1
        10200 => 200
        k = 2
        => 0

        k = 10000
        11111......111111
         */
        if (k >= num.length()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int j = 1;
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';

            if (!queue.isEmpty()) {
                int max = queue.peek();
                if (max == n) {
                    queue.poll();
                }
            }
            /*
            1432219

            1 [4,3,2] -> sb[1]
            4 [4,3,2] -> [3, 2, 2] -> sb[1]
            3 [3,2,2] -> [2,2] -> sb[1]
            2 [2,2] -> [2] -> sb[12]
            2 [2] -> [] -> sb[1219]
             */
            while (queue.size() != k && j < num.length()) {
                queue.add(num.charAt(j) - '0');
                j++;
            }

            if (!queue.isEmpty()) {
                int max = queue.peek();
                if (n < max) {
                    sb.append(n);
                } else {
                    k--;
                }
            } else {
                sb.append(n);
            }
        }

        return sb.toString();
    }

    public void monoStack(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] leftMax = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            while (!stack.empty()) {
                if (stack.peek() < n) {
                    stack.pop();
                } else {
                    break;
                }
            }
            leftMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(n);
        }

        stack.clear();
        int[] rightMax = new int[num.length()];
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            while (!stack.empty()) {
                if (stack.peek() < n) {
                    stack.pop();
                } else {
                    break;
                }
            }
            rightMax[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(n);
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == len) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char n = num.charAt(i);
            while (k > 0 && !stack.empty() && stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        // corner case like "1111"
        while (k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }

    public static void main(String[] args) throws Exception {
        Solution0218 s = new Solution0218();

        // System.out.println(s.removeKdigits("1432219", 3)); // 1219
        // System.out.println(s.removeKdigits("1988983912", 3)); // 1883912
        //System.out.println(s.removeKdigits("10200", 3)); // 0
        //
        //System.out.println(s.removeKdigits("987654321", 3)); // 0

        // s.monoStack("1432219", 3);
        // 1  4  3 2 2 1 9
        // -1 -1 4 3 2 2 -1
        // 12 1 9

        // [-1, -1, 9, 8, 9, 9, 8, 9, 9, 9]
        // 1 9 8 8 9 8 3 9 1 2
        //   9 1 8
        // [-1 9 9]


        // [-1, 1, -1, 2, 0]

//        s.monoStack("1988983912", 3);
//        s.monoStack("918", 2);
//        //               "1883912"


        s.removeKdigits("1988983912", 3);
        //                    ^ ^^  ^^^^
        s.removeKdigits("10200", 3);
        //                     ^ ^^ -> k 1남아서
    }
}
