package com.leetcode.test217.allPathsSourceTarget;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public List<List<Integer>> allPathsSourceTarget (int[][] graph) {
    List<List<Integer>> mainList = new ArrayList<>();
    dfs(0, graph, new boolean[graph.length], mainList, new ArrayList<>());
    return mainList;
  }

  void dfs (int v, int[][] graph, boolean[] visited, List<List<Integer>> mainList,
      List<Integer> currList) {
    if (!visited[v]) {
      visited[v] = true;
      currList.add(v);
      if (v == graph.length - 1) {
        mainList.add(new ArrayList<>(currList));
      }
      for (int i : graph[v]) {
        dfs(i, graph, visited, mainList, currList);
      }
      currList.remove(currList.size() - 1);
      visited[v] = false;
    }
  }
}
