package com.leetcode.test219.minimumJumps;

import java.util.HashSet;
import java.util.Set;

//not working
class Solution {
  int min = Integer.MAX_VALUE;

  public int minimumJumps (int[] forbidden, int a, int b, int x) {
    Set<Integer> set = new HashSet<>();
    for (int f : forbidden) {
      set.add(f);
    }
    dfs(set, 0, 0, a, b, x, false);
    return Integer.MAX_VALUE == min ? -1 : min;
  }

  private void dfs (Set<Integer> forbidden, int curr, int steps, int forward, int back, int target,
      boolean wentBack) {
    if (curr == target) {
      min = Math.min(min, steps);
      return;
    }
    if (curr < 0 || forbidden.contains(curr) || curr > target + back) {
      return;
    }
    dfs(forbidden, curr + forward, steps + 1, forward, back, target, false);
    if (!wentBack)
      dfs(forbidden, curr - back, steps + 1, forward, back, target, true);
  }
}
