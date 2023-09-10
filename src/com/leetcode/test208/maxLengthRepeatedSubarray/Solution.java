package com.leetcode.test208.maxLengthRepeatedSubarray;

//718. Maximum Length of Repeated Subarray
class Solution {
  public int findLength (int[] nums1, int[] nums2) {
    int[][] dp = new int[nums1.length][nums2.length];
    int max = 0;
    for (int row = 0; row < nums1.length; row++) {
      for (int col = 0; col < nums2.length; col++) {
        if (nums1[row] == nums2[col]) {
          dp[row][col] = row > 0 && col > 0 ? dp[row - 1][col - 1] + 1 : 1;
          max = Math.max(max, dp[row][col]);
        }
      }
    }
    return max;
  }
}
