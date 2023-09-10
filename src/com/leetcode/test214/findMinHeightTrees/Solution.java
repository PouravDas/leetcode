package com.leetcode.test214.findMinHeightTrees;

//310. Minimum Height Trees
import java.util.*;

class Solution {

  public List<Integer> findMinHeightTrees (int n, int[][] edges) {
    if(n== 1) return List.of(0);
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    int[] inorder = new int[n];

    for (int[] e : edges) {
      inorder[e[0]]++;
      inorder[e[1]]++;
      adj.get(e[0]).add(e[1]);
      adj.get(e[1]).add(e[0]);
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < inorder.length; i++) {
      if(inorder[i] == 1) queue.offer(i);
    }

    List<Integer> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      ans = new ArrayList<>(queue);
      int size = queue.size();
      while(size-- > 0) {
        int v = queue.poll();
        for(int to : adj.get(v)) {
          if(--inorder[to] == 1) {
            queue.offer(to);
          }
        }
      }
    }
    return ans;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}});
  }
}
