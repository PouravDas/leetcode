package com.leetcode.test82.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  List<List<String>> ans = new ArrayList<>();

  public List<List<String>> solveNQueens (int n) {
    char[][] board = new char[n][n];
    for (char[] row : board)
      Arrays.fill(row, '.');
    nQueens(board, 0);
    return ans;
  }

  private void nQueens (char[][] board, int row) {
    if (row == board.length) {
      addToAns(board);
      return;
    }
    for (int col = 0; col < board[row].length; col++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 'Q';
        nQueens(board, row + 1);
        board[row][col] = '.';
      }
    }
  }

  private boolean isSafe (char[][] board, int row, int col) {
    int i = 1;
    while (row - i >= 0) {
      if (board[row - i][col] == 'Q')
        return false;
      i++;
    }
    i = 1;
    while (row - i >= 0 && col - i >= 0) {
      if (board[row - i][col - i] == 'Q')
        return false;
      i++;
    }
    i = 1;
    while (row - i >= 0 && col + i < board.length) {
      if (board[row - i][col + i] == 'Q')
        return false;
      i++;
    }
    return true;
  }

  private void addToAns (char[][] board) {
    List<String> list = new ArrayList<>();
    for (char[] arr : board) {
      list.add(new String(arr));
    }
    ans.add(list);
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    List<List<String>> an = s.solveNQueens(4);
    System.out.println(an);
  }
}
