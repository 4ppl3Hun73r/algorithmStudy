package y2023.jul

import model.ListNode
import java.util.*

// https://leetcode.com/problems/add-two-numbers-ii/
class Solution0717 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        /*
        StringBuilder -> Long.valueOf() -> X

        list 를 뒤집은 다음에
        더해 나가는거
         */

        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()

        var l1 = l1
        var l2 = l2
        while (l1 != null) {
            stack1.push(l1.`val`)
            l1 = l1.next
        }

        while (l2 != null) {
            stack2.add(l2.`val`)
            l2 = l2.next
        }


        val stack3 = Stack<Int>()
        var carry = 0
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            val l = if (stack1.isNotEmpty()) stack1.pop() else 0
            val r = if (stack2.isNotEmpty()) stack2.pop() else 0

            val sum = l + r + carry
            carry = (sum / 10).toInt()

            stack3.push(sum % 10)
        }
        
        if (carry != 0) {
            stack3.push(carry)
        }
        
        val root = ListNode()
        var temp = root
        while (stack3.isNotEmpty()) {
            temp.next = ListNode(stack3.pop())
            temp = temp.next
        }
        
        return root.next
    }
}
