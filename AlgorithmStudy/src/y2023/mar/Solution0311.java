package y2023.mar;

import model.ListNode;
import model.TreeNode;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
public class Solution0311 {



    public TreeNode sortedListToBST(ListNode head) {

        // 가운데 기준으로 자르기, 왼쪽부터 채우기

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }


        ListNode slow = head;
        ListNode fast = slow.next.next;

        // 중간 찾기
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.next.val);
        ListNode right = slow.next.next;
        slow.next = null; // 왼쪽 연결 끊기

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(right);


        return root;
    }
}
