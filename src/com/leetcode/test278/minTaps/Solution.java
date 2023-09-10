package com.leetcode.test278.minTaps;

class Solution {
  public int minTaps(int n, int[] ranges) {
    int min = 0;
    int max = 0;
    int count = 0;
    while (min < n) {
      for (int i = 0; i < ranges.length; i++) {
        if(i - ranges[i] <= min && i + ranges[i] > max) {
          max = i + ranges[i];
        }
      }
      if(min == max) return -1;
      min = max;
      count++;
    }
    return count;
  }
}
