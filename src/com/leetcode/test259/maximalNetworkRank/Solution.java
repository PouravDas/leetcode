package com.leetcode.test259.maximalNetworkRank;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public int maximalNetworkRank (int n, int[][] roads) {
    int[] inOrder = new int[n];
    int[][] connected = new int[n][n];
    for (int[] r : roads) {
      inOrder[r[0]]++;
      inOrder[r[1]]++;
      connected[r[0]][r[1]] = 1;
      connected[r[1]][r[0]] = 1;
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        max = Math.max(max, inOrder[i] + inOrder[j] - connected[i][j]);
      }
    }
    return max;
  }
}
