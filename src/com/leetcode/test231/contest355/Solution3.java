package com.leetcode.test231.contest355;

import java.util.*;

//2790. Maximum Number of Groups With Increasing Length
public class Solution3 {
  //my solution TLE
  public int maxIncreasingGroups_ (List<Integer> usageLimits) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < usageLimits.size(); i++) {
      queue.add(usageLimits.get(i));
    }

    int size = 1;
    while (size <= queue.size()) {
      List<Integer> addBack = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        int p = queue.poll();
        if (--p > 0) {
          addBack.add(p);
        }
      }
      size++;
      queue.addAll(addBack);
    }
    return size - 1;
  }

  // solution from discussion
  public int maxIncreasingGroups (List<Integer> usageLimits) {
    Collections.sort(usageLimits);
    long total = 0;
    int count = 0;

    for (int u : usageLimits) {
      total += u;
      if (total >= (count + 1) * (count + 2) / 2)
        count++;
    }
    return count;
  }

  public static void main (String[] args) {
    Solution3 s = new Solution3();
    s.maxIncreasingGroups(List.of(1, 2, 5));
  }
}
