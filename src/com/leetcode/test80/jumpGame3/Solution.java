package com.leetcode.test80.jumpGame3;

class Solution {
  Boolean ans = false;

  public boolean canReach (int[] arr, int start) {
    boolean seen[] = new boolean[arr.length];
    dfs(start, arr, seen);
    return ans;
  }

  private void dfs (int idx, int[] arr, boolean[] seen) {
    if (arr[idx] == 0) {
      ans = true;
      return;
    }
    seen[idx] = true;
    int val = arr[idx];
    if (idx + val < arr.length && !seen[idx + val])
      dfs(idx + val, arr, seen);
    if (idx - val >= 0 && !seen[idx - val])
      dfs(idx - val, arr, seen);
  }
}
