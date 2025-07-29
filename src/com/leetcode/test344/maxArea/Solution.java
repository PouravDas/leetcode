package com.leetcode.test344.maxArea;

public class Solution {
  public int maxArea(int[] height) {
    int ans = 0;
    int l = 0;
    int r = height.length - 1;
    while (l < r) {
      ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return ans;
  }
}
