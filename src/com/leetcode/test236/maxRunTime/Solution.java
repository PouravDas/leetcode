package com.leetcode.test236.maxRunTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//2141. Maximum Running Time of N Computers
//hard
class Solution {
  public long maxRunTime (int n, int[] batteries) {
    int totalTime = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int b : batteries)
      queue.offer(b);

    while (queue.size() >= n) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < n - 1; i++) {
        list.add(queue.poll());
      }
      int min = queue.poll();
      totalTime += min;
      for (int l : list) {
        if (l - min > 0)
          queue.offer(l - min);
      }
    }
    return totalTime;
  }
}
