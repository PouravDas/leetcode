package com.leetcode.test226.findNumberOfLIS;

//673. Number of Longest Increasing Subsequence
class Solution {
  public int findNumberOfLIS (int[] nums) {
    int max = 0;
    int[] dp = new int[nums.length];
    int[] count = new int[nums.length];
    int ixd = 0;
    for (int i = 0; i < nums.length; i++) {
      int maxLoc = 0;
      int c = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          int size = dp[j] + 1;
          if (size > maxLoc) {
            maxLoc = size;
            c = count[j];
          } else if (size == maxLoc) {
            c += count[j];
          }
        }
      }
      if (maxLoc == 0) {
        dp[i] = 1;
        count[i] = 1;
        maxLoc = 1;
      } else {
        dp[i] = maxLoc;
        count[i] = c;
      }
      max = Math.max(max, maxLoc);
    }
    int ans = 0;
    for (int i = 0; i < dp.length; i++) {
      if(dp[i] == max) {
        ans += count[i];
      }
    }
    return ans;
  }
}
