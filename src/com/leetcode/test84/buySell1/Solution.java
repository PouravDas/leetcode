package com.leetcode.test84.buySell1;

// # 121
class Solution {
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    for(int p : prices) {
      min = Math.min(min,p);
      maxProfit = Math.max(maxProfit, p - min);
    }
    return maxProfit;
  }
}
