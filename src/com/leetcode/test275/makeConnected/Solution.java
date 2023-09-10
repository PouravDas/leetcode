package com.leetcode.test275.makeConnected;

import java.util.HashSet;
import java.util.Set;

//1319. Number of Operations to Make Network Connected
class Solution {
  public int makeConnected (int n, int[][] connections) {
    if (connections.length < n - 1)
      return -1;
    Node[] allNodes = new Node[n];
    for (int i = 0; i < n; i++) {
      allNodes[i] = new Node(i);
    }
    for (int[] c : connections) {
      allNodes[c[0]].neighbours.add(c[1]);
      allNodes[c[1]].neighbours.add(c[0]);
    }
    Set<Integer> visited = new HashSet<>(n);
    int components = 0;
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        dfs(i, allNodes, visited);
        components++;
      }
    }
    return components - 1;
  }

  void dfs (int v, Node[] allNodes, Set<Integer> visited) {
    if (!visited.contains(v)) {
      visited.add(v);
      for (int n : allNodes[v].neighbours) {
        dfs(n, allNodes, visited);
      }
    }
  }

  static class Node {
    int id;
    Set<Integer> neighbours;

    Node (int i) {
      id = i;
      neighbours = new HashSet<>();
    }
  }
}
