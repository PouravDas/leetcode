package com.leetcode.test258.updateMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
  public int[][] updateMatrix (int[][] mat) {
    boolean[][] seen = new boolean[mat.length][mat[0].length];
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        //touching 1
        if (mat[i][j] == 0) {
          boolean touching = false;
          if (i > 0 && mat[i - 1][j] == 1)
            touching = true;
          else if (i < mat.length - 1 && mat[i + 1][j] == 1)
            touching = true;
          else if (j > 0 && mat[i][j - 1] == 1)
            touching = true;
          else if (j < mat[0].length - 1 && mat[i][j + 1] == 1)
            touching = true;
          if (touching)
            queue.add(new int[] {i, j});
        }
      }
    }
    int distance = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] e = queue.poll();
        int i = e[0];
        int j = e[1];
        if (i > 0 && mat[i - 1][j] == 1 && !seen[i - 1][j]) {
          mat[i - 1][j] = distance;
          seen[i - 1][j] = true;
          queue.add(new int[] {i - 1, j});
        }
        if (i < mat.length - 1 && mat[i + 1][j] == 1 && !seen[i + 1][j]) {
          mat[i + 1][j] = distance;
          seen[i + 1][j] = true;
          queue.add(new int[] {i + 1, j});
        }
        if (j > 0 && mat[i][j - 1] == 1 && !seen[i][j - 1]) {
          mat[i][j - 1] = distance;
          seen[i][j - 1] = true;
          queue.add(new int[] {i, j - 1});
        }
        if (j < mat[0].length - 1 && mat[i][j + 1] == 1 && !seen[i][j + 1]) {
          mat[i][j + 1] = distance;
          seen[i][j + 1] = true;
          queue.add(new int[] {i, j + 1});
        }
      }
      distance++;
    }
    return mat;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.updateMatrix(new int[][] {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1},
        {1, 0, 0, 0, 1}});
  }
}
