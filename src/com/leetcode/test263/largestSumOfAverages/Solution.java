package com.leetcode.test263.largestSumOfAverages;

class Solution {
  public double largestSumOfAverages (int[] nums, int k) {
    double[][] dp = new double[nums.length][k + 1];
    return findLargest(nums, 0, k, dp);
  }

  double findLargest (int[] nums, int start, int k, double[][] dp) {
    if(dp[start][k] != 0) return dp[start][k];
    if (k == 1) {
      double sum = 0;
      for (int i = start; i < nums.length; i++) {
        sum += nums[i];
      }
      return dp[start][k] = sum / (nums.length - start);
    }
    double max = 0;
    for (int i = start; i < nums.length - k + 1; i++) {
      double sum = 0;
      for (int j = start; j <= i; j++) {
        sum += nums[j];
      }
      double avg = sum / (i - start + 1);
      double rec = findLargest(nums, i + 1, k - 1, dp);
      max = Math.max(max, avg + rec);
    }
    return dp[start][k] = max;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.largestSumOfAverages(new int[] {9, 1, 2, 3, 9}, 3);
  }
}
