package com.leetcode.test252.findAllConcatenatedWordsInADict;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  Set<String> set = new HashSet<>();

  public List<String> findAllConcatenatedWordsInADict (String[] words) {
    List<String> result = new ArrayList<>();
    for (String w : words)
      set.add(w);
    for (String w : words) {
      set.remove(w);
      if (hasConcatenatedWords(w))
        result.add(w);
      set.add(w);
    }
    return result;
  }

  boolean hasConcatenatedWords (String s) {
    for (int i = 1; i <= s.length(); i++) {
      String suf = s.substring(i);
      String pre = s.substring(0, i);
      if ((set.contains(pre) && hasConcatenatedWords(suf)) || (set.contains(suf) && set.contains(pre)))
        return true;
    }
    return false;
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    s.findAllConcatenatedWordsInADict(new String[] {"cat", "cats", "s"});
  }
}
