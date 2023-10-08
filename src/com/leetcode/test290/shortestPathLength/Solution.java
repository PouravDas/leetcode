package com.leetcode.test290.shortestPathLength;

import java.util.HashSet;
import java.util.Set;

//
class Solution {
  public int shortestPathLength (int[][] graph) {
    int min = Integer.MAX_VALUE;
    if (graph.length < 2)
      return 0;
    int finalState = (1 << graph.length) - 1;
    for (int i = 0; i < graph.length; i++) {
      Set<Integer> visited = new HashSet<>();
      int curr = (i << 16) | (1 << i);
      visited.add(curr);
      min = Math.min(min, dfs(curr, graph, visited, finalState));
    }
    return min;
  }

  int dfs (int curr, int[][] graph, Set<Integer> visited, int finalState) {
    if((curr & finalState) == finalState) return 0;
    int idx = curr >> 16;
    int min = 1000_000;
    for (int i = 0; i < graph[idx].length; i++) {
      int nextNode = graph[idx][i];
      int nextState = (nextNode << 16) | (curr & finalState) | (1 << nextNode);
      if(!visited.contains(nextState)) {
        visited.add(nextState);
        min = Math.min(min, 1 + dfs(nextState, graph, visited, finalState));
        visited.remove(nextState);
      }
    }
    return min;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int ans = s.shortestPathLength(new int[][] {{1,2,3},{0},{0},{0}});
    System.out.println(ans);
  }
}
