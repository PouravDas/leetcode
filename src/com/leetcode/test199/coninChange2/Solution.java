package com.leetcode.test199.coninChange2;

//518. Coin Change II
class Solution {
  public int change (int amount, int[] coins) {
    int[][] dp = new int[coins.length][5001];
    return change(0, amount, coins, dp);
  }

  private int change (int i, int amount, int[] coins, int[][] dp) {
    if (amount == 0)
      return 1;
    if (i == coins.length)
      return 0;
    if (amount < 0)
      return 0;

    if(dp[i][amount] != 0) return dp[i][amount] - 1;
    int with = change(i, amount - coins[i], coins, dp);
    int without = change(i + 1, amount, coins, dp);
    dp[i][amount] = with + without + 1;
    return with + without;
  }
}
