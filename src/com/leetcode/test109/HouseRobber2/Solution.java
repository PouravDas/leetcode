package com.leetcode.test109.HouseRobber2;

import java.util.Arrays;

//#213
class Solution {
  public int rob (int[] nums) {
    if (nums.length < 4) {
      int max = -1;
      for (int i : nums)
        max = Math.max(max, i);
      return max;
    }
    int dp[] = new int[nums.length];
    Arrays.fill(dp, Integer.MIN_VALUE);

    int dp2[] = new int[nums.length];
    Arrays.fill(dp2, Integer.MIN_VALUE);
    return Math.max(rob(true, nums, 0, dp), rob(false, nums, 1, dp2));
  }

  private int rob (boolean seenFirst, int nums[], int i, int[] dp) {
    if (i >= nums.length || (seenFirst && i == nums.length - 1)) {

      return 0;
    }
    if (dp[i] != Integer.MIN_VALUE) {
      return dp[i];
    }
    int ans = Math.max(nums[i] + rob(seenFirst, nums, i + 2, dp),
        nums[i] + rob(seenFirst, nums, i + 3, dp));
    dp[i] = ans;
    return ans;
  }
}
