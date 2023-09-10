package com.leetcode.test229.longestOnes;

//1004. Max Consecutive Ones III
class Solution {
  public int longestOnes (int[] nums, int k) {
    int start = 0;
    int end = 0;
    int flipped = 0;
    int count = 0;
    int max = 0;
    while (end < nums.length) {
      if (nums[end++] == 1) {
        count++;
      } else {
        flipped++;
        count++;
        while (flipped > k) {
          if(nums[start++] == 1) {
            count--;
          } else {
            flipped--;
            count--;
          }
        }
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
