package com.leetcode.test85.buySell2;

//#122
class Solution {
  public int maxProfit (int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      int curr = prices[i];
      int next = prices[i + 1];

      if (next > curr) {
        profit += next - curr;
      }
    }
    return profit;
  }
}
