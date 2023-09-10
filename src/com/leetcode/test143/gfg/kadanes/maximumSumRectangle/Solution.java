package com.leetcode.test143.gfg.kadanes.maximumSumRectangle;

public class Solution {
  int maximumSumRectangle (int r, int c, int matrix[][]) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < r; i++) {
      int[] curr = new int[c];
      for (int j = i; j < r; j++) {
        int mxLocal = Integer.MIN_VALUE;
        int sum = 0;
        for (int k = 0; k < c; k++) {
          curr[k] += matrix[j][k];
          sum += curr[k];
          mxLocal = Math.max(mxLocal, sum);
          if (sum < 0)
            sum = 0;
        }
        max = Math.max(max, mxLocal);
      }
    }
    return max;
  }
}
