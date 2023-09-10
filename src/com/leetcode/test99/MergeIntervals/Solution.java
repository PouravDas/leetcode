package com.leetcode.test99.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// # 56
class Solution {
  public int[][] merge (int[][] intervals) {
    List<int[]> list = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int[] curr = null;
    for (int[] in : intervals) {
      if (curr == null) {
        curr = in;
        continue;
      } else if (curr[1] >= in[0]) {
        curr[1] = Math.max(in[1], curr[1]);
      } else {
        list.add(Arrays.copyOf(curr, curr.length));
        curr = in;
      }
    }
    list.add(curr);
    final int[][] ans = new int[list.size()][];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
}
