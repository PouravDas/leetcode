package com.leetcode.test108.HouseRobber;

import java.util.Arrays;

//#198
class Solution {
  public int rob(int[] nums) {
    int dp[] = new int[nums.length];
    Arrays.fill(dp, Integer.MIN_VALUE);
    return Math.max(rob(nums, 0, dp), rob(nums, 1, dp));
  }

  private int rob(int nums[], int i, int[] dp) {
    if (i >= nums.length)
      return 0;
    if (dp[i] != Integer.MIN_VALUE) {
      return dp[i];
    }
    int ans = Math.max(nums[i] + rob(nums, i + 2, dp), nums[i] + rob(nums, i + 3, dp));
    dp[i] = ans;
    return ans;
  }
}
