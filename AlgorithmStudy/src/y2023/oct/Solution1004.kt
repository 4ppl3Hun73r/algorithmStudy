package y2023.oct

class Solution1004 {
}

class MyHashMap() {
    data class Node(
            val key: Int,
            var value: Int,
            var next: Node?
    )

    val size = 10000
    val buckets = Array<Node?>(size) { null }

    fun hash(key: Int): Int {
        return key % size
    }

    fun getBucket(key: Int): Node? {
        return buckets[hash(key)]
    }

    fun put(key: Int, value: Int) {
        val node = getBucket(key)

        if (node == null) {
            val hashKey = hash(key)
            buckets[hashKey] = Node(key, value, null)
        } else {
            var temp = node
            var prev = temp

            while (temp != null) {
                if (temp.key == key) {
                    temp.value = value
                    break
                }
                prev = temp
                temp = prev.next
            }

            if (temp == null) {
                prev!!.next = Node(key, value, null)
            }
        }
    }

    fun get(key: Int): Int {
        var node = getBucket(key)
        while (node != null) {
            if (node.key == key) {
                return node.value
            }
            node = node.next
        }
        return -1
    }

    fun remove(key: Int) {
        val node = getBucket(key)
        if (node != null && node.key == key) {
            buckets[hash(key)] = node.next
            return
        }

        var temp = node
        var prev = temp

        while (temp != null) {
            if (temp.key == key) {
                break
            }
            prev = temp
            temp = prev.next
        }

        if (temp != null) {
            prev!!.next = temp.next
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */