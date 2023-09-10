package com.leetcode.test269.maxUncrossedLines;

//1035. Uncrossed Lines
class Solution {
  public int maxUncrossedLines (int[] nums1, int[] nums2) {
    Integer[][] dp = new Integer[nums1.length][nums2.length];
    return maxUncrossedLines(nums1, 0, nums2, 0, dp);
  }

  int maxUncrossedLines (int[] nums1, int i1, int[] nums2, int i2, Integer[][] dp) {
    if (i1 == nums1.length || i2 == nums2.length)
      return 0;
    if (dp[i1][i2] != null)
      return dp[i1][i2];
    int skip = maxUncrossedLines(nums1, i1 + 1, nums2, i2, dp);
    //include
    boolean found = false;
    int include = 0;
    int idx = i2;
    while (idx < nums2.length) {
      if (nums1[i1] == nums2[idx]) {
        found = true;
        break;
      } else {
        idx++;
      }
    }
    if (found) {
      include = 1 + maxUncrossedLines(nums1, i1 + 1, nums2, idx + 1, dp);
    }
    return dp[i1][i2] = Math.max(skip, include);
  }
}
