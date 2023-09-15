package com.leetcode.test287.minCostConnectPoints;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//1584. Min Cost to Connect All Points
// medium (minimum spanning tree)
class Solution {
  public int minCostConnectPoints (int[][] points) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
    Set<Integer> notVisited = new HashSet<>();
    for (int i = 0; i < points.length; i++) {
      notVisited.add(i);
    }
    pq.offer(new int[] {0, 0});
    int len = 0;
    while (!notVisited.isEmpty()) {
      int[] p = pq.poll();
      if (notVisited.contains(p[0])) {
        notVisited.remove(p[0]);
        len += p[1];
        for (int i = 0; i < points.length; i++) {
          if (!notVisited.contains(i))
            continue;
          int[] point = points[i];
          int dis = Math.abs(points[p[0]][0] - point[0]) + Math.abs(points[p[0]][1] - point[1]);
          pq.add(new int[] {i, dis});
        }
      }
    }
    return len;
  }
}
