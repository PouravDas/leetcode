package com.leetcode.test108.HouseRobber;

import java.util.Arrays;

public class SolutionV4Again {
  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    return rob(nums, 0, dp);
  }

  private int rob(int[] nums, int i, int[] dp) {
    if (i >= nums.length) return 0;
    if (dp[i] > -1) return dp[i];
    int chose = nums[i] + rob(nums, i + 2, dp);
    int notChose = rob(nums, i + 1, dp);
    return dp[i] = Math.max(chose, notChose);
  }
}
