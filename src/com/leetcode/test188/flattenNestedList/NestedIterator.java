package com.leetcode.test188.flattenNestedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//341. Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {

  List<Integer> list;
  Iterator<Integer> it;

  public NestedIterator (List<NestedInteger> nestedList) {
    list = new ArrayList<>();
    populateList(nestedList, list);
    it = list.iterator();
  }

  private void populateList (List<NestedInteger> nestedList, List<Integer> list) {
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        list.add(ni.getInteger());
      } else {
        populateList(ni.getList(), list);
      }
    }
  }

  @Override public Integer next () {
    return it.next();
  }

  @Override public boolean hasNext () {
    return it.hasNext();
  }

  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger ();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger ();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList ();
  }
}
