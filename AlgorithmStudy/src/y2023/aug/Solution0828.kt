package y2023.aug

import java.util.*

// https://leetcode.com/problems/implement-stack-using-queues/
class Solution0828 {
    class MyStack() {

        private val queue: Queue<Int> = LinkedList()

        fun push(x: Int) {
            queue.offer(x)
            var size = queue.size
            while (size > 1) {
                queue.offer(queue.remove())
                size--
            }

        }

        fun pop(): Int {
            return queue.poll()
        }

        fun top(): Int {
            return queue.peek()
        }

        fun empty(): Boolean {
            return queue.isEmpty()
        }
    }
}
