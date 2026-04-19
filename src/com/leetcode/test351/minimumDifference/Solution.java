package com.leetcode.test351.minimumDifference;

import java.util.Arrays;

public class Solution {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int l = 0;
    int r = k - 1;
    int ans = nums[r] - nums[l];
    for (; r < nums.length; r++, l++) {
      ans = Math.min(ans, nums[r] - nums[l]);
    }
    return ans;
  }
}