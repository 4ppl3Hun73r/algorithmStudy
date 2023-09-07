package y2023.sep

import model.ListNode


// https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2023-09-06
class Solution0906 {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val results = arrayOfNulls<ListNode>(k)

        var count = 0
        var node = head
        while (node != null) {
            count++
            node = node.next
        }
        val part = count / k
        var remain = count % k
        var start = head
        for (i in 0 until k) {
            if (start == null) {
                results[i] = null
                continue
            }
            results[i] = start
            var prev = start
            for (j in 0 until part + if (remain > 0) 1 else 0) {
                prev = start
                start = start!!.next
            }
            prev!!.next = null
            remain--
        }

        return results
    }
}