package com.leetcode.test305.maxDotProduct;

//1458. Max Dot Product of Two Subsequences
//hard
class Solution {
  public int maxDotProduct (int[] nums1, int[] nums2) {
    //if all nums1 neg X all nums2 pos
    int max1 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int max2 = Integer.MIN_VALUE;
    boolean isNeg = isNeg(nums1[0]);
    boolean change = false;
    for (int n : nums1) {
      if (isNeg != isNeg(n)) {
        change = true;
        break;
      }
      max1 = Math.max(max1, n);
      min1 = Math.min(min1, n);
    }
    if (!change) {
      isNeg = isNeg(nums2[0]);
      for (int n : nums2) {
        if (isNeg != isNeg(n)) {
          change = true;
          break;
        }
        max2 = Math.max(max2, n);
        min2 = Math.min(min2, n);
      }
      if (!change) {
        return Math.max(max1 * min2, min1 * max2);
      }
    }
    int[][] dp = new int[nums1.length][nums2.length];
    return helper(0, 0, nums1, nums2, dp);
  }

  private boolean isNeg (int i) {
    return i < 0;
  }

  private int helper (int i1, int i2, int[] nums1, int[] nums2, int[][] dp) {
    if (i1 == nums1.length || i2 == nums2.length)
      return 0;
    if (dp[i1][i2] != 0)
      return dp[i1][i2] - 1;
    //choosing
    int max = Integer.MIN_VALUE;
    for (int i = i2; i < nums2.length; i++) {
      int res = nums1[i1] * nums2[i] + helper(i1 + 1, i + 1, nums1, nums2, dp);
      max = Math.max(max, res);
    }
    //not choosing
    max = Math.max(max, helper(i1 + 1, i2, nums1, nums2, dp));
    dp[i1][i2] = max + 1;
    return max;
  }
}
