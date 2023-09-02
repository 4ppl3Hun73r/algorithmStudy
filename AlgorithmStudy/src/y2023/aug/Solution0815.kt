package y2023.aug

import model.ListNode

// https://leetcode.com/problems/partition-list/
class Solution0815 {
    fun partition(head: ListNode?, x: Int): ListNode? {

        val left = ListNode(-1)
        val right = ListNode(-1)

        var leftEnd = left
        var rightEnd = right

        var head = head
        while (head != null) {
            if (head.`val` < x) {
                leftEnd.next = head
                leftEnd = leftEnd.next
            } else {
                rightEnd.next = head
                rightEnd = rightEnd.next
            }
            head = head.next
        }
        rightEnd.next = null
        leftEnd.next = right.next

        return left.next
    }
}