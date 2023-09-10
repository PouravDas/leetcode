package com.leetcode.test69.minimumPathSum;

public class Solution {
  public int minPathSum (int[][] grid) {

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if(i == 0 && j ==0){
          continue;
        }
        int top = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
        int left = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
        grid[i][j] = grid[i][j] + Math.min(left, top);
      }
    }
    return grid[grid.length - 1][grid[0].length - 1];
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    System.out.println(ans);
  }
}
