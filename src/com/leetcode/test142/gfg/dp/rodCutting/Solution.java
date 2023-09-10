package com.leetcode.test142.gfg.dp.rodCutting;

//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution{
  public int cutRod(int price[], int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int mx = price[i - 1];
      for(int j = 1; j <= i - j;j++)
        mx = Math.max(mx,dp[j] + dp[i-j]);
      dp[i] = mx;
    }
    return dp[n];
  }
}
