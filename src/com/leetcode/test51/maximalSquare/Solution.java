package com.leetcode.test51.maximalSquare;

class Solution {
  public int maximalSquare (char[][] matrix) {

    int maxSide = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          continue;
        }
        int side = 0;

        while (true) {
          boolean stop = false;
          if (i + side >= matrix.length || j + side >= matrix[0].length) {
            break;
          }
          int k = i + side;
          for (int l = j; l <= j + side; l++) {
            if (matrix[k][l] == '0') {
              stop = true;
              break;
            }
          }
          if(stop){
            break;
          }
          int l = j + side;
          for (k = i; k < i + side; k++) {
            if (matrix[k][l] == '0') {
              stop = true;
              break;
            }
          }
          if(stop){
            break;
          }
          maxSide = Math.max(side + 1, maxSide);
          side++;
        }
      }
    }
    return maxSide * maxSide;
  }

  public static void main (String[] args) {
    Solution2 s = new Solution2();
    char[][] matrix =
        {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}};
    s.maximalSquare(matrix);
  }
}
