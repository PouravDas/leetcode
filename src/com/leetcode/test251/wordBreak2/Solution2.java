package com.leetcode.test251.wordBreak2;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution2 {

  public boolean wordBreak(String s, List<String> wordDict) {
    List<Integer> lengths = wordDict.stream().map(String::length).distinct().sorted(Comparator.reverseOrder()).toList();
    Set<String> words = new HashSet<>(wordDict);
    Boolean[] dp = new Boolean[s.length()];
    return wordBreak(s, 0, lengths, words, dp);
  }

  boolean wordBreak(String s, int idx, List<Integer> lengths, Set<String> words, Boolean[] dp) {
    if (idx >= s.length()) return true;
    if (dp[idx] != null) return dp[idx];
    boolean found = false;
    for (int l : lengths) {
      String word = getWord(s, idx, l);
      if (words.contains(word)) {
        found = wordBreak(s, idx + l, lengths, words, dp);
        if (found) {
          break;
        }
      }
    }
    return dp[idx] = found;
  }

  private String getWord(String s, int idx, int l) {
    if (idx + l > s.length()) return null;
    return s.substring(idx, idx + l);
  }
}
