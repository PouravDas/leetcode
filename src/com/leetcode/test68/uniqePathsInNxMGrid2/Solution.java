package com.leetcode.test68.uniqePathsInNxMGrid2;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int uniquePathsWithObstacles (int[][] obstacleGrid) {

    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    if(obstacleGrid[0][0] == 1)
      return 0;
    dp[0][0] = 1;

    for (int i = 0; i < obstacleGrid.length; i++) {
      for (int j = 0; j < obstacleGrid[i].length; j++) {
        if (i == 0 && j == 0)
          continue;
        if (obstacleGrid[i][j] == 0) {
          int left = i > 0 ? dp[i - 1][j] : 0;
          int top = j > 0 ? dp[i][j - 1] : 0;
          dp[i][j] = left + top;
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }

  public static void main (String[] args) {
    Map<String, Integer> map = new HashMap<>();
    Solution s = new Solution();
    int ans = s.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    System.out.println(ans);
  }
}
