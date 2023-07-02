package y2023.jun

import java.util.*

// https://leetcode.com/problems/snapshot-array/
class Solution0611 {

}

class SnapshotArray(length: Int) {

    private val snapArray: Array<TreeMap<Int, Int>> = Array(length) {
        val map = TreeMap<Int, Int>()
        map[0] = 0
        map
    }
    private var snapId = 0

    fun set(index: Int, v: Int) {
        snapArray[index][snapId] = v
    }

    fun snap(): Int {
        return snapId++
    }

    fun get(index: Int, snap_id: Int): Int {
        return snapArray[index].floorEntry(snap_id).value
    }

}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * var obj = SnapshotArray(length)
 * obj.set(index,`val`)
 * var param_2 = obj.snap()
 * var param_3 = obj.get(index,snap_id)
 */