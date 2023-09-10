package com.leetcode.test194.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public List<List<Integer>> combinationSum (int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    combinationSum(ans, new ArrayList<>(), candidates, 0, target);
    return ans;
  }

  private void combinationSum (List<List<Integer>> set, List<Integer> list, int[] candidates,
      int idx, int target) {
    if (idx == candidates.length)
      return;
    if (target == 0) {
      set.add(new ArrayList<>(list));
    } else if (target < 0)
      return;
    else {
      //choose
      list.add(candidates[idx]);
      combinationSum(set, list, candidates, idx, target - candidates[idx]);
      list.remove(list.size() - 1);
      //not choose
      combinationSum(set, list, candidates, idx + 1, target);
    }
  }
}
