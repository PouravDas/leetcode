package com.leetcode.test94.minimizedMaximum;

import java.util.Arrays;

public class solution2 {
  public int minimizedMaximum(int n, int[] quantities) {
    int min = 1;
    int max = Arrays.stream(quantities).max().getAsInt();
    int minMax = max;
    while (min <= max) {
      int mid = (max + min) / 2;
      if (isPossible(n, quantities, mid)) {
        minMax = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return minMax;
  }

  private boolean isPossible(int n, int[] quantities, int size) {
    for (int quantity : quantities) {
      while (quantity > 0) {
        quantity -= size;
        n--;
      }
    }
    return n >= 0;
  }
}
