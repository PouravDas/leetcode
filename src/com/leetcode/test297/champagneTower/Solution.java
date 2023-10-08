package com.leetcode.test297.champagneTower;

class Solution {
  public double champagneTower (int poured, int query_row, int query_glass) {
    double[][] dp = new double[100][100];
    dp[0][0] = poured;
    for (int i = 1; i <= query_row; i++) {
      for (int j = 0; j < i + 1; j++) {
        double left = 0, right = 0;
        if (j != 0) {
          left = (dp[i - 1][j - 1] - 1) / 2;
        }
        right = (dp[i - 1][j] - 1) / 2;
        dp[i][j] = (left > 0 ? left : 0) + (right > 0 ? right : 0);
      }
    }
    return dp[query_row][query_glass] > 1 ? 1 : dp[query_row][query_glass];
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.champagneTower(9, 4, 1);
  }
}
