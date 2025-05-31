package com.leetcode.test328.checkInclusion;

import java.util.HashMap;
import java.util.Map;

//567. Permutation in String
public class Solution {
  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s1.toCharArray()) {
      map.compute(c, (k, v) -> v == null ? 1 : v + 1);
    }
    int start = 0, end = 0;
    while (end < s2.length()) {
      if (map.isEmpty()) return true;
      if (map.containsKey(s2.charAt(end))) {
        Integer remove = map.remove(s2.charAt(end));
        if (remove > 1) map.put(s2.charAt(end), remove - 1);
        end++;
      } else if (start == end) {
        start++;
        end++;
      } else {
        map.compute(s2.charAt(start), (k, v) -> v == null ? 1 : v + 1);
        start++;
      }
    }
      return map.isEmpty();
  }
}