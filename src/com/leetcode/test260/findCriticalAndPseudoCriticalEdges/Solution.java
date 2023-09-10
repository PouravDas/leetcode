package com.leetcode.test260.findCriticalAndPseudoCriticalEdges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public List<List<Integer>> findCriticalAndPseudoCriticalEdges (int n, int[][] edges) {
    int[][] graph = new int[n][n];
    for (int[] e : edges) {
      graph[e[0]][e[1]] = e[2];
      graph[e[1]][e[0]] = e[2];
    }

    int orgMst = findMst(graph, null, null);

    List<Integer> critical = new ArrayList<>();
    List<Integer> pseudo = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      int eMst = findMst(graph, null, edges[i]);
      if (eMst > orgMst) {
        critical.add(i);
      } else {
        int excludeMst = findMst(graph, edges[i], null);
        if (excludeMst == orgMst) {
          pseudo.add(i);
        }
      }
    }
    return List.of(critical, pseudo);
  }

  int findMst (int[][] graph, int[] in, int[] ex) {
    boolean[] seen = new boolean[graph.length];
    int temp = -1;
    int ans = 0;
    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getW));
    if (in != null) {
      seen[in[0]] = true;
      seen[in[1]] = true;
      ans += graph[in[0]][in[1]];
      for (int i = 0; i < graph.length; i++) {
        if (graph[in[0]][i] > 0 && !seen[i]) {
          queue.add(new Pair(i, graph[in[0]][i]));
        }
      }
      for (int i = 0; i < graph.length; i++) {
        if (graph[in[1]][i] > 0 && !seen[i]) {
          queue.add(new Pair(i, graph[in[1]][i]));
        }
      }
    } else {
      queue.add(new Pair(0, 0));
    }
    if (ex != null) {
      temp = graph[ex[0]][ex[1]];
      graph[ex[0]][ex[1]] = 0;
      graph[ex[1]][ex[0]] = 0;
    }

    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      if (seen[p.v])
        continue;

      seen[p.v] = true;
      ans += p.w;
      for (int i = 0; i < graph.length; i++) {
        if (graph[p.v][i] > 0 && !seen[i]) {
          queue.add(new Pair(i, graph[p.v][i]));
        }
      }
    }

    if (ex != null) {
      graph[ex[0]][ex[1]] = temp;
      graph[ex[1]][ex[0]] = temp;
    }
    for (boolean s : seen) {
      if(!s) return Integer.MAX_VALUE;
    }
    return ans;
  }

  static class Pair {
    int v;
    int w;

    Pair (int v, int w) {
      this.v = v;
      this.w = w;
    }

    int getW () {
      return w;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.findCriticalAndPseudoCriticalEdges(5,new int[][]{{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}});
  }
}
