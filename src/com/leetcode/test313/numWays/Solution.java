package com.leetcode.test313.numWays;

class Solution {
  int MOD = 1_000_000_000 + 7;
  public int numWays (int steps, int arrLen) {
    Integer[][] dp = new Integer[arrLen][steps + 1];
    return (int) helper(0, steps, arrLen, dp);
  }

  long helper (int i, int steps, int len, Integer[][] dp) {
    if (i == -1 || i == len)
      return 0;
    if (steps == 0)
      return i == 0 ? 1 : 0;

    if (dp[i][steps] != null)
      return dp[i][steps];
    long ans = 0;
    //stay
    ans += helper(i, steps - 1, len, dp);
    //right
    ans += helper(i + 1, steps - 1, len, dp);
    //left
    ans += helper(i - 1, steps - 1, len, dp);

    return dp[i][steps] = Math.toIntExact(ans % MOD);
  }
}
