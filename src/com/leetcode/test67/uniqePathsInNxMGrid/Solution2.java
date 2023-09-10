package com.leetcode.test67.uniqePathsInNxMGrid;

public class Solution2 {
  public int uniquePaths (int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    boolean last = true;
    for (int i = m - 1; i > -1; i--) {
      for (int j = n - 1; j > -1; j--) {
        if (last) {
          last = false;
          dp[i][j] = 1;
          continue;
        }
        dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
      }
    }
    return dp[0][0];
  }
}
