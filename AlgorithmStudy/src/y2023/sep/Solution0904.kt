package y2023.sep

import model.ListNode

// https://leetcode.com/problems/linked-list-cycle/?envType=daily-question&envId=2023-09-04
class Solution0904 {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }

        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next.next
            if (slow == fast) {
                return true
            }
        }
        return false
    }
}