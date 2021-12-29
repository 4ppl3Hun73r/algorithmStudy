package dec;

import model.ListNode;

// https://leetcode.com/problems/middle-of-the-linked-list/submissions/
public class Solution1228 {
    public ListNode middleNode(ListNode head) {
        // count -> loop : count / 2 -> end
        // O(n)
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        count = count / 2;
        node = head;
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        // return node;

        // two pointer -> linked list 단방향
        // O(n / 2) -> O(n)
        //

        //
        // 1  ->  2  ->  3  ->  4  -> 5
        //               ^
        //                            ^

        // 1

        // 1 -> 2 -> 3 -> 4
        //      ^
        //           ^

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

        // o ms
        ListNode slow = head;
        ListNode fast = head;// half -> fast 는 2칸을 가고, slow는 한칸을 가면
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
