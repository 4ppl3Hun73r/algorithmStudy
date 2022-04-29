package y2022.apr;

import java.util.Iterator;

// https://leetcode.com/problems/peeking-iterator/
public class Solution0425 {
}

class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer peek = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) {
            peek = iterator.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = null;
        if (peek != null) {
            next = peek;
            peek = null;
        } else {
            next = iterator.next();
        }

        return next;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = iterator.hasNext();

        if (!hasNext && peek != null) {
            return true;
        }

        return hasNext;
    }
}