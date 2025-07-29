package com.leetcode.test337.eggdrop;

public class Solution {

  public int twoEggDrop(int n) {
    return eggDrop(n, 2, new int[n + 1][3]);
  }

  private int eggDrop(int floor, int egg, int[][] dp) {
    if (dp[floor][egg] != 0) return dp[floor][egg];
    if (floor == 0) return 0;
    if (floor == 1) return 1;
    if (egg == 1) return floor;
    int min = Integer.MAX_VALUE;
    for (int f = 1; f < floor; f++) {
      int drops = Math.max(eggDrop(f - 1, egg - 1, dp), eggDrop(floor - f, egg, dp)) + 1;
      min = Math.min(drops, min);
    }
    dp[floor][egg] = min;
    return min;
  }

  private int eggDropMatrix(int floor, int egg) {
    int[][] dp = new int[egg + 1][floor + 1];
    for (int f = 1; f <= floor; f++) {
      dp[1][f] = f;
    }
    for (int e = 2; e <= egg; e++) {
      for (int f = 1; f <= floor; f++) {
        int min = floor;
        for (int k = 1; k <= f; k++) {
          int mx = Math.max(dp[e - 1][k - 1], dp[e][f - k]) + 1;
          min = Math.min(min, mx);
        }
        dp[e][f] = min;
      }
    }
    return dp[egg][floor];
  }
}
