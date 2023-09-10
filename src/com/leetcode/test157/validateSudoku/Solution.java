package com.leetcode.test157.validateSudoku;

// 36. Valid Sudoku
class Solution {
  public boolean isValidSudoku (char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != '.') {
          if (!valid(i, j, board))
            return false;
        }
      }
    }
    return true;
  }

  private boolean valid (int row, int col, char[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (board[row][col] == board[i][col] && i != row)
        return false;
      if (board[row][col] == board[row][i] && i != col)
        return false;
    }
    int I = row / 3;
    int J = col / 3;
    I *= 3;
    J *= 3;
    for (int i = I; i < I + 3; i++) {
      for (int j = J; j < J + 3; j++) {
        if (i == row && j == col)
          continue;
        if (board[row][col] == board[i][j])
          return false;
      }
    }
    return true;
  }
}
