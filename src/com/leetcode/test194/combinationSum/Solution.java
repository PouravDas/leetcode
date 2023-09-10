package com.leetcode.test194.combinationSum;

import java.util.*;

//39. Combination Sum
class Solution {
  public List<List<Integer>> combinationSum (int[] candidates, int target) {
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    combinationSum(set, list, candidates, target);
    return new ArrayList<>(set);
  }

  private void combinationSum (Set<List<Integer>> set, List<Integer> list, int[] candidates,
      int target) {
    if (target == 0) {
      list.sort(Comparator.naturalOrder());
      set.add(list);
    } else if (target < 0)
      return;
    else {
      for (int c : candidates) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(c);
        combinationSum(set, newList, candidates, target - c);
      }
    }
  }
}
