package problems;

import model.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1, head);

        ListNode node = newHead;
        while (node.next != null && node.next.next != null) {
            ListNode one = node.next;
            ListNode two = one.next;
            ListNode three = two.next;

            node.next = two;
            two.next = one;
            one.next = three;

            node = one;
        }

        return newHead.next;
    }
}
