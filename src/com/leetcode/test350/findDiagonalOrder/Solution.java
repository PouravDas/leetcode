package com.leetcode.test350.findDiagonalOrder;

public class Solution {

  public int[] findDiagonalOrder(int[][] mat) {
    int[] ans = new int[mat.length * mat[0].length];
    int col = 0;
    int row = 0;
    boolean up = true;
    int i = 0;
    while (i < ans.length) {
      if (up) {
        while (true) {
          System.out.println("up");
          System.out.println("i " + i);
          System.out.println("col = " + col + " row = " + row);
          System.out.println("ans = " + mat[col][row]);
          ans[i++] = mat[col][row];
          if (canGo(up, col, row, mat)) {
            col--;
            row++;
          } else {
            if (row < mat[0].length - 1)
              row++;
            else
              col++;
            break;
          }
        }
      } else {
        while (true) {
          System.out.println("down");
          System.out.println("i " + i);
          System.out.println("col = " + col + " row = " + row);
          System.out.println("ans = " + mat[col][row]);
          ans[i++] = mat[col][row];
          if (canGo(up, col, row, mat)) {
            col++;
            row--;
          } else {
            if (col < mat.length - 1)
              col++;
            else
              row++;
            break;
          }
        }
      }
      up = !up;
    }
    return ans;
  }

  private boolean canGo(boolean up, int col, int row, int[][] mat) {
    if (up) {
      return col > 0 && row < mat[0].length - 1;
    } else {
      return col < mat.length - 1 && row > 0;
    }
  }
}