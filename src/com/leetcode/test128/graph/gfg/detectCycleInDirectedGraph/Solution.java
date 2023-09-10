package com.leetcode.test128.graph.gfg.detectCycleInDirectedGraph;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
class Solution {
  // Function to detect cycle in a directed graph.
  public boolean isCyclic (int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(i, adj, visited, recStack))
          return true;
      }
    }
    return false;
  }

  private boolean dfs (int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
      boolean[] recStack) {
    visited[node] = true;
    recStack[node] = true;
    for (int neighbour : adj.get(node)) {
      if (recStack[neighbour])
        return true;
      if (!visited[neighbour]) {
        if (dfs(neighbour, adj, visited, recStack))
          return true;
      }
    }
    recStack[node] = false;
    return false;
  }
}
