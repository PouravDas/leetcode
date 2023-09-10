package com.leetcode.test187.longestIncreasingPath;

//329. Longest Increasing Path in a Matrix (hard)
class Solution {
  public int longestIncreasingPath (int[][] matrix) {
    int max = 0;
    Integer[][] dp = new Integer[matrix.length][matrix[0].length];
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int len = findPath(i, j, matrix, visited, dp);
        max = Math.max(max, len);
      }
    }
    return max;
  }

  private int findPath (int i, int j, int[][] matrix, boolean[][] visited, Integer[][] dp) {
    if(dp[i][j] != null) return dp[i][j];
    visited[i][j] = true;
    int curValue = matrix[i][j];
    int localMax = 0;
    if (j > 0 && !visited[i][j - 1] && matrix[i][j - 1] > curValue) {
      localMax = findPath(i, j - 1, matrix, visited, dp);
    }
    if (j < matrix[i].length - 1 && !visited[i][j + 1] && matrix[i][j + 1] > curValue) {
      localMax = Math.max(localMax, findPath(i, j + 1, matrix, visited, dp));
    }
    if (i > 0 && !visited[i - 1][j] && matrix[i - 1][j] > curValue) {
      localMax = Math.max(localMax, findPath(i - 1, j, matrix, visited, dp));
    }
    if (i < matrix.length - 1 && !visited[i + 1][j] && matrix[i + 1][j] > curValue) {
      localMax = Math.max(localMax, findPath(i + 1, j, matrix, visited, dp));
    }
    visited[i][j] = false;
    return dp[i][j] = 1 + localMax;
  }
}
