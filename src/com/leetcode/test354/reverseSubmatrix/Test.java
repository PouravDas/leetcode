package com.leetcode.test354.reverseSubmatrix;

public class Test {

  public static void main(String[] args) {
  }

  public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
    for (int i = x; i < x + k / 2; i++) {
      for (int j = y; j < y + k; j++) {
        int curr = grid[i][j];
        int down = (x + k - 1) - (i - x);
        grid[i][j] = grid[down][j];
        grid[down][j] = curr;
      }
    }
    return grid;
  }

}
