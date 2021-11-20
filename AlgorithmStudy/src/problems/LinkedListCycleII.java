package problems;

import model.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        int x = -100001;

        while(head != null) {
            if (head.val == x) {
                return head;
            }
            head.val = x;
            head = head.next;
        }

        return null;
    }
}
