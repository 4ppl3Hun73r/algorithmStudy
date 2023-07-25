package y2023.jul

// https://leetcode.com/problems/lru-cache/
class Solution0718 {
}

class LRUCache(capacity: Int) {

    val capacity = capacity

    //map, queue
    //사용하면 앞으로 이동
    //put할떄노드 제거
    data class LRUValue(
            val value: Int,
            var prev: LRUValue?,
            var next: LRUValue?)


    /*
         [1, 1]

         {1 = (1)}
         {2 = (2)}

         [(1), (2), (3), (4)]

         // (3) -> head
         // 3 -> prev = null
         // head -> prev = (3)
         // 3 -> next = head
         // 3 -> prev-> next = 4
         // 3 -> next -> prev = 2
         get(1)

         [(2), (1)]
     */
    //       1
    //
    //
    val cache = mutableMapOf<Int, LRUValue>()
    val head = LRUValue(-1, null, null)
    val tail = LRUValue(-1, null, null)
    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val value = cache[key] ?: return -1

        //to head
        value.prev?.next = value.next
        value.next?.prev = value.prev

        value.next = head.next
        head.next?.prev = value
        head.next = value
        value.prev = head

        return value.value
    }

    fun put(key: Int, value: Int) {
        if (cache.size == capacity) {
            evict()
        }


        if (cache[key] != null) {
        }
    }

    fun evict() {

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */