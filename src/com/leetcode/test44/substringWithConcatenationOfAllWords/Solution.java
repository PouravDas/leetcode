package com.leetcode.test44.substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<Integer> findSubstring (String s, String[] words) {

    List<Integer> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    int size = 0;
    for (String w : words) {
      add(map, w);
      size++;
    }

    int l = 0;
    int length = words[0].length();
    int r = length;
    while (r <= s.length()) {

      if (map.containsKey(s.substring(l, r))) {
        Map<String, Integer> copyMap = new HashMap(map);
        remove(copyMap, s.substring(l, r));
        int count = 1;
        boolean found = true;
        int next = r;

        while (found && count < size) {
          if ((next + length) <= s.length() && remove(copyMap, s.substring(next, next + length))) {
            count++;
            next += length;
          } else {
            found = false;
            break;
          }
        }

        if (found) {
          list.add(l);
        }
      }
      l++;
      r++;
    }
    return list;
  }

  private void add (Map<String, Integer> map, String w) {
    map.compute(w, (k, v) -> {
      if (v == null)
        return 1;
      else
        return v + 1;
    });
  }

  private boolean remove (Map<String, Integer> map, String w) {
    if (!map.containsKey(w))
      return false;
    else {
      map.compute(w, (k, v) -> {
        if (v == 1)
          return null;
        else
          return v - 1;
      });
      return true;
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    String[] words = {"a"};
    System.out.println(s.findSubstring("a", words));
  }
}
