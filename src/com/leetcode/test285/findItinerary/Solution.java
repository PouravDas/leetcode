package com.leetcode.test285.findItinerary;

import java.util.*;

// 332. Reconstruct Itinerary
// hard
class Solution {
  public List<String> findItinerary (List<List<String>> tickets) {
    Map<String, Node> map = new HashMap<>();
    String start = "JFK";
    for (List<String> t : tickets) {
      Node from = map.getOrDefault(t.get(0), new Node(t.get(0)));
      Node to = map.getOrDefault(t.get(1), new Node(t.get(1)));
      from.next.add(to.id);
      map.put(from.id, from);
      map.put(to.id, to);
    }
    map.entrySet().forEach(e -> Collections.sort(e.getValue().next));
    List<String> itinerary = new ArrayList<>();
    itinerary.add(start);
    Node curr = map.get(start);
    itinerary = findItinerary(tickets.size() + 1, itinerary, curr, map);
    return itinerary;
  }

  List<String> findItinerary (int size, List<String> itinerary, Node curr, Map<String, Node> map) {
    if (curr.next.isEmpty())
      return itinerary;

    for (int i = 0; i < curr.next.size(); i++) {
      String next = curr.next.get(i);
      curr.next.remove(i);
      itinerary.add(next);
      List<String> newIt = findItinerary(size, new ArrayList<>(itinerary), map.get(next), map);
      if (newIt.size() == size)
        return newIt;
      curr.next.add(i, next);
      itinerary.remove(itinerary.size() - 1);
    }
    return itinerary;
  }

  static class Node {
    String id;
    List<String> next;

    Node (String id) {
      this.id = id;
      next = new ArrayList<>();
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    List<List<String>> list = new ArrayList<>();
    list.add(List.of("MUC", "LHR"));
    list.add(List.of("JFK", "MUC"));
    list.add(List.of("SFO", "SJC"));
    list.add(List.of("LHR", "SFO"));
    s.findItinerary(list);
  }
}
