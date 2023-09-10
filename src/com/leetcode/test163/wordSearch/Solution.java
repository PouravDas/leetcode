package com.leetcode.test163.wordSearch;

//79. Word Search
class Solution {
  public boolean exist (char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (exit(board, i, j, word, 0, visited))
          return true;
      }
    }
    return false;
  }

  private boolean exit (char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
    if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
      return false;

    if (!visited[i][j] && board[i][j] == word.charAt(idx)) {
      if (word.length() == idx + 1)
        return true;
      visited[i][j] = true;
      if (exit(board, i - 1, j, word, idx + 1, visited))
        return true;
      if (exit(board, i + 1, j, word, idx + 1, visited))
        return true;
      if (exit(board, i, j - 1, word, idx + 1, visited))
        return true;
      if (exit(board, i, j + 1, word, idx + 1, visited))
        return true;
      visited[i][j] = false;
    }
    return false;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    String in = "aaaa";
    boolean ans = s.exist(new char[][] {in.toCharArray(), in.toCharArray(), in.toCharArray()},
        "aaaaaaaaaaaaa");
    System.out.println(ans);
  }
}
