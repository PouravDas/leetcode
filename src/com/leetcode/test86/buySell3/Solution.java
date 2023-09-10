package com.leetcode.test86.buySell3;

// # 123
class Solution {
  public int maxProfit (int[] prices) {

    int[] leftProfit = new int[prices.length];
    int[] rightProfit = new int[prices.length];

    int LMin = Integer.MAX_VALUE;
    int RMax = Integer.MIN_VALUE;

    for (int i = 0; i < prices.length; i++) {
      LMin = Math.min(LMin, prices[i]);
      leftProfit[i] = i > 0 ? Math.max(leftProfit[i - 1], prices[i] - LMin) : 0;
    }

    for (int i = prices.length - 1; i >= 0; i--) {
      RMax = Math.max(RMax, prices[i]);
      rightProfit[i] = i == prices.length - 1 ? 0 : Math.max(rightProfit[i + 1], RMax - prices[i]);
    }

    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      ans = Math.max(ans, leftProfit[i] + rightProfit[i]);
    }
    return ans;
  }
}
