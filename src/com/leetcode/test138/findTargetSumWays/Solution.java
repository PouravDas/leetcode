package com.leetcode.test138.findTargetSumWays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//494. Target Sum
class Solution {

  public int findTargetSumWays (int[] nums, int target) {

    Map<Pair,Integer> dp = new HashMap<>();
    return findSum(nums, 0, target,dp);
  }

  private int findSum (int[] nums, int i, int target, Map<Pair, Integer> dp) {
    Pair key = new Pair(i,target);
    if(dp.containsKey(key))
      return dp.get(key);

    int ans;
    if (i == nums.length) {
      ans = target == 0 ? 1 : 0;
      dp.put(key, ans);
      return ans;
    }
    int p = findSum(nums, i + 1, target + nums[i], dp);
    int m = findSum(nums, i + 1, target - nums[i], dp);
    ans = p +m;
    dp.put(key,ans);
    return ans;
  }

  private static class Pair {
    int a, b;

    Pair (int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override public boolean equals (Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Pair pair = (Pair) o;
      return a == pair.a && b == pair.b;
    }

    @Override public int hashCode () {
      return Objects.hash(a, b);
    }
  }
}
