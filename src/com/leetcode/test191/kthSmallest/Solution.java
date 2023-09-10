package com.leetcode.test191.kthSmallest;

import java.util.PriorityQueue;

//378. Kth Smallest Element in a Sorted Matrix
class Solution {
  public int kthSmallest (int[][] matrix, int k) {
    PriorityQueue<Element> queue = new PriorityQueue<>();

    for (int i = 0; i < matrix.length; i++) {
      queue.offer(new Element(matrix[i][0], i, 0));
    }

    int size = 0;
    int ans = -1;
    while (size < k) {
      Element el = queue.poll();
      ans = el.val;
      if (el.j < matrix[0].length - 1) {
        queue.offer(new Element(matrix[el.i][el.j + 1], el.i, el.j + 1));
      }
      size++;
    }
    return ans;
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
