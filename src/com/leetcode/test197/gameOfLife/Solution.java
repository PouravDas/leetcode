package com.leetcode.test197.gameOfLife;

import java.util.Arrays;

//289. Game of Life
class Solution {
  public void gameOfLife (int[][] board) {
    int[][] copy = new int[board.length][];
    for (int i = 0; i < board.length; i++) {
      copy[i] = Arrays.copyOf(board[i], board[i].length);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int count = neighbours(i, j, copy);
        if (count < 2)
          board[i][j] = 0;
        else if (count == 3 && board[i][j] == 0)
          board[i][j] = 1;// nothing
        else if (count > 3)
          board[i][j] = 0;
      }
    }
  }

  private int neighbours (int i, int j, int[][] copy) {
    int ans = 0;
    ans += i > 0 ? copy[i - 1][j] : 0;
    ans += i < copy.length - 1 ? copy[i + 1][j] : 0;
    ans += j > 0 ? copy[i][j - 1] : 0;
    ans += j < copy[0].length - 1 ? copy[i][j + 1] : 0;

    ans += i > 0 && j > 0 ? copy[i - 1][j - 1] : 0;
    ans += i > 0 && j < copy[0].length - 1 ? copy[i - 1][j + 1] : 0;
    ans += i < copy.length - 1 && j > 0 ? copy[i + 1][j - 1] : 0;
    ans += i < copy.length - 1 && j < copy[0].length - 1 ? copy[i + 1][j + 1] : 0;
    return ans;
  }
}
