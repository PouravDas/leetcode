package com.leetcode.test280.combinationSum4;

class Solution {
  public int combinationSum4 (int[] nums, int target) {
    Integer[] dp = new Integer[target + 1];
    return combination(nums, target, dp);
  }

  int combination (int[] nums, int target, Integer[] dp) {
    int count = 0;
    if (target == 0)
      return 1;
    if (target < 0)
      return 0;
    if (dp[target] != null)
      return dp[target];
    for (int i = 0; i < nums.length; i++) {
      count += combination(nums, target - nums[i], dp);
    }
    return dp[target] = count;
  }
}
