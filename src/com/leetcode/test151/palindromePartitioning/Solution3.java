package com.leetcode.test151.palindromePartitioning;

public class Solution3 {
  public int minCut (String s) {
    boolean[][] pal = new boolean[s.length()][s.length()];
    for (int gap = 0; gap < s.length(); gap++) {
      for (int row = 0, col = gap; col < s.length(); row++, col++) {
        boolean startEndMatch = s.charAt(row) == s.charAt(col);
        pal[row][col] =
            gap == 0 ? true : gap == 1 ? startEndMatch : startEndMatch && pal[row + 1][col - 1];
      }
    }
    int[] dp = new int[s.length()];
    for (int i = 0; i < dp.length; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = i; j >= 0; j--) {
        if (pal[j][i]) {
          if (j == 0) {
            min = 0;
          } else {
            min = Math.min(min, 1 + dp[j - 1]);
          }
        }
      }
      dp[i] = min;
    }
    return dp[s.length() - 1];
  }
}
