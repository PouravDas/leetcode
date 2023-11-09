package com.leetcode.test321.eliminateMaximum;

import java.util.Arrays;

class Solution {
  public int eliminateMaximum (int[] dist, int[] speed) {
    double time[] = new double[dist.length];
    for (int i = 0; i < dist.length; i++) {
      time[i] = (double) dist[i] / (double) speed[i];
    }
    Arrays.sort(time);
    for (int i = 0; i < time.length; i++) {
      if(i >= time[i]) return i;
    }
    return time.length;
  }
}
