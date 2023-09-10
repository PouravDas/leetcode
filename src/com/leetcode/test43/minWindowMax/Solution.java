package com.leetcode.test43.minWindowMax;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
  public String minWindow (String s, String t) {

    Map<Character, Integer> needed = new HashMap<>();

    Map<Character, Integer> current = new HashMap<>();

    Queue<Integer> queque = new LinkedList<>();

    String ans = "";

    for (int i = 0; i < t.length(); i++) {
      add(t.charAt(i), needed);
    }

    int requiredCount = needed.size();
    int currentCount = 0;

    int pointer = 0;
    while (pointer < s.length()) {
      char c = s.charAt(pointer);
      if (needed.containsKey(c)) {
        queque.add(pointer);

        add(c, current);

        if (current.get(c).intValue() == needed.get(c).intValue()) {
          currentCount++;
        }

        if (currentCount == requiredCount) {
          int idx = queque.peek();
          ans = addToAns(ans, s.substring(idx, pointer + 1));
        }

        while (currentCount == requiredCount && !queque.isEmpty()) {
          int idx = queque.poll();
          char old = s.charAt(idx);
          remove(old, current);
          if (current.get(old).intValue() < needed.get(old).intValue()) {
            currentCount--;
          } else {
            ans = addToAns(ans, s.substring(queque.peek(), pointer + 1));
          }
        }
      }
      pointer++;
    }

    return ans;
  }

  private String addToAns (String ans, String str) {
    if ("".equals(ans)) {
      return str;
    }
    return ans.length() > str.length() ? str : ans;
  }

  private void add (char c, Map<Character, Integer> map) {
    map.compute(c, (k, v) -> {
      if (v != null) {
        return v + 1;
      } else {
        return 1;
      }
    });
  }

  private void remove (char c, Map<Character, Integer> map) {
    map.compute(c, (k, v) -> {
      if (v == 0) {
        return null;
      } else {
        return v - 1;
      }
    });
  }

  public static void main (String[] args) {

    Solution s = new Solution();
    String ans = s.minWindow("ADOBECODEBANC", "ABC");
    System.out.println(ans);
  }
}


