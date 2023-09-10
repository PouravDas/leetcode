package com.leetcode.test247.contest.third;

import java.util.ArrayList;
import java.util.List;

class Solution {
  int safe = Integer.MIN_VALUE;

  public int maximumSafenessFactor (List<List<Integer>> grid) {
    Integer[][] GRID = new Integer[grid.size()][grid.size()];
    for (int i = 0; i < GRID.length; i++) {
      for (int j = 0; j < GRID.length; j++) {
        GRID[i][j] = grid.get(i).get(j);
      }
    }
    if (GRID[0][0] == 1)
      return 0;
    boolean[][] visited = new boolean[GRID.length][GRID[0].length];
    List<List<Integer>> thieves = new ArrayList<>();
    for (int i = 0; i < GRID.length; i++) {
      for (int j = 0; j < GRID[i].length; j++) {
        if (GRID[i][j] == 1) {
          thieves.add(List.of(i, j));
        }
      }
    }
    Integer[][] dp = new Integer[GRID.length][GRID.length];
    for (int i = 0; i < GRID.length; i++) {
      for (int j = 0; j < GRID[i].length; j++) {
        int safeLoc = Integer.MAX_VALUE;
        for (List<Integer> t : thieves) {
          int s = 0;
          s = Math.abs(t.get(0) - i) + Math.abs(t.get(1) - j);
          safeLoc = Math.min(s, safeLoc);
        }
        dp[i][j] = safeLoc;
      }
    }

    dfs(0, 0, visited, GRID, thieves, Integer.MAX_VALUE, dp);
    return safe == Integer.MIN_VALUE ? 0 : safe;
  }

  private void dfs (int i, int j, boolean[][] visited, Integer[][] grid,
      List<List<Integer>> thieves, int safeLoc, Integer[][] dp) {

    safeLoc = Math.min(dp[i][j], safeLoc);
    if (i == grid.length - 1 && j == grid.length - 1) {
      safe = Math.max(safeLoc, safe);
      return;
    }

    visited[i][j] = true;

    if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] != 1) {
      dfs(i - 1, j, visited, grid, thieves, safeLoc, dp);
    }
    if (i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] != 1) {
      dfs(i + 1, j, visited, grid, thieves, safeLoc, dp);
    }
    if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] != 1) {
      dfs(i, j - 1, visited, grid, thieves, safeLoc, dp);
    }
    if (j < grid.length - 1 && !visited[i][j + 1] && grid[i][j + 1] != 1) {
      dfs(i, j + 1, visited, grid, thieves, safeLoc, dp);
    }

    visited[i][j] = false;
  }
}
