package com.leetcode.test148.gfg.minNoOfJumps;

import java.util.Arrays;

// dp TLE
// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
class Solution {
  static int minJumps (int[] arr) {
    int[] dp = new int[arr.length];
    Arrays.fill(dp, -1);
    int ans = minJumps(arr, 0, dp);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  static int minJumps (int[] arr, int idx, int[] dp) {
    if (idx >= arr.length - 1) {
      return 0;
    }
    if(dp[idx] > -1) {
      return dp[idx];
    }
    int ans = Integer.MAX_VALUE;
    for (int i = arr[idx]; i > 0; i--) {
      ans = Math.min(ans, minJumps(arr, idx + i, dp));
    }
    return dp[idx] = ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans + 1;
  }

  public static void main (String[] args) {
    int ans = Solution2.minJumps(new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
    System.out.println(ans);
  }
}
