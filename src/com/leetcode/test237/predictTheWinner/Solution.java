package com.leetcode.test237.predictTheWinner;

//486. Predict the Winner
class Solution {
  public boolean PredictTheWinner (int[] nums) {
    return score(nums,0,nums.length-1) > -1;
  }

  int score (int[] nums, int start, int end) {
    if (start == end)
      return nums[start];
    int left = nums[start] - score(nums, start + 1, end);
    int right = nums[end] - score(nums, start, end - 1);
    return Math.max(left, right);
  }
}
