package com.leetcode.test194.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionV3IDK {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    return combinationSum(0, candidates, target, new HashMap<>());
  }

  public List<List<Integer>> combinationSum(int startIdx, int[] candidates, int target, Map<String, List<List<Integer>>> dp) {
    if (target < 0) return new ArrayList<>();
    if (target == 0) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<>());
      return result;
    }
    String key = target + "_" + startIdx;
    if (dp.containsKey(key)) {
      return new ArrayList<>(dp.get(key));
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = startIdx; i < candidates.length; i++) {
      int c = candidates[i];
      List<List<Integer>> r = combinationSum(i, candidates, target - c, dp);
      r.forEach(l -> l.add(c));
      result.addAll(r);
    }
    dp.put(key, result);
    return result;
  }
}
