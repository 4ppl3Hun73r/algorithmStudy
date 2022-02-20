package y2022.feb;

import model.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/swap-nodes-in-pairs/
public class Solution0216 {

    public ListNode swapPairs(ListNode head) {
        /*
        Node 순서 변경
        a -> b -> c -> d
        b -> a -> d -> c

        a -> b -> c
        b -> a -> c

        a
        a


        b
        a

        t
        d -> c
        b -> a -> t==d -> c
        t

        return t;
         */

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        if (stack.size() % 2 == 1) {
            temp = stack.pop();
        }

        while (!stack.isEmpty()) {
            ListNode two = stack.pop();
            ListNode one = stack.pop();

            one.next = temp;
            two.next = one;

            temp = two;
        }

        return temp;
    }
}

