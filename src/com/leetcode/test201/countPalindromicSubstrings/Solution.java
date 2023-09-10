package com.leetcode.test201.countPalindromicSubstrings;

//647. Palindromic Substrings
public class Solution {
  public int countSubstrings (String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int count = 0;
    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        if (gap == 0) {
          dp[i][j] = true;
          count++;
          continue;
        }
        if (s.charAt(i) == s.charAt(j)) {
          if (gap == 1 || dp[i + 1][j - 1]) {
            dp[i][j] = true;
            count++;
          }
        }
      }
    }
    return count;
  }
}
