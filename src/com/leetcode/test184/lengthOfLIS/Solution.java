package com.leetcode.test184.lengthOfLIS;

//300. Longest Increasing Subsequence

/**
 * DP problem
 * create an DP array that holds the longest increasing subsequence ending with that current number
 * to get the largest increasing subsequence at an index check all the number in the DP array which is less then the current
 * number and find the longest.
 */
class Solution {
  public int lengthOfLIS (int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          max = Math.max(max, dp[j]);
        }
      }
      dp[i] = max + 1;
    }
    int max = 0;
    for (int d : dp) {
      max = Math.max(d, max);
    }
    return max;
  }
}
