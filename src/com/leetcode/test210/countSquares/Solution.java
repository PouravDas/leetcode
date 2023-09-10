package com.leetcode.test210.countSquares;

//1277. Count Square Submatrices with All Ones
class Solution {
  public int countSquares (int[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0)
          continue;
        int top = i > 0 ? matrix[i - 1][j] : 0;
        int left = j > 0 ? matrix[i][j - 1] : 0;
        int topLeft = i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0;
        int min = Math.min(top, Math.min(left, topLeft));
        sum += matrix[i][j] = min + 1;
      }
    }
    return sum;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.countSquares(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}});
  }
}
