package com.leetcode.test247.contest.second;

import java.util.List;

class Solution {
  public boolean canSplitArray (List<Integer> nums, int m) {
    Boolean[][] dp = new Boolean[nums.size()][nums.size()];

    return canSplitArray(nums, m, nums.stream().mapToInt(Integer::intValue).sum(), 0,
        nums.size() - 1, dp);
  }

  public boolean canSplitArray (List<Integer> nums, int m, int sum, int start, int end,
      Boolean[][] dp) {
    if (dp[start][end] != null) {
      return dp[start][end];
    }
    if (end - start <= 1)
      return dp[start][end] = true;
    boolean ans = false;
    if (sum - nums.get(start) >= m) {
      if (canSplitArray(nums, m, sum - nums.get(start), start + 1, end, dp)) {
        ans = true;
      }
    }
    if (sum - nums.get(end) >= m) {
      if (canSplitArray(nums, m, sum - nums.get(end), start, end - 1, dp)) {
        ans = true;
      }
    }
    return dp[start][end] = ans;
  }
}
