package com.leetcode.test109.HouseRobber2;

import java.util.Arrays;

class Solution2 {
  public int rob (int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int dp[] = new int[nums.length];
    Arrays.fill(dp, Integer.MIN_VALUE);
    int[] withFirst = new int[nums.length - 1];
    int[] withLast = new int[nums.length - 1];
    System.arraycopy(nums, 0, withFirst, 0, withFirst.length);
    System.arraycopy(nums, 1, withLast, 0, withLast.length);
    int includeFirst = Math.max(rob(withFirst, 0, dp), rob(withFirst, 1, dp));
    Arrays.fill(dp, Integer.MIN_VALUE);
    int includeLast = Math.max(rob(withLast, 0, dp), rob(withLast, 1, dp));
    return Math.max(includeFirst, includeLast);
  }

  private int rob (int nums[], int i, int[] dp) {
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
