package com.leetcode.test107.DecodeWays;

//#91
public class Solution {
  public int numDecodings (String s) {
    int[] dp = new int[s.length()];
    for (int i = 0; i < dp.length; i++) {
      int cur = Integer.parseInt("" + s.charAt(i));
      int prev = i > 0 ? Integer.parseInt("" + s.charAt(i - 1)) : 0;
      int next = i != s.length() - 1 ? Integer.parseInt("" + s.charAt(i + 1)) : -1;
      if (i == 0) {
        if (cur == 0) {
          return 0;
        }
        dp[i] = 1;
      } else if (cur == 0) {
        if (prev > 0 && prev < 3) {
          dp[i] = dp[i - 1];
        } else
          return 0;
      } else if (next == 0 || prev == 0) {
        dp[i] = dp[i - 1];
      } else if (prev * 10 + cur < 27 && (i != s.length() - 1 ? s.charAt(i + 1) != '0' : true))
        dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
      else
        dp[i] = dp[i - 1];
    }
    return dp[dp.length - 1];
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.numDecodings("2101");
    System.out.println(ans);
  }
}
