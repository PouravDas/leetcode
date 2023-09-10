package com.leetcode.test130.graph.gfg.minSpanningTree;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class Solution {
  static int spanningTree (int V, int E, int edges[][]) {
    // Code Here.
    int sum = 0;

    Map<Integer, Node> map = new HashMap<>();
    for (int[] e : edges) {
      Node node = map.getOrDefault(e[0], new Node(e[0]));
      if (!map.containsKey(e[0]))
        map.put(e[0], node);
      Node target = map.getOrDefault(e[1], new Node(e[1]));
      if (!map.containsKey(e[1]))
        map.put(e[1], target);
      node.add(target, e[2]);
      target.add(node, e[2]);
    }

    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.weight));
    boolean[] visited = new boolean[V];
    queue.offer(new Pair(map.get(edges[0][0]), 0));
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      Node node = pair.node;
      int weight = pair.weight;
      if (!visited[node.id]) {
        visited[node.id] = true;
        sum += weight;
        for (int i = 0; i < node.neighbours.size(); i++) {
          Node neighbour = node.neighbours.get(i);
          if (!visited[neighbour.id]) {
            queue.offer(new Pair(neighbour, node.weights.get(i)));
          }
        }
      }
    }
    return sum;
  }

  private static class Node {
    int id;
    List<Node> neighbours;
    List<Integer> weights;

    Node (int i) {
      id = i;
      neighbours = new ArrayList<>();
      weights = new ArrayList<>();
    }

    public void add (Node target, int weight) {
      neighbours.add(target);
      weights.add(weight);
    }

    @Override public String toString () {
      return "Node{" + "id=" + id + '}';
    }
  }


  private static class Pair {
    Node node;
    int weight;

    Pair (Node n, int w) {
      node = n;
      weight = w;
    }
  }

  public static void main (String[] args) {
    Solution.spanningTree(3, 3, new int[][] {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}});
  }
}
