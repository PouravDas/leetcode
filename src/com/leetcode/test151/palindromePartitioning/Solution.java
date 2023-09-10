package com.leetcode.test151.palindromePartitioning;

//132. Palindrome Partitioning II
/**
 * filling dp[][] diagonally
 *
 * Anuj bhaiya fail margaya
 */
class Solution {
  public int minCut (String s) {
    int[][] dp = new int[s.length()][s.length()];

    for (int i = 1; i < dp.length; i++) {
      for (int row = 0, col = i; col < dp.length; row++, col++) {
        if (isPal(s, row, col)) {
          dp[row][col] = 0;
        } else {
          int min = Integer.MAX_VALUE;
          for (int j = row; j < col; j++) {
            min = Math.min(dp[row][j] + dp[j + 1][col], min);
          }
          dp[row][col] = 1 + min;
        }
      }
    }
    return dp[0][s.length() - 1];
  }

  private boolean isPal (String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--))
        return false;
    }
    return true;
  }

  public static void main (String[] args) {
    Solution3 s = new Solution3();
    s.minCut("abccbc");
  }

  static final String test = "";
}
