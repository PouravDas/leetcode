package com.leetcode.test288.minimumEffortPath;

import java.util.Arrays;
import java.util.PriorityQueue;

//1631. Path With Minimum Effort
//dijkstra algo
class Solution {
  public int minimumEffortPath (int[][] heights) {
    int[][] distance = new int[heights.length][heights[0].length];
    for (int[] d : distance)
      Arrays.fill(d, Integer.MAX_VALUE);
    distance[0][0] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, 0));
    while (!pq.isEmpty()) {
      Node n = pq.poll();
      int h = heights[n.x][n.y];
      if (n.x == heights.length - 1 && n.y == heights[0].length - 1)
        return h ;
      if (n.x > 0) {
        int w = Math.max(n.w, Math.abs(h - heights[n.x - 1][n.y]));
        if (w < distance[n.x - 1][n.y]) {
          distance[n.x - 1][n.y] = w;
          pq.offer(new Node(n.x - 1, n.y, w));
        }
      }
      if (n.y > 0) {
        int w = Math.max(n.w, Math.abs(h - heights[n.x][n.y - 1]));
        if (w < distance[n.x][n.y - 1]) {
          distance[n.x][n.y - 1] = w;
          pq.offer(new Node(n.x, n.y - 1, w));
        }
      }
      if (n.x < heights.length - 1) {
        int w = Math.max(n.w, Math.abs(h - heights[n.x + 1][n.y]));
        if (w < distance[n.x + 1][n.y]) {
          distance[n.x + 1][n.y] = w;
          pq.offer(new Node(n.x + 1, n.y, w));
        }
      }
      if (n.y < heights[0].length - 1) {
        int w = Math.max(n.w, Math.abs(h - heights[n.x][n.y + 1]));
        if (w < distance[n.x][n.y + 1]) {
          distance[n.x][n.y + 1] = w;
          pq.offer(new Node(n.x, n.y + 1, w));
        }
      }
    }
    return -1;
  }

  private static class Node implements Comparable<Node> {
    int x, y, w;

    Node (int x, int y, int w) {
      this.x = x;
      this.y = y;
      this.w = w;
    }

    @Override public int compareTo (Node o) {
      return this.w - o.w;
    }

    @Override public String toString () {
      return "Node{" + "x=" + x + ", y=" + y + ", w=" + w + '}';
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    //s.minimumEffortPath(new int[][] {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
    s.minimumEffortPath(new int[][] {{1,2,1,1,1},{1,2,1,2,1},{1,1,1,2,1}});
  }
}
