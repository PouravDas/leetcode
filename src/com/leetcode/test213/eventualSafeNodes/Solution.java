package com.leetcode.test213.eventualSafeNodes;

import java.util.*;

class Solution {
  Set<Integer> safeNodes = new HashSet<>();
  Set<Integer> unsafeNodes = new HashSet<>();

  public List<Integer> eventualSafeNodes (int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      isSafeDfs(i, graph, new HashSet<>());
    }
    List<Integer> list = new ArrayList<>(safeNodes);
    list.sort(Comparator.naturalOrder());
    return list;
  }

  private boolean isSafeDfs (int i, int[][] graph, Set<Integer> visited) {
    if (!visited.contains(i)) {
      if (safeNodes.contains(i))
        return true;
      if (unsafeNodes.contains(i))
        return false;
      visited.add(i);
      boolean safe = true;
      if (graph[i].length == 0) {
        safeNodes.add(i);
      } else {
        for (int j = 0; j < graph[i].length; j++) {
          safe &= isSafeDfs(graph[i][j], graph, visited);
        }
        if (safe)
          safeNodes.add(i);
        else
          unsafeNodes.add(i);
      }
      visited.remove(i);
      return safe;
    } else {
      unsafeNodes.add(i);
      return false;
    }
  }
}
