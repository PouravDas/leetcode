package com.leetcode.test207.longestSubarray;

class Solution {
  public int longestSubarray (int[] nums) {
    int prevSize = 0;
    int currSize = 0;
    boolean foundZero = false;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        foundZero = true;
        max = Math.max(max, prevSize + currSize);
        prevSize = currSize;
        currSize = 0;
      } else {
        currSize++;
      }
    }
    max = Math.max(max, prevSize + currSize);
    return foundZero ? max : nums.length - 1;
  }
}
