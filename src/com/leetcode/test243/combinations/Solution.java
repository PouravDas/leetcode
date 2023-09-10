package com.leetcode.test243.combinations;

import java.util.ArrayList;
import java.util.List;

//77. Combinations
class Solution {
  public List<List<Integer>> combine (int n, int k) {
    List<List<Integer>> mainList = new ArrayList<>();
    combine(1, n, mainList, new ArrayList<>(), k);
    return mainList;
  }

  private void combine (int start, int end, List<List<Integer>> mainList, List<Integer> curr,
      int k) {
    if (k == 0) {
      mainList.add(new ArrayList<>(curr));
      return;
    }
    for (int i = start; i <= end; i++) {
      curr.add(i);
      combine(i + 1, end, mainList, curr, k - 1);
      curr.remove(curr.size() - 1);
    }
  }
}
