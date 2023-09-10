package com.leetcode.test129.graph.gfg.detectCycleInUndirectedGraph;

import java.util.ArrayList;

class Solution {
  // Function to detect cycle in an undirected graph.
  public boolean isCycle (int V, ArrayList<ArrayList<Integer>> adj) {

    boolean visited[] = new boolean[adj.size()];

    for (int i = 0; i < adj.size(); i++) {
      if (!visited[i]) {
        if (dfs(i, adj, -1, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs (int current, ArrayList<ArrayList<Integer>> adj, int parent, boolean[] visited) {
    visited[current] = true;
    for (int neighbour : adj.get(current)) {
      if (neighbour == parent)
        continue;
      if (visited[neighbour]) {
        return true;
      }
      else if (dfs(neighbour, adj, current, visited))
        return true;
    }
    return false;
  }
}
