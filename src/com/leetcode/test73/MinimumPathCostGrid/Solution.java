package com.leetcode.test73.MinimumPathCostGrid;

import java.util.Arrays;

//# 2304
class Solution {
  public int minPathCost (int[][] grid, int[][] moveCost) {

    int dp[][] = new int[grid.length][grid[0].length];
    for (int[] d : dp) {
      Arrays.fill(d, Integer.MAX_VALUE);
    }

    System.arraycopy(grid[0], 0, dp[0], 0, grid[0].length);
    for (int i = 0; i < grid.length - 1; i++) {
      for (int j = 0; j < grid[0].length; j++) {

        int curr = dp[i][j];
        int currGrid = grid[i][j];
        for (int c = 0; c < grid[0].length; c++) {
          int cost = moveCost[currGrid][c];
          int val = curr + cost + grid[i + 1][c];
          dp[i + 1][c] = Math.min(dp[i +1][c], val);
        }
      }
    }

    int lastRow = grid.length - 1;
    int ans = Integer.MAX_VALUE;
    for(int i = 0; i < grid[0].length;i++){
      ans = Math.min(ans, dp[lastRow][i]);
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[][] grid = {{5,3},{4,0},{2,1}};
    int[][] cost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
    s.minPathCost(grid,cost);
  }
}
