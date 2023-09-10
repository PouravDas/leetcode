package com.leetcode.test254.validPartition;

class Solution {
  public boolean validPartition (int[] nums) {
    Boolean[] dp = new Boolean[nums.length];
    return isValid(nums, 0, dp);
  }

  private boolean isValid (int[] nums, int i, Boolean[] dp) {
    boolean ans = false;
    if (i == nums.length)
      return true;
    if (i > nums.length)
      return false;
    if(dp[i] != null) return dp[i];
    if (exactly2(nums, i)) {
      ans = isValid(nums, i + 2, dp);
    }
    if (!ans && exactly3(nums, i)) {
      ans = isValid(nums, i + 3, dp);
    }
    if (!ans && consecutive3(nums, i)) {
      ans = isValid(nums, i + 3, dp);
    }
    return dp[i] = ans;
  }

  private boolean consecutive3 (int[] nums, int i) {
    if (i > nums.length - 3)
      return false;
    return nums[i] == nums[i + 1] - 1 ? nums[i + 1] == nums[i + 2] - 1 : false;
  }

  private boolean exactly3 (int[] nums, int i) {
    if (i > nums.length - 3)
      return false;
    return nums[i] == nums[i + 1] ? nums[i + 1] == nums[i + 2] : false;
  }

  private boolean exactly2 (int[] nums, int i) {
    if (i == nums.length - 1)
      return false;
    return nums[i] == nums[i + 1];
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.validPartition(new int[]{4,4,4,5,6});
  }
}
