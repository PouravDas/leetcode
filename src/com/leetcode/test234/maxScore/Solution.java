package com.leetcode.test234.maxScore;

//2786. Visit Array Positions to Maximize Score
class Solution {
  public long maxScore (int[] nums, int x) {
    Long[][] dp = new Long[nums.length][2];
    return maxScore(0, nums, isOdd(nums[0]), x, dp);
  }

  private long maxScore (int i, int[] nums, boolean odd, int x, Long[][] dp) {
    if (i > nums.length - 1)
      return 0;
    if ((odd ? dp[i][0] : dp[i][1]) != null) {
      return (odd ? dp[i][0] : dp[i][1]);
    }
    long ans;
    if (isOdd(nums[i]) == odd) {
      ans = nums[i] + maxScore(i + 1, nums, odd, x, dp);
    } else {
      long skip = maxScore(i + 1, nums, odd, x, dp);
      long pick = nums[i] + maxScore(i + 1, nums, !odd, x, dp) - x;
      ans = Math.max(skip, pick);
    }
    if (odd) {
      dp[i][0] = ans;
    } else {
      dp[i][1] = ans;
    }
    return ans;
  }

  private boolean isOdd (int n) {
    return (n & 1) == 1;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    long a = s.maxScore(new int[] {2, 3, 6, 1, 9, 2}, 5);
    System.out.println(a);
  }
}
