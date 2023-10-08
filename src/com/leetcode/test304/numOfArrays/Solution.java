package com.leetcode.test304.numOfArrays;

//1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
//hard
class Solution {
  int len;
  int max;
  int cost;
  int MOD = 1_000_000_000 + 7;

  public int numOfArrays (int n, int m, int k) {
    len = n;
    max = m;
    cost = k;
    long[][][] dp = new long[n][max + 1][cost + 1];
    return (int) rec(0, 0, 0, dp);
  }

  long rec (int idx, int curMax, int c, long[][][] dp) {
    if (idx == len)
      return c == cost ? 1 : 0;
    if (c > cost)
      return 0;
    if (dp[idx][curMax][c] != 0)
      return dp[idx][curMax][c] - 1;
    long ans = 0;
    for (int i = 1; i <= max; i++) {
      ans += rec(idx + 1, Math.max(curMax, i), c + (i > curMax ? 1 : 0), dp);
    }
    ans %= MOD;
    dp[idx][curMax][c] = ans + 1;
    return ans;
  }
}
