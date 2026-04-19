package com.leetcode.test348.insertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    boolean inserted = false;
    for (int[] interval : intervals) {
      if (!inserted) {
        if (isMergeable(interval, newInterval)) {
          result.add(merge(interval, newInterval));
          inserted = true;
        } else {
          if(newInterval[0] < interval[0]) {
            result.add(newInterval);
            inserted = true;
          }
          result.add(interval);
        }
      } else {
        int[] last = result.get(result.size() - 1);
        if (isMergeable(last, interval)) {
          merge(last, interval);
        } else {
          result.add(interval);
        }
      }
    }
    if (!inserted) result.add(newInterval);
    return result.toArray(int[][]::new);
  }

  boolean isMergeable(int[] a, int[] b) {
    return !(a[1] < b[0] || b[1] < a[0]);
  }

  int[] merge(int[] a, int[] b) {
    a[0] = Math.min(a[0], b[0]);
    a[1] = Math.max(a[1], b[1]);
    return a;
  }
}
