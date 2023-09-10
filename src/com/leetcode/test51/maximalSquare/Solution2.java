package com.leetcode.test51.maximalSquare;

//using dp
public class Solution2 {

  public int maximalSquare (char[][] matrix) {
    int maxSide = 0;

    int[] dp = new int[matrix[0].length];
    int[] dp2 = new int[matrix[0].length];

    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == '1') {
        dp[i] = 1;
        maxSide = Math.max(maxSide, dp[i]);
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      if(matrix[i][0] == '1')
        dp2[0] = 1;
      maxSide = Math.max(maxSide, dp2[0]);
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          dp2[j] = Math.min(dp2[j-1], Math.min(dp[j - 1], dp[j])) + 1;
          maxSide = Math.max(maxSide, dp2[j]);
        }
      }
      dp = dp2;
      dp2 = new int[matrix[0].length];
    }

    return maxSide * maxSide;
  }
}
