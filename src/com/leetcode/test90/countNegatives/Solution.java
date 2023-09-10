package com.leetcode.test90.countNegatives;

//#1351
class Solution {
  public int countNegatives (int[][] grid) {

    int count = 0;

    int i = grid.length - 1;
    int j = 0;

    while (i >= 0) {
      while (j < grid[i].length && grid[i][j] >= 0) {
        j++;
      }
      if (j == grid[i].length) {
        return count;
      }
      int negativesInRight = grid[i].length - j;

      if (negativesInRight == 0)
        return count;


      while (i >= 0 && grid[i][j] < 0) {
        count += negativesInRight;
        i--;
      }
    }
    return count;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //s.countNegatives(new int[][] {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}
    //s.countNegatives(new int[][] {{3,2},{1,0}});
    s.countNegatives(new int[][] {{7, -3}});
  }
}
