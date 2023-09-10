package com.leetcode.test138.findTargetSumWays;

//0/1 knapsack
//wrong
public class Solution2 {
  public int findTargetSumWays (int[] nums, int target) {
    int sum = 0;
    for (int n : nums)
      sum += n;

    int need = sum + target;
    if((need & 1) == 1) return 0;
    need = need >>> 1;
    int ans = 0;

    int [][] dp = new int[nums.length + 1][need + 1];
    for (int i = 1; i < nums.length + 1; i++) {
      for (int j = 1; j < need + 1; j++) {
        if(nums[i-1] > j)
          dp[i][j] = dp[i-1][j];
        else
          dp[i][j] = Math.max(dp[i-1][j], nums[i-1] + dp[i-1][j - nums[i-1]]);
      }
      if(dp[i][need] == need) ans++;
    }
    return ans;
  }
}
