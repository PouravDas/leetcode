package com.leetcode.test177.surroundedRegions;

//130. Surrounded Regions
class Solution {
  public void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if(board[i][j] == 'X') continue;
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean canFlip = canFlip(visited, board, i,j);
        if(canFlip) doFlip(board, i,j);
      }
    }
  }

  private void doFlip (char[][] board, int i, int j) {
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
    if(board[i][j] == 'X') return;

    board[i][j] = 'X';
    doFlip(board, i,j - 1);
    doFlip(board, i,j + 1);
    doFlip(board, i - 1,j);
    doFlip(board, i + 1,j);
  }

  private boolean canFlip (boolean[][] visited, char[][] board, int i, int j) {
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    if(visited[i][j]) return true;
    if(board[i][j] == 'X') return true;

    visited[i][j] = true;
    boolean left = canFlip(visited, board, i,j - 1);
    boolean right = canFlip(visited, board, i,j + 1);
    boolean top = canFlip(visited, board, i - 1,j);
    boolean bottom = canFlip(visited, board, i + 1,j);

    return left && right && top && bottom;
  }
}
