package com.leetcode.test12.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution2 {
  public Node cloneGraph(Node node) {
    if (node == null) return node;
    Map<Integer, Node> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    cloneGraph(node, map, visited);
    return map.get(node.val);
  }

  public void cloneGraph(Node ogNode, Map<Integer, Node> map, Set<Integer> visited) {
    if (visited.contains(ogNode.val)) return;
    visited.add(ogNode.val);
    Node newNode = map.computeIfAbsent(ogNode.val, Node::new);

    for (Node neighbor : ogNode.neighbors) {
      Node newNeighbor = map.computeIfAbsent(neighbor.val, Node::new);
      newNode.neighbors.add(newNeighbor);
    }

    for (Node neighbor : ogNode.neighbors) {
      cloneGraph(neighbor, map, visited);
    }
  }


  public int maxProductPath(int[][] grid) {
    int[][] dpNeg = new int[grid.length][grid[0].length];
    int[][] dpPostive = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print("[");
        // neg
        int topN = i > 0 ? dpNeg[i - 1][j] : 1;
        int leftN = j > 0 ? dpNeg[i][j - 1] : 1;
        //pos
        int topP = i > 0 ? dpPostive[i - 1][j] : 1;
        int leftP = j > 0 ? dpPostive[i][j - 1] : 1;

        int cur = grid[i][j];
        int min = min(cur * topN, cur * leftN, cur * topP, cur * leftP);
        dpNeg[i][j] = min;
        System.out.print(min + "/");

        int max = max(cur * topN, cur * leftN, cur * topP, cur * leftP);
        dpPostive[i][j] = max;

        System.out.print(max + "/");
        System.out.print("]");
      }
      System.out.println();
    }
    return dpPostive[grid.length - 1][grid[0].length - 1];
  }

  int min(int... num) {
    int ans = Integer.MAX_VALUE;
    for (int n : num)
      ans = Math.min(ans, n);
    return ans;
  }

  int max(int... num) {
    int ans = Integer.MIN_VALUE;
    for (int n : num)
      ans = Math.max(ans, n);
    return ans;
  }
}
