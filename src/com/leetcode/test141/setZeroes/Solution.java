package com.leetcode.test141.setZeroes;

//73. Set Matrix Zeroes
public class Solution {
  public void setZeroes (int[][] matrix) {
    if (matrix[0][0] != 0) {
      for (int i = 1; i < matrix[0].length; i++) {
        if (matrix[0][i] == 0) {
          matrix[0][0] = 0;
          break;
        }
      }
    }
    if (matrix[0][0] != 0) {
      for (int i = 1; i < matrix.length; i++) {
        if (matrix[i][0] == 0) {
          matrix[0][0] = 0;
          break;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 0; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    for (int i = matrix.length - 1; i > 0; i--) {
      if (matrix[i][0] == 0) {
        for (int j = 0; j < matrix[0].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    if (matrix[0][0] == 0) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = 0;
      }
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.setZeroes(new int[][] {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}});
  }
}
