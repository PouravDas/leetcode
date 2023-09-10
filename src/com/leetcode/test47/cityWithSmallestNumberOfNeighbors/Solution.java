package com.leetcode.test47.cityWithSmallestNumberOfNeighbors;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int findTheCity (int n, int[][] edges, int distanceThreshold) {
    int min = Integer.MAX_VALUE;
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }
    Map<Integer, Node> map = new HashMap<>();
    for (int[] e : edges) {
      Node from = nodes[e[0]];
      Node to = nodes[e[1]];
      int weight = e[2];
      from.neighbours.put(to.city, weight);
      to.neighbours.put(from.city, weight);
    }
    int ans = 0;
    for (Node node : nodes) {
      int minLoco = findNeighbours(node.city, new boolean[n], nodes, distanceThreshold);
      if (minLoco <= min) {
        min = minLoco;
        ans = node.city;
      }
    }
    return ans;
  }

  private int findNeighbours (int city, boolean[] seen, Node[] nodes, int distanceThreshold) {
    seen[city] = true;
    int size = 0;
    PriorityQueue<Pair> queue = new PriorityQueue<>();
    nodes[city].neighbours.entrySet().forEach(e -> {
      queue.add(new Pair(e.getKey(), e.getValue()));
    });
    while (!queue.isEmpty() && queue.peek().weight <= distanceThreshold) {
      Pair p = queue.poll();
      if (!seen[p.city]) {
        size++;
        seen[p.city] = true;
        nodes[p.city].neighbours.entrySet().forEach(e -> {
          queue.add(new Pair(e.getKey(), e.getValue() + p.weight));
        });
      }
    }
    return size;
  }

  private static class Pair implements Comparable<Pair> {
    int city, weight;

    Pair (int c, int w) {
      city = c;
      weight = w;
    }

    @Override public int compareTo (Pair o) {
      return this.weight - o.weight;
    }
  }


  private static class Node {
    int city;
    Map<Integer, Integer> neighbours;

    public Node (int c) {
      city = c;
      neighbours = new HashMap<>();
    }
  }

  public static void main (String[] args) {
    int[][] graph = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};

    Solution s = new Solution();
    s.findTheCity(4, graph, 4);
  }
}
