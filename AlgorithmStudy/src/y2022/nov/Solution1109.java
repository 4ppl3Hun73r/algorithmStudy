package y2022.nov;

import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/
public class Solution1109 {
    // Monotonic Stack 으로 푸는 문제
    // monotonic stack은 맨날 헷갈리는 듯....
}

class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }
        stack.push(new int[]{price, ans});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */