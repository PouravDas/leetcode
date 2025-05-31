package com.leetcode.test86.buySell3;

public class Solution2 {

  public int maxProfit(int[] prices) {
    int[] leftProfit = new int[prices.length];
    int[] rightLose = new int[prices.length];

    int low = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      low = Math.min(low, prices[i]);
      leftProfit[i] = maxProfit = Math.max(maxProfit, prices[i] - low);
    }

    int high = 0;
    int maxLose = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
      high = Math.max(high, prices[i]);
      rightLose[i] = maxLose = Math.max(maxLose, high - prices[i]);
    }

    int ans = 0;

    for (int i = 0; i < prices.length; i++) {
      ans = Math.max(ans , leftProfit[i] + rightLose[i]);
    }
    return ans;
  }
}
