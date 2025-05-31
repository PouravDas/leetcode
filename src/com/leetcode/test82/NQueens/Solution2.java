package com.leetcode.test82.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
  List<List<String>> ans = new ArrayList<>();
  public List<List<String>> solveNQueens(int n) {
    boolean[][] matrix = new boolean[n][n];
    backtrack(matrix, 0);
    return ans;
  }

  void backtrack(boolean[][] matrix, int row) {
    if (row == matrix.length) {
      List<String> list = new ArrayList<>();
      for (boolean[] ro : matrix) {
        int i =0;
        char[] chars = new char[ro.length];
        for (boolean b : ro) chars[i++] = b ? 'Q' : '.';
        list.add(new String(chars));
      }
      ans.add(list);
      return;
    }
    for (int i = 0; i < matrix.length; i++) {
      if(isPossible(matrix, row, i)) {
        matrix[row][i] = true;
        backtrack(matrix, row + 1);
        matrix[row][i] = false;
      }
    }
  }

  boolean isPossible(boolean[][] matrix, int row, int col) {
    for (int i = row - 1; i >= 0; i--) {
      if (matrix[i][col]) return false;
    }
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (matrix[i][j]) return false;
    }
    for (int i = row - 1, j = col + 1; i >= 0 && j < matrix.length; i--, j++) {
      if (matrix[i][j]) return false;
    }
    return true;
  }
}
