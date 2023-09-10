package com.leetcode.test155.minSubArrayLen;

//209. Minimum Size Subarray Sum
class Solution {
  public int minSubArrayLen (int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int start = 0;
    int end = 0;
    int sum = 0;
    while (end < nums.length) {
      sum += nums[end];
      end++;
      while (sum >= target) {
        min = Math.min(min, end - start);
        sum -= nums[start];
        start++;
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
