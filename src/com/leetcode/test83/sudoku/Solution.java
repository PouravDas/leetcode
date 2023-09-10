package com.leetcode.test83.sudoku;

import java.util.Stack;

class Solution {

  public static final int SIZE = 9;

  public void solveSudoku (char[][] board) {

    Stack<int[]> stack = new Stack<>();

    int row = 0;
    int col = 0;
    while (row < SIZE && col < SIZE) {

      boolean nextCell = false;
      char cell = board[row][col];
      boolean fromStack = false;
      if (!stack.isEmpty()) {
        int[] lastFill = stack.peek();
        if (lastFill[0] == row && lastFill[1] == col) {
          fromStack = true;
          stack.pop();
          board[row][col] = '.';
          cell++;
        }
      }
      if (cell == '.' || fromStack) {
        char fill = cell;
        if (cell == '.') {
          fill = '1';
        }
        while (!isSafe(board, row, col, fill) && fill <= '9') {
          fill++;
        }
        if (fill > '9') {
          int[] lastFill = stack.peek();
          row = lastFill[0];
          col = lastFill[1];
        } else {
          board[row][col] = fill;
          stack.push(new int[] {row, col});
          nextCell = true;
        }
      } else {
        nextCell = true;
      }
      if (nextCell) {
        if (col < SIZE - 1) {
          col++;
        } else {
          row++;
          col = 0;
        }
      }
    }
  }

  private boolean isSafe (char[][] board, int row, int col, char fill) {
    // in row
    // in column
    for (int i = 0; i < SIZE; i++) {
      if (board[i][col] == fill || board[row][i] == fill)
        return false;
    }

    // in sub-box
    int iStart;
    int jStart;

    if (row < 3)
      iStart = 0;
    else if (row < 6)
      iStart = 3;
    else
      iStart = 6;

    if (col < 3)
      jStart = 0;
    else if (col < 6)
      jStart = 3;
    else
      jStart = 6;

    for (int i = iStart; i < iStart + 3; i++) {
      for (int j = jStart; j < jStart + 3; j++) {
        if (board[i][j] == fill)
          return false;
      }
    }
    return true;
  }


  public static void main (String[] args) {
    Solution s = new Solution();
    s.solveSudoku(board);
    System.out.println(board);
  }

  private static char[][] board = new char[][] {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
}
