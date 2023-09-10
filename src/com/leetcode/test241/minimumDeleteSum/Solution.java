package com.leetcode.test241.minimumDeleteSum;

class Solution {
  public int minimumDeleteSum (String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int i = s1.length() - 1; i > -1; i--) {
      dp[i][s2.length()] = s1.charAt(i) + dp[i + 1][s2.length()];
    }
    for (int i = s2.length() - 1; i > -1; i--) {
      dp[s1.length()][i] = s2.charAt(i) + dp[s1.length()][i + 1];
    }
    for (int i = s1.length() - 1; i > -1; i--) {
      for (int j = s2.length() - 1; j > -1; j--) {
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if (c1 == c2) {
          dp[i][j] = dp[i + 1][j + 1];
        } else {
          dp[i][j] = Math.min(c2 + dp[i][j + 1], c1 + dp[i + 1][j]);
        }
      }
    }
    return dp[0][0];
  }
}
