package com.leetcode.test341.maxSubsequence;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
  PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
  int size = 0;

  public int[] maxSubsequence(int[] nums, int k) {
    size = k;
    for (int i = 0; i < nums.length; i++) {
      add(nums[i], i);
    }
    int[] ans = new int[k];
    AtomicInteger i = new AtomicInteger();
    priorityQueue.stream().sorted(Comparator.comparingInt(p -> p.idx)).forEach(p -> ans[i.getAndIncrement()] = p.val);
    return ans;
  }

  public void add(int val, int idx) {
    priorityQueue.add(new Pair(val, idx));
    if (priorityQueue.size() > size) {
      priorityQueue.poll();
    }
  }

  private static class Pair implements Comparable<Pair> {
    int val;
    int idx;

    Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    @Override
    public int compareTo(Pair o) {
      return this.val - o.val;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return val == pair.val && idx == pair.idx;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, idx);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.maxSubsequence(new int[]{2, 1, 3, 3}, 2);
  }

  public int findLucky(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : arr)
      map.compute(a, (k, v) -> v == null ? 1 : v + 1);

    Optional<Map.Entry<Integer, Integer>> max = map.entrySet().stream().filter(e -> e.getKey().equals(e.getValue())).max((e1, e2) -> e1.getKey() - e2.getKey());
    if (max.isPresent()) return max.get().getKey();
    else return -1;
  }
}
