package com.leetcode.test21.courseSchedule.topSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//after DSA Anuj bhaiya ka gyaan
//using kahn's algo
class Solution2 {
  public int[] findOrder (int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjacency = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjacency.add(new ArrayList<>());
    }
    int[] inorder = new int[numCourses];
    for (int[] pre : prerequisites) {
      adjacency.get(pre[1]).add(pre[0]);
      inorder[pre[0]]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == 0)
        queue.offer(i);
    }
    List<Integer> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      int v = queue.poll();
      ans.add(v);
      for(int n : adjacency.get(v)){
        if(--inorder[n] == 0) {
          queue.offer(n);
        }
      }
    }
    if(ans.size() == numCourses) {
      return ans.stream().mapToInt(i -> i).toArray();
    }
    return new int[]{};
  }
}
