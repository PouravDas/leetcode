package com.leetcode.test292.kWeakestRows;

import java.util.PriorityQueue;

class Solution {
  public int[] kWeakestRows (int[][] mat, int k) {
    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    for (int i = 0; i < mat.length; i++) {
      int strength = 0;
      for (int n : mat[i])
        if (n == 1)
          strength++;
      pq.offer(new int[] {strength, i});
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = pq.poll()[1];
    }
    return ans;
  }
}
