package com.leetcode.test303.majorityElement;

public class Solution3 {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int n : nums) {
      if (n > max) max = n;
      if (sum + n > 0) {
        sum += n;
        if (sum > max) max = sum;
      } else sum = 0;
    }
    return max;
  }
}
