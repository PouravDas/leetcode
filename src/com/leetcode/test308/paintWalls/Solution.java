package com.leetcode.test308.paintWalls;

class Solution {
  public int paintWalls (int[] cost, int[] time) {
    return (int) helper(cost, time, 0, 0, new long[cost.length][cost.length]);
  }

  long helper (int[] cost, int[] time, int i, int totalTime, long dp[][]) {
    if (totalTime >= cost.length) {
      return 0;
    }

    if (i >= cost.length)
      return Integer.MAX_VALUE;

    if (dp[i][totalTime] != 0)
      return dp[i][totalTime];
    // free
    long free = helper(cost, time, i + 1, totalTime, dp);
    // paid
    long paid = cost[i] + helper(cost, time, i + 1, totalTime + time[i] + 1, dp);
    return dp[i][totalTime] = Math.min(free, paid);
  }
}
