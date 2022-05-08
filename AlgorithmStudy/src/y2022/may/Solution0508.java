package y2022.may;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class Solution0508 {
}

interface NestedInteger {
         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return empty list if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
 }
 class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            flat(nestedList.get(i));
        }

        it = list.iterator();

    }

    private void flat(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        } else {
            List<NestedInteger> nList = nestedInteger.getList();
            for (int i = 0; i < nList.size(); i++) {
                flat(nList.get(i));
            }
        }
    }


    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}