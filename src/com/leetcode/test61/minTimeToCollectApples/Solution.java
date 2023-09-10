package com.leetcode.test61.minTimeToCollectApples;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

//#1443
class Solution {
  public int minTime (int n, int[][] edges, List<Boolean> hasApple) {

    Map<Integer, Node> map = new HashMap<>();
    for (int[] pair : edges) {
      Node a = map.computeIfAbsent(pair[0], k -> new Node(pair[0], hasApple.get(pair[0])));
      Node b = map.computeIfAbsent(pair[1], k -> new Node(pair[1], hasApple.get(pair[1])));
      a.nextNodes.add(b);
      b.nextNodes.add(a);
    }
    AtomicInteger ans = new AtomicInteger();
    Set<Integer> visited = new HashSet<>();
    if(map.get(0) == null)
      return 0;
    findTime(ans, map.get(0), visited,true);
    return ans.get();
  }

  private boolean findTime (AtomicInteger i, Node node, Set<Integer> visited, boolean root) {
    if(visited.contains(node.id)){
      return false;
    }
    visited.add(node.id);
    if (node.nextNodes.isEmpty()) {
      return node.hasApple;
    }

    boolean hasApple = node.hasApple;

    for (Node n : node.nextNodes) {
      boolean found = findTime(i, n, visited, false);
      if (found) {
        i.incrementAndGet();
        i.incrementAndGet();
      }
      hasApple = hasApple || found;
    }
    return hasApple;
  }

  private static class Node {
    int id;
    boolean hasApple;
    List<Node> nextNodes;

    public Node (int id, boolean hasApple) {
      this.id = id;
      this.hasApple = hasApple;
      nextNodes = new ArrayList<>();
    }

    @Override public String toString () {
      return "Node{" + "id=" + id + ", hasApple=" + hasApple + '}';
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApple = List.of(false, false, true, false, false, true, false);

    int ans = s.minTime(3, edges, hasApple);
    System.out.println(ans);
  }
}
