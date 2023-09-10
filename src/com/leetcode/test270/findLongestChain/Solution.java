package com.leetcode.test270.findLongestChain;

import java.util.Arrays;

//646. Maximum Length of Pair Chain
class Solution {
  public int findLongestChain (int[][] pairs) {
    int max = 0;
    Integer[] dp = new Integer[pairs.length];
    Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
    for (int i = 0; i < pairs.length; i++) {
      max = Math.max(max, findLongestChain(pairs, i, dp));
    }
    return max;
  }

  int findLongestChain (int[][] pairs, int prev, Integer[] dp) {
    if(dp[prev] != null) return dp[prev];
    int max = 0;
    for (int i = prev + 1; i < pairs.length; i++) {
      if (pairs[prev][1] < pairs[i][0]) {
        max = Math.max(max, findLongestChain(pairs, i, dp));
      }
    }
    return dp[prev] = 1 + max;
  }
}
