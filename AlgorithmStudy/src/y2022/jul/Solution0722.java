package y2022.jul;

import model.ListNode;

// https://leetcode.com/problems/partition-list/
public class Solution0722 {
    public ListNode partition(ListNode head, int x) {
        // x보다 작은건 왼쪽
        // x보가 크거나 같은건 오른쪽
        // 순서는 유지되어야 함

        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        ListNode leftEnd = left;
        ListNode rightEnd = right;

        while (head != null) {
            if (head.val < x) {
                leftEnd.next = head;
                leftEnd = leftEnd.next;
            } else {
                rightEnd.next = head;
                rightEnd = rightEnd.next;
            }
            head = head.next;
        }

        rightEnd.next = null;
        leftEnd.next = right.next;

        return left.next;
    }
}
