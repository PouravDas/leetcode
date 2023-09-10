package com.leetcode.test196.longestArithSeqLength;

//1027. Longest Arithmetic Subsequence
class Solution {
  public int longestArithSeqLength (int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        max = Math.max(max, 2 + longest(j, nums[j] - nums[i], nums));
      }
    }
    return max;
  }

  private int longest (int start, int diff, int[] nums) {
    int ans = 0;
    int prevIdx = start;
    for (int i = start + 1; i < nums.length; i++) {
      if(nums[i] - nums[prevIdx] == diff) {
        ans++;
        prevIdx = i;
      }
    }
    return ans;
  }
}
