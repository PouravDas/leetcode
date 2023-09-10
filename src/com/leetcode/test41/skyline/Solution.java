package com.leetcode.test41.skyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution {

  public List<List<Integer>> getSkyline (int[][] buildings) {

    List<List<Integer>> ans = new ArrayList<>();
    List<Point> points = new ArrayList<>();
    for (int[] b : buildings) {
      points.add(new Point(b[0], b[2], true));
      points.add(new Point(b[1], b[2], false));
    }
    Collections.sort(points);

    TreeMap<Integer, Integer> queue = new TreeMap<>();

    queue.put(0, 1);

    int prevMaxHeight = 0;
    for (Point p : points) {

      if (p.start) {
        queue.compute(p.height, (k, v) -> {
          if (v != null) {
            return v + 1;
          } else {
            return 1;
          }
        });
      } else {
        queue.compute(p.height, (k, v) -> {
          if (v == 1) {
            return null;
          } else {
            return v - 1;
          }
        });
      }

      int currentMaxHeight = queue.lastKey();
      if (prevMaxHeight != currentMaxHeight) {
        ans.add(List.of(p.x, currentMaxHeight));
        prevMaxHeight = currentMaxHeight;
      }
    }
    return ans;
  }

  public static void main (String[] args) {

    int[][] buildings = {{1, 2, 1}, {1, 2, 2}, {1, 2, 3}};
    // {{0,2,3},{2,5,3}}
    // {{1,2,1},{1,2,2},{1,2,3}}
    // {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    Solution s = new Solution();

    System.out.println(s.getSkyline(buildings));
  }

  private class Point implements Comparable<Point> {
    int x;
    int height;
    boolean start;

    public Point(int x, int height, boolean start) {
      this.x = x;
      this.height = height;
      this.start = start;
    }

    @Override
    public String toString () {
      return "Point [x=" + x + ", height=" + height + ", start=" + start + "]";
    }

    @Override
    public int compareTo (Point p) {
      if (this.x != p.x) {
        return this.x - p.x;
      }
      /*
       * else if (this.height == p.height) { if(this.start){ return -1; } else return 0; } else if
       * (this.start == p.start) { return p.height - this.height; } else if (this.start) { return
       * p.height - this.height; } else { return this.height - p.height; }
       */
      else {
        return (this.start ? -this.height : this.height) - (p.start ? -p.height : p.height);
      }
    }
  }
}
