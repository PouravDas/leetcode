package com.leetcode.test147.nonOverlappingInterval;

import java.util.Arrays;
import java.util.Comparator;

// 435. Non-overlapping Intervals
public class Solution {
  public int eraseOverlapIntervals (int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(ints -> ints[1]));

    int[] curr = null;
    int inSize = 0;
    for (int[] in : intervals) {
      if (curr == null) {
        curr = in;
        inSize++;
      }
      if (in[0] < curr[1]) {
        continue;
      } else {
        curr = in;
        inSize++;
      }
    }
    return intervals.length - inSize;
  }
}
