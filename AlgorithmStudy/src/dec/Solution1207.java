package dec;

import model.ListNode;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class Solution1207 {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
