package y2022.dec;

import model.ListNode;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class Solution1205 {

    public ListNode middleNode(ListNode head) {
        /*
        count : O(n + n / 2) -> O(n)
        f & s : O(n / 2) -> O(n)
         */

        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
