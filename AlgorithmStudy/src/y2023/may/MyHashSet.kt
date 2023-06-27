package y2023.may

import java.util.*

class MyHashSet2(private val BUCKET_SIZE: Int = 10000) {

    private val array: Array<LinkedList<Int>> = Array(BUCKET_SIZE) {
        LinkedList<Int>()
    }

    fun getHash(key: Int): Int {
        return key % BUCKET_SIZE
    }

    fun add(key: Int) {
        val hash = getHash(key)
        if (!contains(key)) {
            array[hash].add(key);
        }
    }

    fun remove(key: Int) {
        val hash = getHash(key)
        array[hash].remove(key)
    }

    fun contains(key: Int): Boolean {
        val hash = getHash(key)
        return array[hash].contains(key)
    }

}