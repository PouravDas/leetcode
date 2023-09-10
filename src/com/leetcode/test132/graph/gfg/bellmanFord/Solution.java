package com.leetcode.test132.graph.gfg.bellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  static final int MAX = 1_0000_0000;

  static int[] bellman_ford (int V, ArrayList<ArrayList<Integer>> edges, int S) {
    int[] dist = new int[V];
    Arrays.fill(dist, MAX);
    dist[S] = 0;
    for (int i = 0; i < V - 1; i++) {
      for (ArrayList<Integer> e : edges) {
        int u = e.get(0);
        int v = e.get(1);
        int w = e.get(2);
        if (dist[u] != MAX && dist[u] + w < dist[v]) {
          dist[v] = dist[u] + w;
        }
      }
    }
    for (ArrayList<Integer> e : edges) {
      int u = e.get(0);
      int v = e.get(1);
      int w = e.get(2);
      if (dist[u] != MAX && dist[u] + w < dist[v]) {
        return new int[] {-1};
      }
    }
    return dist;
  }
}
