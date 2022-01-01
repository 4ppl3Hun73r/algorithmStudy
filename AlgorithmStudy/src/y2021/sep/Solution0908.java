package y2021.sep;

import model.ListNode;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3966/
public class Solution0908 {

    public ListNode reverseList(ListNode head) {
        // linked list 뒤집기
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode nextNode = current.next;

            current.next = prev;
            prev = current;

            current = nextNode;
        }

        return prev;
    }
}