package com.leetcode.test261.sortItems;

import java.util.*;

//1203. Sort Items by Groups Respecting Dependencies
//hard topological sorting
class Solution {
  public int[] sortItems (int n, int m, int[] group, List<List<Integer>> beforeItems) {
    //values depends on key
    Map<Integer, Set<Integer>> dependencies = new HashMap<>();
    Map<Integer, Set<Integer>> groupDep = new HashMap<>();
    Map<Integer, List<Integer>> groupToList = new HashMap<>();

    for (int i = 0; i < group.length; i++) {
      if (group[i] == -1)
        group[i] = m++;
    }

    for (int i = 0; i < m; i++) {
      groupDep.put(i, new HashSet<>());
      groupToList.put(i, new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      dependencies.put(i, new HashSet<>());
    }

    for (int i = 0; i < beforeItems.size(); i++) {
      for (int e : beforeItems.get(i)) {
        dependencies.get(e).add(i);
        if (group[e] != group[i])
          groupDep.get(group[e]).add(group[i]);
      }
    }

    boolean[] visited = new boolean[m];
    boolean[] recStack = new boolean[m];
    for (int i = 0; i < m; i++) {
      if (hasCycle(visited, recStack, i, groupDep))
        return new int[] {};
    }

    visited = new boolean[n];
    recStack = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (hasCycle(visited, recStack, i, dependencies))
        return new int[] {};
    }

    //topSort
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    visited = new boolean[m];
    for (int i = 0; i < m; i++) {
      dfs(visited, i, groupDep, null, stack);
    }
    int[] groupSort = new int[m];
    int idx = 0;
    while (!stack.isEmpty()) {
      groupSort[idx++] = stack.pop();
    }

    stack = new ArrayDeque<>();
    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      dfs(visited, i, dependencies, group, stack);
    }

    int[] itemSort = new int[n];
    int[] ans = new int[n];
    idx = 0;
    while (!stack.isEmpty()) {
      itemSort[idx++] = stack.pop();
    }

    for (int item : itemSort) {
      groupToList.get(group[item]).add(item);
    }
    idx = 0;
    for (int g : groupSort) {
      for(int l : groupToList.get(g))
        ans[idx++] = l;
    }
    return ans;
  }

  private void dfs (boolean[] visited, int i, Map<Integer, Set<Integer>> dependencies, int[] group,
      ArrayDeque<Integer> stack) {
    if (!visited[i]) {
      visited[i] = true;
      if (group == null) {
        for (int next : dependencies.get(i)) {
          dfs(visited, next, dependencies, null, stack);
        }
      } else {
        for (int next : dependencies.get(i)) {
          if (group[next] != group[i]) {
            dfs(visited, next, dependencies, group, stack);
          }
        }
        for (int next : dependencies.get(i)) {
          if (group[next] == group[i]) {
            dfs(visited, next, dependencies, group, stack);
          }
        }
      }
      stack.push(i);
    }
  }

  private boolean hasCycle (boolean[] visited, boolean[] recStack, int i,
      Map<Integer, Set<Integer>> map) {
    if (recStack[i])
      return true;
    if (!visited[i]) {
      visited[i] = true;
      recStack[i] = true;
      for (int next : map.get(i)) {
        if (hasCycle(visited, recStack, next, map))
          return true;
      }
      recStack[i] = false;
    }
    return false;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    List<List<Integer>> before = new ArrayList<>();
    //[[],[6],[5],[6],[3,6],[],[],[]]
    before.add(List.of());
    before.add(List.of(6));
    before.add(List.of(5));
    before.add(List.of(6));
    before.add(List.of(3, 6));
    before.add(List.of());
    before.add(List.of());
    before.add(List.of());
    s.sortItems(8, 2, new int[] {-1, -1, 1, 0, 0, 1, 0, -1}, before);
  }
}
