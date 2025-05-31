package com.leetcode.test108.HouseRobber;

public class SolutionV2 {
  public int rob(int[] nums) {
    Integer[] dp = new Integer[nums.length];
    return sum(0, nums, dp);
  }

  int sum(int idx, int[] nums, Integer[] dp) {
    if (idx >= nums.length) {
      return 0;
    }
    if (dp[idx] != null)
      return dp[idx];
    return dp[idx] = Math.max(sum(idx + 1, nums, dp), nums[idx] + sum(idx + 2, nums, dp));
  }
}
