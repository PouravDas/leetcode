package com.leetcode.test329.closestMeetingNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;

public class Solution {
  public int closestMeetingNode(int[] edges, int node1, int node2) {
    ArrayList<Integer> fromOne = new ArrayList<>();
    ArrayList<Integer> fromTwo = new ArrayList<>();
    int next = node1;
    while (next != -1 && edges[next] != next) {
      fromOne.add(next);
      next = edges[next];
    }
    next = node2;
    while (next != -1 && edges[next] != next) {
      fromTwo.add(next);
      next = edges[next];
    }
    Map<Integer, Integer> distance = new HashMap<>();
    for (int i = 0; i < fromOne.size(); i++) {
      distance.put(fromOne.get(i), i);
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < fromTwo.size(); i++) {
      if (distance.containsKey(fromTwo.get(i)))
        map.put(fromTwo.get(i), distance.get(fromTwo.get(i)) - i);
    }
    Optional<Integer> max = map.values().stream().max(Integer::compareTo);
    if (max.isPresent()) {
      Optional<Integer> min = map.entrySet().stream().filter(e -> Objects.equals(e.getValue(), max.get())).map(Map.Entry::getKey).min(Integer::compareTo);
      if (min.isPresent()) return min.get();
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //s.closestMeetingNode(new int[]{2,2,3,-1}, 0,1);
    s.closestMeetingNode(new int[]{4, 3, 0, 5, 3, -1}, 4, 0);
  }
}
