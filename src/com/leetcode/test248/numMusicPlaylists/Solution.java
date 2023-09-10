package com.leetcode.test248.numMusicPlaylists;

//920. Number of Music Playlists
//hard
class Solution {
  int n;
  int goal;
  int k;
  int mod = 1_000_000_007;

  public int numMusicPlaylists (int n, int goal, int k) {
    this.n = n;
    this.goal = goal;
    this.k = k;
    Long[][] dp = new Long[goal + 1][n + 1];
    return (int) solve(0, 0, dp);
  }

  private long solve (int len, int num, Long[][] dp) {
    if (len == goal) {
      return num == n ? 1 : 0;
    }
    if (dp[len][num] != null)
      return dp[len][num];
    long ans = solve(len + 1, num, dp) * Math.max(0, num - k) % mod;
    ans += solve(len + 1, num + 1, dp) * (n - num) % mod;
    return dp[len][num] = ans % mod;
  }
}
