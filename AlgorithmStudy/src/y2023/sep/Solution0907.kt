package y2023.sep

import model.ListNode




// https://leetcode.com/problems/reverse-linked-list-ii/?envType=daily-question&envId=2023-09-07
class Solution0907 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) {
            return head
        }

        val newHead = ListNode(-1, head)
        var temp: ListNode? = newHead
        var prev: ListNode? = newHead
        var next = newHead
        var idx = 0
        var reverse = false
        var leftNode: ListNode? = null
        var leftBeforeNode: ListNode? = null
        while (temp != null) {
            if (idx == right) {
                leftBeforeNode!!.next = temp
                leftNode!!.next = temp.next
                temp.next = prev
                break
            }
            if (reverse) {
                next = temp.next
                temp.next = prev
                prev = temp
                temp = next
                idx++
                continue
            }
            if (idx == left) {
                reverse = true
                leftBeforeNode = prev
                leftNode = temp
            }
            prev = temp
            temp = temp.next
            idx++
        }

        return newHead.next
    }
}

fun main() {
    val list = listOf("a", "b", "c")
    println(list.map { it + "1" })
    println(list.map { it + "2" }.toList())

}