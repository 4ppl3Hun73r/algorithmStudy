package y2023.oct

// https://leetcode.com/problems/flatten-nested-list-iterator/description/?envType=daily-question&envId=2023-10-20
class Solution1020 {
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = false

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? = null

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit = Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit = Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? = null
}


class NestedIterator(nestedList: List<NestedInteger>) {
    val list = mutableListOf<Int>()
    lateinit var it: Iterator<Int>
    init {
        for (l in nestedList) {
            flat(l)
        }

        it = list.iterator()
    }

    private fun flat(nestedInteger: NestedInteger) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger()!!)
        } else {
            for( l in nestedInteger.getList()!!) {
                flat(l)
            }
        }
    }

    fun next(): Int {
        return it.next()
    }

    fun hasNext(): Boolean {
        return it.hasNext()
    }
}