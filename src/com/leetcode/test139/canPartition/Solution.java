package com.leetcode.test139.canPartition;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//416. Partition Equal Subset Sum
//time limit exceeded
class Solution {
  public boolean canPartition (int[] nums) {

    int sum = 0;
    for (int n : nums)
      sum += n;
    if ((sum & 1) == 1)
      return false;
    Map<Pair, Boolean> dp = new HashMap<>();
    return findSum(nums, 0, 0, sum >>> 1, dp);
  }

  private boolean findSum (int[] nums, int i, int sum, int target, Map<Pair, Boolean> dp) {
    Pair key = new Pair(i, sum);
    boolean ans;
    if (dp.containsKey(key))
      return dp.get(key);
    if (i == nums.length - 1) {
      ans = sum == target;
      dp.put(key, ans);
      return ans;
    }
    ans = findSum(nums, i + 1, sum, target, dp) || findSum(nums, i + 1, sum + nums[i], target, dp);
    dp.put(key, ans);
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
