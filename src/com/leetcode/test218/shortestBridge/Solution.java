package com.leetcode.test218.shortestBridge;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
  public int shortestBridge (int[][] grid) {
    Queue<Pair> queue = new ArrayDeque<>();
    boolean found = false;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          dfs(i, j, grid, queue);
          found = true;
          break;
        }
      }
      if (found)
        break;
    }
    int steps = 0;

    while(!queue.isEmpty()) {
      int s = queue.size();
      while (s-- > 0) {
        Pair p = queue.poll();
        int i = p.x;
        int j = p.y;
        if (i > 0) {
          if (grid[i - 1][j] == 0) {
            grid[i - 1][j] = 2;
            queue.offer(new Pair(i - 1, j));
          } else if (grid[i - 1][j] == 1) {
            return steps;
          }
        }
        if (j > 0) {
          if (grid[i][j - 1] == 0) {
            grid[i][j - 1] = 2;
            queue.offer(new Pair(i, j - 1));
          } else if (grid[i][j - 1] == 1) {
            return steps;
          }
        }
        if (i != grid.length - 1) {
          if (grid[i + 1][j] == 0) {
            grid[i + 1][j] = 2;
            queue.offer(new Pair(i + 1, j));
          } else if (grid[i + 1][j] == 1) {
            return steps;
          }
        }
        if (j != grid[0].length - 1) {
          if (grid[i][j + 1] == 0) {
            grid[i][j + 1] = 2;
            queue.offer(new Pair(i, j + 1));
          } else if (grid[i][j + 1] == 1) {
            return steps;
          }
        }
      }
      steps++;
    }
    return -1;
  }

  private void dfs (int i, int j, int[][] grid, Queue<Pair> queue) {
    if (touchingWater(i, j, grid)) {
      queue.offer(new Pair(i, j));
    }
    grid[i][j] = 2;
    if (i > 0 && grid[i - 1][j] == 1) {
      dfs(i - 1, j, grid, queue);
    }
    if (j > 0 && grid[i][j - 1] == 1) {
      dfs(i, j - 1, grid, queue);
    }
    if (i != grid.length - 1 && grid[i + 1][j] == 1) {
      dfs(i + 1, j, grid, queue);
    }
    if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
      dfs(i, j + 1, grid, queue);
    }
  }

  private boolean touchingWater (int i, int j, int[][] grid) {
    if (i > 0 && grid[i - 1][j] == 0) {
      return true;
    }
    if (j > 0 && grid[i][j - 1] == 0) {
      return true;
    }
    if (i != grid.length - 1 && grid[i + 1][j] == 0) {
      return true;
    }
    if (j != grid[0].length - 1 && grid[i][j + 1] == 0) {
      return true;
    }
    return false;
  }

  private static class Pair {
    int x, y;

    Pair (int i, int j) {
      x = i;
      y = j;
    }

    @Override public String toString () {
      return "Pair{" + "x=" + x + ", y=" + y + '}';
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.shortestBridge(new int[][]{{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}});
  }
}
