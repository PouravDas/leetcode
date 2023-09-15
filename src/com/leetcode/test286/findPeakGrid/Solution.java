package com.leetcode.test286.findPeakGrid;

//1901. Find a Peak Element II
//medium
// not solved
class Solution {
  public int[] findPeakGrid (int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      int start = 0;
      int end = mat[i].length - 1;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (mat[i][mid] > mat[i][mid + 1]) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      int top = i == 0 ? -1 : mat[i - 1][start];
      int down = i == mat.length - 1 ? -1 : mat[i + 1][start];
      if (top < mat[i][start] && down < mat[i][start]) {
        return new int[] {i, start};
      }
    }
    return null;
  }
}
