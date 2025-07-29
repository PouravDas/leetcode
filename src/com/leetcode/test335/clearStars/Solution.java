package com.leetcode.test335.clearStars;


import java.util.Comparator;
import java.util.PriorityQueue;

//3170. Lexicographically Minimum String After Removing Stars
public class Solution {
  public String clearStars(String s) {
    PriorityQueue<MyObj> pq = new PriorityQueue<>(comparator);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != '*') {
        pq.offer(new MyObj(c, i));
        sb.append(c);
      } else {
        sb.append("_");
        MyObj o = pq.poll();
        sb.replace(o.i, o.i + 1, "_");
      }
    }

    return sb.toString().replace("_", "");
  }

  public static class MyObj {
    public char c;
    public int i;

    public MyObj(char c, int i) {
      this.c = c;
      this.i = i;
    }
  }

  Comparator<MyObj> comparator = ((o1, o2) -> o1.c - o2.c == 0 ? o2.i - o1.i : o1.c - o2.c);
}
