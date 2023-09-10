package com.leetcode.test224.wordLadder2;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Solution {

  public List<List<String>> findLadders (String beginWord, String endWord, List<String> wordList) {
    Map<String, Set<String>> map = new HashMap<>();
    wordList.forEach(w -> addToMap(w, map));
    Queue<Entry> queue = new ArrayDeque<>();
    List<List<String>> mainList = new ArrayList<>();
    queue.add(new Entry());
    queue.peek().list.add(beginWord);
    queue.peek().set.add(beginWord);
    final AtomicBoolean found = new AtomicBoolean(false);
    while (!queue.isEmpty() && !found.get()) {
      int size = queue.size();
      while (size-- > 0) {
        Entry v = queue.poll();
        getAllPattern(v.list.get(v.list.size() - 1)).forEach(p -> {
          Set<String> next = map.get(p);
          if (Objects.nonNull(next)) {
            next.forEach(n -> {
              if (!v.set.contains(n)) {
                Entry l = new Entry(v);
                l.list.add(n);
                l.set.add(n);
                if (n.equals(endWord)) {
                  found.set(true);
                  mainList.add(l.list);
                } else
                  queue.add(l);
              }
            });
          }
        });
      }
    }
    return mainList;
  }

  private static class Entry {
    List<String> list;
    Set<String> set;

    Entry () {
      list = new ArrayList<>();
      set = new HashSet<>();
    }

    Entry (Entry e) {
      list = new ArrayList<>(e.list);
      set = new HashSet<>(e.set);
    }
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
    List<List<String>> list =
        s.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println();
  }
}

