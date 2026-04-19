package com.leetcode.test7.coins;

import java.util.Arrays;

class Solution2 {
  public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount + 1];
    int ans = coinChange(coins, 0, amount, dp);
    return ans < 0 ? -1 : ans;
  }

  public int coinChange(int[] coins, int idx, int amount, int[][] dp) {
    if (amount == 0) return 0;
    if (amount < 0 || idx > coins.length - 1) return Integer.MIN_VALUE;
    if (dp[idx][amount] != 0) return dp[idx][amount] - 1;

    int cur = 1 + coinChange(coins, idx, amount - coins[idx], dp);
    int next = coinChange(coins, idx + 1, amount, dp);

    int ans;
    if (cur < 0 && next < 0) ans = Integer.MIN_VALUE;
    else if (cur < 0) ans = next;
    else if (next < 0) ans = cur;
    else ans = Math.min(next, cur);
    return dp[idx][amount] = ans + 1;
  }
}
