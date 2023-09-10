package com.leetcode.test154.findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//187. Repeated DNA Sequences
// sliding window / two pointers
class Solution {
  public List<String> findRepeatedDnaSequences (String s) {
    List<String> list = new ArrayList<>();
    if (s.length() < 10) {
      return list;
    }
    int start = 0;
    int end = 10;
    Map<String, Boolean> map = new HashMap<>();
    while (end <= s.length()) {
      String sequence = s.substring(start, end);
      if (map.containsKey(sequence)) {
        if (!map.get(sequence)) {
          list.add(sequence);
          map.put(sequence, true);
        }
      } else {
        map.put(sequence, false);
      }
      start++;
      end++;
    }
    return list;
  }
}
