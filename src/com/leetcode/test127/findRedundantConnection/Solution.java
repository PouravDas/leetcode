package com.leetcode.test127.findRedundantConnection;

import java.util.*;

//#684. Redundant Connection
class Solution {
  public int[] findRedundantConnection (int[][] edges) {

    Map<Integer, Node> map = new HashMap<>();
    for (int[] e : edges) {
      int start = e[0];
      int end = e[1];
      Node startNode = map.get(start);
      if (startNode == null) {
        startNode = new Node(start);
        map.put(start, startNode);
      }

      Node endNode = map.get(end);
      if (endNode == null) {
        endNode = new Node(end);
        map.put(end, endNode);
      }
      startNode.next.add(endNode);
      endNode.next.add(startNode);

      if (dfs(startNode, endNode, endNode, new HashSet<>()))
        return e;
    }
    return null;
  }

  private boolean dfs (Node start, Node target, Node parent, Set<Integer> set) {
    set.add(start.data);
    for (Node n : start.next) {
      if (n == parent)
        continue;
      if (n.data == target.data) {
        return true;
      } else if (!set.contains(n.data)) {
        if (dfs(n, target, start, set))
          return true;
      }
    }
    return false;
  }

  private static class Node {
    int data;
    List<Node> next;

    Node (int d) {
      next = new ArrayList<>();
      data = d;
    }

    @Override public String toString () {
      return "Node{" + "data=" + data + '}';
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}});
  }
}
