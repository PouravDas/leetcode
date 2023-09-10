package com.leetcode.test97.LongestWordInDictionarythroughDeleting;

import java.util.ArrayList;
import java.util.List;

// # 524
class Solution {
  public String findLongestWord (String s, List<String> dictionary) {
    int maxLen = 0;
    List<String> ans = new ArrayList<>();
    for (String word : dictionary) {
      int i = 0;
      int j = 0;
      if (word.length() > s.length()) {
        continue;
      }
      while (i < word.length() && j < s.length()) {
        if (word.charAt(i) == s.charAt(j)) {
          i++;
        }
        j++;
      }
      if (i == word.length() && word.length() >= maxLen) {
        if (word.length() > maxLen)
          ans.clear();
        ans.add(word);
        maxLen = word.length();
      }
    }
    if (ans.isEmpty())
      return "";
    else
      return ans.stream().sorted().findFirst().get();
  }
}
