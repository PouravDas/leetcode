package com.leetcode.test311.minimumTime;

import java.util.ArrayList;
import java.util.List;

//2050. Parallel Courses III
//hard
class Solution {
  List<Integer>[] adjMat;

  public int minimumTime (int n, int[][] relations, int[] time) {
    adjMat = new List[n];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      adjMat[i] = new ArrayList<>();
    }
    int[] dp = new int[n];
    for (int[] r : relations) {
      adjMat[r[0] - 1].add(r[1] - 1);
    }
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, dfs(i, dp, time));
    }
    return ans;
  }

  int dfs (int i, int[] dp, int[] time) {
    if (dp[i] != 0)
      return dp[i];
    int max = 0;
    for (int n : adjMat[i]) {
      max = Math.max(max, dfs(n,dp,time));
    }
    return dp[i] = max + time[i];
  }
}
