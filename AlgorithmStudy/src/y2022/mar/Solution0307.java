package y2022.mar;

import model.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class Solution0307 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        l1 + l2
         조건은 그냥 정렬 순서에 맞게
         1 -> 2 -> 3
         3 -> 4 -> 5

         1 -> 2 -> 3 -> 3 -> 4 -> 5

         [0 ~ 50]
         -100 <= Node.val <= 100
         */

        ListNode newHead = new ListNode(-1000);
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }

        return newHead.next;
    }
}
