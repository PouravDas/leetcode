package com.leetcode.test139.canPartition;

//using 0/1 knapsap
public class Solution2 {
  public boolean canPartition (int[] nums) {
    int sum = 0;
    for (int n : nums)
      sum += n;
    if((sum & 1) == 1) return false;
    int target = sum >>> 1;
    int[][] dp = new int[nums.length + 1][target + 1];
    for (int i = 1; i < nums.length; i++) {
      for (int j = 1; j < target + 1; j++) {
        if (nums[i - 1] > j)
          dp[i][j] = dp[i - 1][j];
        else
          dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1] + dp[i - 1][j - nums[i - 1]]);
      }
      if (dp[i][target] == target)
        return true;
    }
    return false;
  }

  public static void main (String[] args) {
    Solution2 s = new Solution2();
    s.canPartition(new int[]{1,5,11,5});
  }
}
