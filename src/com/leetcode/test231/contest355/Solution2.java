package com.leetcode.test231.contest355;

public class Solution2 {
  public long maxArrayValue(int[] nums) {
    int sum = 0;
    int max = 0;
    for (int i = nums.length - 1;  i > -1 ; i--) {
      if(nums[i] <= sum) {
        sum += nums[i];
        max = Math.max(max,sum);
      } else {
        sum = nums[i];
      }
    }
    return max;
  }
}
