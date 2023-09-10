package com.leetcode.test239.maximumJumps;

class Solution {
  public int maximumJumps (int[] nums, int target) {
    Integer[] dp = new Integer[nums.length];
    return maxJump(nums, target, 0, dp);
  }

  int maxJump (int[] nums, int target, int idx, Integer[] dp) {
    if(dp[idx] != null) return dp[idx];
    if (idx == nums.length - 1)
      return 0;
    int max = -1;
    for (int i = idx + 1; i < nums.length; i++) {
      if (Math.abs(nums[idx] - nums[i]) <= target)
        max = Math.max(max, maxJump(nums, target, i, dp));
    }
    if (max == -1)
      return dp[idx] = -1;
    return dp[idx] = 1 + max;
  }
}
