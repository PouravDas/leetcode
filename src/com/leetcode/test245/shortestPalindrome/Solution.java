package com.leetcode.test245.shortestPalindrome;

class Solution {

  public String shortestPalindrome (String s) {
    if(s == null || s.length() < 2) return s;
    boolean[] dp = new boolean[s.length()];
    boolean[] prev = null;
    for(int gap = 0; gap <s.length(); gap++) {
      int start = s.length() - 1 - gap;
      for(int i = start; i < s.length(); i++) {
        if(i == start) {
          dp[i] = true;
        } else {
          if(s.charAt(start) == s.charAt(i)) {
            if(i == start + 1) {
              dp[i] = true;
            } else {
              dp[i] = prev[i - 1];
            }
          }
        }
      }
      prev = dp;
      dp = new boolean[s.length()];
    }
    int idx = 0;
    for(int i = dp.length - 1; i > -1; i--) {
      if(prev[i]) {
        idx = i;
        break;
      }
    }
    char[] adding = new char[dp.length - 1 - idx];
    int i = 0;
    for (int j = s.length() - 1; j > idx; j--){
      adding[i++] = s.charAt(j);
    }
    return new String(adding)  + s;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.shortestPalindrome("abade");
  }
}
