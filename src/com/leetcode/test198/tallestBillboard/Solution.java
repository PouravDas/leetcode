package com.leetcode.test198.tallestBillboard;

//956. Tallest Billboard (hard)
class Solution {
  int sum = 0;
  public int tallestBillboard (int[] rods) {
    for(int r : rods) sum += r;
    int[][] dp = new int[rods.length][10000];
    return tallest(0,0, rods, dp);
  }

  int tallest ( int diff , int idx, int[] rods, int[][] dp) {
    if (idx == rods.length) {
      return diff == 0 ? 0 : Integer.MIN_VALUE;
    }
    if(dp[idx][diff + 500] != 0) return dp[idx][diff + 500] - 1;
    int curr = rods[idx++];
    int max = 0;
    max = Math.max(max, curr + tallest(diff + curr, idx, rods,dp));
    max = Math.max(max, tallest(diff + curr, idx, rods,dp));
    max = Math.max(max, tallest(diff, idx, rods,dp));
    return dp[idx - 1][diff + 500] = max + 1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans =s.tallestBillboard(new int[]{1,2,3});
    System.out.println(ans);
  }
}
