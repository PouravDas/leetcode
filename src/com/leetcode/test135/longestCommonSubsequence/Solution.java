package com.leetcode.test135.longestCommonSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//#1143. Longest Common Subsequence
//top down approach
class Solution {
  public int longestCommonSubsequence (String text1, String text2) {
    int[][] dp = new int[text1.length()][text2.length()];
    for(int[] d :dp){
      Arrays.fill(d,-1);
    }
    return lcs(text1.length() - 1, text2.length() - 1, text1, text2, dp);
  }

  private int lcs (int l1, int l2, String text1, String text2, int[][] dp) {
    int ans = 0;
    if (l1 == -1 || l2 == -1)
      return 0;
    if (dp[l1][l2] > -1)
      return dp[l1][l2];
    else if (text1.charAt(l1) == text2.charAt(l2))
      ans = 1 + lcs(l1 - 1, l2 - 1, text1, text2, dp);
    else
      ans = Math.max(lcs(l1 - 1, l2, text1, text2, dp), lcs(l1, l2 - 1, text1, text2, dp));
    dp[l1][l2] = ans;
    return ans;
  }
}
