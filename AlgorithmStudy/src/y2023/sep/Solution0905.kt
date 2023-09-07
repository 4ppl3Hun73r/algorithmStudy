package y2023.sep


// https://leetcode.com/problems/copy-list-with-random-pointer/?envType=daily-question&envId=2023-09-05
class Solution0905 {
    fun copyRandomList(node: Node?): Node? {

        val nodePairMap = mutableMapOf<Node, Node>()
        var temp = node
        while(temp != null) {
            val newNode = Node(temp.`val`)
            nodePairMap[temp] = newNode
            temp = temp.next
        }

        temp = node
        while (temp != null) {
            val newNode = nodePairMap[temp]!!
            newNode.next = nodePairMap[temp.next]
            newNode.random = nodePairMap[temp.random]

            temp = temp.next
        }

        return nodePairMap[node]
    }

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

}
