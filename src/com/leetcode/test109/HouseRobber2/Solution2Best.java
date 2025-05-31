package com.leetcode.test109.HouseRobber2;

import java.util.Arrays;

class Solution2Best {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    if (nums.length == 2) return Math.max(nums[0], nums[1]);

    //using first
    int[] dp = new int[nums.length - 1];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
    }
    int usingFirst = dp[dp.length-1];

    //using last
    dp = new int[nums.length - 1];
    dp[0] = nums[1];
    dp[1] = Math.max(nums[1], nums[2]);

    for (int i = 3; i < nums.length; i++) {
      dp[i - 1] = Math.max(nums[i] + dp[i - 3], dp[i - 2]);
    }
    return Math.max(dp[dp.length - 1], usingFirst);
  }
}
