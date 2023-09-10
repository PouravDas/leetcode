package com.leetcode.test230.knightProbability;

//688. Knight Probability in Chessboard
class Solution {

  public double knightProbability (int n, int k, int row, int column) {
    double[][] curr = new double[n][n];
    double[][] next = new double[n][n];

    curr[row][column] = 1;

    for (int t = 0; t < k; t++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (curr[i][j] != 0) {
            for (int[] nex : findNextMoves(i, j)) {
              if (inBoard(nex, n)) {
                next[nex[0]][nex[1]] += curr[i][j] / 8;
              }
            }
          }
        }
      }
      curr = next;
      next = new double[n][n];
    }
    double ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ans += curr[i][j];
      }
    }
    return ans;
  }

  private boolean inBoard (int[] nex, int n) {
    return nex[0] > -1 && nex[0] < n && nex[1] > -1 && nex[1] < n;
  }

  private int[][] findNextMoves (int i, int j) {
    int[][] ans = new int[8][];
    ans[0] = new int[] {i - 1, j - 2};
    ans[1] = new int[] {i - 2, j - 1};
    ans[2] = new int[] {i - 2, j + 1};
    ans[3] = new int[] {i - 1, j + 2};
    ans[4] = new int[] {i + 1, j + 2};
    ans[5] = new int[] {i + 2, j + 1};
    ans[6] = new int[] {i + 2, j - 1};
    ans[7] = new int[] {i + 1, j - 2};
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.knightProbability(3, 2, 0, 0);
  }
}
