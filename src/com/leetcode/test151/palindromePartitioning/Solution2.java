package com.leetcode.test151.palindromePartitioning;

//TLE
public class Solution2 {

  public int minCut (String s) {
    Integer[][] dp = new Integer[s.length()][s.length()];
    return minCut(s, 0, s.length() - 1, dp);
  }

  private int minCut (String s, int i, int j, Integer[][] dp) {
    if (dp[i][j] != null)
      return dp[i][j];
    if (isPal(s, i, j)) {
      dp[i][j] = 0;
    } else {
      int min = Integer.MAX_VALUE;
      for (int k = i; k < j; k++) {
        min = Math.min(min, minCut(s, i, k, dp) + minCut(s, k + 1, j, dp));
      }
      dp[i][j] = min + 1;
    }
    return dp[i][j];
  }

  private boolean isPal (String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start++) != s.charAt(end--))
        return false;
    }
    return true;
  }
}
