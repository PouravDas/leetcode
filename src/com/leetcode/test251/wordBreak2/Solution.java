package com.leetcode.test251.wordBreak2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> wordBreak (String s, List<String> wordDict) {
    List<String>[] dp = new List[s.length()];
    return wordBreak(s, 0, wordDict, dp);
  }

  List<String> wordBreak (String s, int i, List<String> wordDict, List<String>[] dp) {
    if(dp[i] != null) return dp[i];
    List<String> result = new ArrayList<>();
    for (String word : wordDict) {
      if (i + word.length() > s.length())
        continue;
      if (s.substring(i, i + word.length()).equals(word)) {
        if (i + word.length() == s.length()) {
          result.add(word);
        } else {
          List<String> list = wordBreak(s, i + word.length(), wordDict, dp);
          list.forEach(e -> result.add(word + " " + e));
        }
      }
    }
    return dp[i] = result;
  }
}
