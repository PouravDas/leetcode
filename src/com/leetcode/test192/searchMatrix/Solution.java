package com.leetcode.test192.searchMatrix;

import java.util.PriorityQueue;

//240. Search a 2D Matrix II
class Solution {
  public boolean searchMatrix (int[][] matrix, int target) {

    PriorityQueue<Element> queue = new PriorityQueue<>();
    for (int i = 0; i < matrix.length; i++) {
      queue.offer(new Element(matrix[i][0], i, 0));
    }
    int current = matrix[0][0];
    while (!queue.isEmpty()) {
      Element el = queue.poll();
      if (el.val == target)
        return true;
      else if (el.val > target)
        return false;

      if (el.j < matrix[0].length - 1)
        queue.offer(new Element(matrix[el.i][el.j + 1], el.i, el.j + 1));
    }
    return false;
  }

  private static class Element implements Comparable<Element> {
    int val, i, j;

    Element (int val, int i, int j) {
      this.val = val;
      this.i = i;
      this.j = j;
    }

    @Override public int compareTo (Element o) {
      return this.val - o.val;
    }
  }
}
