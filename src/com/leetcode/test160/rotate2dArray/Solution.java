package com.leetcode.test160.rotate2dArray;

import java.util.ArrayList;
import java.util.List;

// 48. Rotate Image
class Solution {
  public void rotate (int[][] matrix) {
    int n = matrix.length;
    int gap = 0;
    int i = 0, j = 0;
    int idx = 0;
    while (gap <= n / 2) {
      List<Integer> up = new ArrayList<>();
      List<Integer> right = new ArrayList<>();
      List<Integer> down = new ArrayList<>();
      List<Integer> left = new ArrayList<>();

      i = gap;
      for (j = gap; j < n - gap; j++) {
        up.add(matrix[i][j]);
      }
      j = n - 1 - gap;
      for (i = gap; i < n - gap; i++) {
        right.add(matrix[i][j]);
      }
      i = n - 1 - gap;
      for (j = n - gap - 1; j >= gap; j--) {
        down.add(matrix[i][j]);
      }
      j = gap;
      for (i = n - 1 - gap; i >= gap; i--) {
        left.add(matrix[i][j]);
      }

      j = n - 1 - gap;
      idx = 0;
      for (i = gap; i < n - gap; i++) {
        matrix[i][j] = up.get(idx++);
      }
      i = n - 1 - gap;
      idx = 0;
      for (j = n - gap - 1; j >= gap; j--) {
        matrix[i][j] = right.get(idx++);
      }
      j = gap;
      idx = 0;
      for (i = n - 1 - gap; i >= gap; i--) {
        matrix[i][j] = down.get(idx++);
      }
      i = gap;
      idx = 0;
      for (j = gap; j < n - gap; j++) {
        matrix[i][j] = left.get(idx++);
      }

      gap++;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
  }
}
