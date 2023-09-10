package com.leetcode.test135.longestCommonSubsequence;

//better space optimised
public class Solution3 {
  public int longestCommonSubsequence (String text1, String text2) {
    int[] prev = new int[text1.length() + 1];
    int[] curr = new int[text1.length() + 1];

    for (int i = 1; i < text2.length() + 1; i++) {
      for (int j = 1; j < text1.length() + 1; j++) {
        if (text2.charAt(i - 1) == text1.charAt(j - 1))
          curr[j] = prev[j - 1] + 1;
        else
          curr[j] = Math.max(curr[j - 1], prev[j]);
      }
      System.arraycopy(curr, 0, prev, 0, curr.length);
    }
    return prev[text1.length()];
  }
}
