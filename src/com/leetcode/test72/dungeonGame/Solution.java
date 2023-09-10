package com.leetcode.test72.dungeonGame;

public class Solution {
  public int calculateMinimumHP (int[][] dungeon) {

    int[][] dp = new int[dungeon.length][dungeon[0].length];

    for (int i = dungeon.length - 1; i >= 0; i--) {
      for (int j = dungeon[i].length - 1; j >= 0; j--) {
        if (i == dungeon.length - 1 && j == dungeon[i].length - 1) {
          dp[i][j] = dungeon[i][j];
        } else {
          int d = i == dungeon.length - 1 ? Integer.MIN_VALUE : dp[i + 1][j];
          int r = j == dungeon[i].length - 1 ? Integer.MIN_VALUE : dp[i][j + 1];
          dp[i][j] = dungeon[i][j] + Math.max(d, r);
        }
        if (dp[i][j] > 0) {
          dp[i][j] = 0;
        }
      }
    }
    int ans = dp[0][0];
    if (ans < 0) {
      return -1 * ans + 1;
    } else {
      return 1;
    }
  }

  public static void main (String[] args) {

    Solution s = new Solution();
    int ans = s.calculateMinimumHP(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    System.out.println(ans);
  }
}
