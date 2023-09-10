package com.leetcode.test202.longestPalindromicSubstring;

//5. Longest Palindromic Substring
public class Solution {
  public String longestPalindrome (String s) {
    String ans = "";
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        if (gap == 0) {
          dp[i][j] = true;
        } else {
          boolean b = s.charAt(i) == s.charAt(j);
          if (gap == 1) {
            if (b)
              dp[i][j] = true;
          } else {
            if (b && dp[i + 1][j - 1])
              dp[i][j] = true;
          }
        }
        if (dp[i][j] && j - i + 1 > ans.length()) {
          ans = s.substring(i, j + 1);
        }
      }
    }
    return ans;
  }
}
