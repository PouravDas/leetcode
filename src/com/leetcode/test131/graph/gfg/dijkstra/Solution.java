package com.leetcode.test131.graph.gfg.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Solution {
  static int[] dijkstra (int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source) {
    int[] ans = new int[V];
    Arrays.fill(ans, Integer.MAX_VALUE);
    dijkstra(source, adj, ans);
    return ans;
  }

  static void dijkstra (int source, ArrayList<ArrayList<ArrayList<Integer>>> adj, int[] ans) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    boolean[] visited = new boolean[ans.length];
    pq.add(new Pair(source, 0));
    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      if (visited[pair.node])
        continue;
      visited[pair.node] = true;
      if (ans[pair.node] > pair.weight) {
        ans[pair.node] = pair.weight;
      }
      adj.get(pair.node).forEach(n -> pq.offer(new Pair(n.get(0), pair.weight + n.get(1))));
    }
  }

  private static class Pair implements Comparable<Pair> {
    int node, weight;

    Pair (int n, int w) {
      node = n;
      weight = w;
    }

    @Override public int compareTo (Pair that) {
      return this.weight - that.weight;
    }
  }
}
