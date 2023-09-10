package com.leetcode.test255.spiralOrder;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> spiralOrder (int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    int gap = 0;
    int i = 0, j = 0;
    while (gap <= matrix.length / 2 && gap <= matrix[0].length / 2) {
      i = gap;
      for (j = 0 + gap; j < matrix[0].length - gap; j++) {
        if (matrix[i][j] != Integer.MIN_VALUE) {
          list.add(matrix[i][j]);
          matrix[i][j] = Integer.MIN_VALUE;
        }
      }
      j = matrix[0].length - 1 - gap;
      for (i = gap + 1; i < matrix.length - gap; i++) {
        if (matrix[i][j] != Integer.MIN_VALUE) {
          list.add(matrix[i][j]);
          matrix[i][j] = Integer.MIN_VALUE;
        }
      }
      i = matrix.length - 1 - gap;
      for (j = matrix[0].length - 2 - gap; j >= gap; j--) {
        if (matrix[i][j] != Integer.MIN_VALUE) {
          list.add(matrix[i][j]);
          matrix[i][j] = Integer.MIN_VALUE;
        }
      }
      j = gap;
      for (i = matrix.length - 2 - gap; i >= gap + 1; i--) {
        if (matrix[i][j] != Integer.MIN_VALUE) {
          list.add(matrix[i][j]);
          matrix[i][j] = Integer.MIN_VALUE;
        }
      }
      gap++;
    }
    return list;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
  }
}
