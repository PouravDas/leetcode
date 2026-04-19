package com.leetcode.test107.DecodeWays;

public class Solution2 {

  public int numDecodings(String s) {
    char[] code = s.toCharArray();
    Integer[] dp = new Integer[code.length];
    return numDecodings(code, 0, dp);
  }

  int numDecodings(char[] code, int idx, Integer[] dp) {
    if(idx > code.length-1) return 1;
    if(code[idx] == '0') return 0;
    if(dp[idx] != null) return dp[idx];
    int ans = numDecodings(code, idx + 1, dp);
    if(idx < code.length -1 && valid("" + code[idx] + code[idx+1])) {
      ans += numDecodings(code, idx +2, dp);
    }
    return dp[idx] = ans;
  }

  boolean valid(String s) {
    return Integer.parseInt(s) < 27;
  }
}
