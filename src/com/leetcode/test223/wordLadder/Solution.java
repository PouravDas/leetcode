package com.leetcode.test223.wordLadder;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Solution {
  public int ladderLength (String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> map = new HashMap<>();
    wordList.forEach(w -> addToMap(w, map));
    Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int ladder = 1;
    final AtomicBoolean found = new AtomicBoolean(false);
    while (!queue.isEmpty()){
      int size = queue.size();
      ladder++;
      while (size-- > 0) {
        String v = queue.poll();
        getAllPattern(v).forEach(p -> {
          Set<String> next = map.remove(p);
          if(Objects.nonNull(next)) {
            next.forEach(n -> {
              if(n.equals(endWord)) {
                found.set(true);
              }
              if(!visited.contains(n)) {
                queue.add(n);
                visited.add(n);
              }
            });
          }
        });
        if (found.get()){
          return ladder;
        }
      }
    }
    return 0;
  }

  private void addToMap (String w, Map<String, Set<String>> map) {
    getAllPattern(w).forEach(p -> {
      if (!map.containsKey(p)) {
        map.put(p, new HashSet<>());
      }
      map.get(p).add(w);
    });
  }

  private List<String> getAllPattern (String w) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < w.length(); i++) {
      list.add(w.substring(0, i) + "*" + (i < w.length() - 1 ? w.substring(i + 1) : ""));
    }
    return list;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.ladderLength("hit","cog", List.of("hot","dot","dog","lot","log","cog"));
  }
}
