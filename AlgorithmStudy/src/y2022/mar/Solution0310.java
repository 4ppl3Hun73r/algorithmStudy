package y2022.mar;


import model.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class Solution0310 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         l1 2->4->3
         l2 5->6->4
            7->0->8

         l1 9->9->9
         l2 9
            8->0->0->1
         */

        ListNode newHead = new ListNode();

        ListNode iter = newHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            iter.next = new ListNode(sum % 10);

            iter = iter.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            iter.next = new ListNode(carry);
        }

        return newHead.next;
    }
}
