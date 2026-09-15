package com.leetcode.test137.lcs.longestPalindromicSubsequence;

import java.util.UUID;

public class Solution3 {
  public String longestPalindrome(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int start = -1, end = -1;
    for (int gap = 0; gap < s.length(); gap++) {
      for (int i = 0, j = gap; j < s.length(); i++, j++) {
        if (i == j) dp[i][j] = true;
        else if (s.charAt(i) == s.charAt(j)) {
          if (gap == 1)
            dp[i][j] = true;
          else if (dp[i + 1][j - 1])
            dp[i][j] = true;
          if (dp[i][j] && j - i > end - start) {
            start = i;
            end = j;
          }
        }
      }
    }
    if (start == -1) return s.substring(0, 1);
    return s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    Solution3 s = new Solution3();
    //s.longestPalindrome("babad");

    String compositeKey = "532c3156-2ac2-5a2d-83d2-8aeb9257fba9" + "|" + "2f9211fa-fdea-4bb2-90d0-0cb88cf902f1" + "|" + "FULF";
    String relationshipId = UUID.nameUUIDFromBytes(compositeKey.getBytes()).toString();
    System.out.println(relationshipId);
  }
}
