package com.leetcode.test67.uniqePathsInNxMGrid;

public class Solution3 {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    dp[0][0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) continue;
        int left = getLeft(dp, i, j);
        int top = getTop(dp, i, j);
        dp[i][j] = left + top;
      }
    }
    return dp[m-1][n-1];
  }

  private int getTop(int[][] dp, int i, int j) {
    if (i == 0) return 0;
    return dp[i - 1][j];
  }

  private int getLeft(int[][] dp, int i, int j) {
    if (j == 0) return 0;
    return dp[i][j - 1];
  }
}
